package com.magewell.avcapture2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.*;
import java.nio.ByteBuffer;   
import java.nio.CharBuffer;   
import java.nio.channels.FileChannel;   
import java.nio.charset.Charset; 
//import sun.nio.ch.DirectBuffer;  

import com.magewell.libmwcapture.*;

public class AVCapture2 extends JFrame implements MWCaptureCallback {
	private static final long serialVersionUID = 1L;
	private static final long NULL = 0;
	private static final long INFINITE = 0xFFFFFFFF;
	private static final long WAIT_OBJECT_0 = 0;
	private static final long WAIT_FAILED = 0xFFFFFFFF;
	private static final long NOTIFY_VIDEO_SIGNAL_CHANGE = 0x0020L;
	private static final long NOTIFY_AUDIO_SIGNAL_CHANGE = 0x0040L;
	private static final long NOTIFY_AUDIO_FRAME_BUFFERED= 0x1000L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int[][] VIDEOSIZE = {{720, 576}, {1280, 720}, {1920, 1080}};
	private static final double[] FRAMERATE  = {30.00, 60.00};
	private static final String[] COLORSPACE = {"YUY2", "I420", "BGRA"};
	
	private static final int CAPTURE_WIDTH = VIDEOSIZE[1][0];
	private static final int CAPTURE_HEIGHT = VIDEOSIZE[1][1];
	private static final double FRAME_RATE = FRAMERATE[0];
	private static final String CAPTURE_COLORSPACE = COLORSPACE[2];
	private static final long m_dwFourcc = LibMWCapture.MWGetFourcc(CAPTURE_COLORSPACE);
	
	private static final int m_nSamplesPerSec = 48000;
	private static final int m_nChannels = 2;
	private static final int m_wBitsPerSample = 16;
	private static final int m_nSamplesPerFrame = 480;
	
	protected long m_hChannel = NULL;
	protected long m_hVideoCapture = NULL;
	protected long m_hAudioCapture = NULL;
	protected long m_hWnd = NULL;
	protected long m_hD3dRenderer = NULL;
	protected long m_hDSoundRenderer = NULL;
	protected boolean m_bCapturing = false;
	
	protected String m_strColorSpace = CAPTURE_COLORSPACE;
	protected static double m_dbCurrentFPS = FRAME_RATE;
	protected static long m_dwLast;
	protected static int m_nLastFrameCount;
	
	private JApplet m_PriviewApplet;
	private JLabel m_VideoInfoLabel;
	private Timer m_FPSTimer;
	
	public AVCapture2() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent  e) {
				StopCapture();
				DestroyVideoRenderer();
				
				if (m_hDSoundRenderer != NULL) {
					LibMWCapture.MWDestroyDSoundRenderer(m_hDSoundRenderer);
					m_hDSoundRenderer = NULL;
				}
				
				LibMWCapture.ExitNative();
				LibMWCapture.MWCaptureExitInstance();
			}
			
			public void windowActivated(WindowEvent e) {
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
			}
			
			public void componentMoved(ComponentEvent e) {
			}
		});
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
	
		JPanel statusPane = InitStatusPane();
		m_PriviewApplet = new JApplet();
		m_PriviewApplet.setIgnoreRepaint(true);
		
		contentPane.add(m_PriviewApplet, BorderLayout.CENTER);
		contentPane.add(statusPane, BorderLayout.SOUTH);
		
		this.setTitle("AVCapture2");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((dimension.width - WIDTH) / 2, (dimension.height - HEIGHT) / 2, WIDTH, HEIGHT);
		this.setVisible(true);
		
		m_FPSTimer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateVideoInfo(CAPTURE_COLORSPACE, CAPTURE_WIDTH, CAPTURE_HEIGHT, m_dbCurrentFPS);
			}
		});
		m_FPSTimer.start();
		
		long hWnd = LibMWCapture.GetJavaWnd(m_PriviewApplet);		
		if (hWnd != NULL) 
			m_hWnd = hWnd;
		
		if (!CreateVideoRenderer()) {
			JOptionPane.showMessageDialog(null, "Init D3DRenderer fail!", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		m_hDSoundRenderer = LibMWCapture.MWCreateDSoundRenderer(m_nSamplesPerSec, m_nChannels, m_nSamplesPerFrame, 10);
	
		if (!StartCapture()) {
			JOptionPane.showMessageDialog(null, "Start Capture fail!!", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	public JPanel InitStatusPane() {
		JPanel statusPane = new JPanel();
		statusPane.setPreferredSize(new Dimension(this.getWidth(), 25));
		statusPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 4));
		statusPane.setBorder(BorderFactory.createLineBorder(new Color(0xcccccc), 1));
		
		m_VideoInfoLabel = new JLabel();
		statusPane.add(m_VideoInfoLabel, BorderLayout.EAST);
	
		return statusPane;
	}
	
	public void UpdateVideoInfo(String strColorSpace, int nWidth, int nHeight, double dbFrameRate) {
		DecimalFormat format = new DecimalFormat("#.00");
		String strVideoInfo = "Resolution: " + nWidth + "x" + nHeight + "    " 
		+ "Color Space: " + strColorSpace + "    " 
		+ "FPS: " + format.format(dbFrameRate);
		
		m_VideoInfoLabel.setText(strVideoInfo);
	}
	
	public boolean CreateVideoRenderer() {
		m_hD3dRenderer = LibMWCapture.MWCreateD3DRenderer(CAPTURE_WIDTH, CAPTURE_HEIGHT, m_dwFourcc, m_hWnd);
		if (m_hD3dRenderer == NULL) {
			return false;
		}
		
		return true;
	}
	
	public void DestroyVideoRenderer() {
		if (m_hD3dRenderer != NULL) {
			LibMWCapture.MWDestroyD3DRenderer(m_hD3dRenderer);
			m_hD3dRenderer = NULL;
		}
	}
	
	public boolean StartCapture() {
		m_hChannel = LibMWCapture.MWOpenChannelByIndex(0);
		System.out.println("m_hChannel = " + m_hChannel);
		if (m_hChannel == NULL)
			return false;
		
		m_bCapturing = true;
		
		long cbStride = LibMWCapture.FOURCC_CalcMinStride(m_dwFourcc, CAPTURE_WIDTH, 4);
		long cbFrame = LibMWCapture.FOURCC_CalcImageSize(m_dwFourcc, CAPTURE_WIDTH, CAPTURE_HEIGHT, cbStride);
		
		m_hVideoCapture = LibMWCapture.MWCreateVideoCapture(m_hChannel, CAPTURE_WIDTH, CAPTURE_HEIGHT, (int)m_dwFourcc, 10000000/(int)m_dbCurrentFPS, AVCapture2.this);
		m_hAudioCapture = LibMWCapture.MWCreateAudioCapture(m_hChannel, 0, m_nSamplesPerSec, m_wBitsPerSample, m_nChannels, AVCapture2.this);
		
		return true;
	}
	
	public void StopCapture() {
		
		m_bCapturing = false;
				
		if (m_hVideoCapture != NULL) {
			//LibMWCapture.MWDestoryVideoCapture(m_hVideoCapture);
			m_hVideoCapture = NULL;
		}
				
		if (m_hAudioCapture != NULL) {
			LibMWCapture.MWDestoryAudioCapture(m_hAudioCapture);
			m_hAudioCapture = NULL;
		}
		
		if (m_hChannel != NULL) {
			LibMWCapture.MWCloseChannel(m_hChannel);
			m_hChannel = NULL;
		}
	}
	
	public static void main(String[] args) {
		LibMWCapture.InitNative();
		LibMWCapture.MWCaptureInitInstance();
		
		int nChannelCount = LibMWCapture.MWGetChannelCount();
		if (nChannelCount > 0) {
			new AVCapture2();
		}else {
			JOptionPane.showMessageDialog(null, "Can't find device!", "Error", JOptionPane.ERROR_MESSAGE);
			LibMWCapture.ExitNative();
			LibMWCapture.MWCaptureExitInstance();
		}
	}
	
		@Override
  	public void OnVideoCapture(byte[] pbFrame, int cbFrame, long timeStamp) {
    	//System.out.println("video cbFrame:" + cbFrame + " timeStamp:" + timeStamp);
			
    	long cbStride = LibMWCapture.FOURCC_CalcMinStride(m_dwFourcc, CAPTURE_WIDTH, 4);
    	if (m_hD3dRenderer != NULL) {

	    	ByteBuffer imageBuffer = ByteBuffer.allocateDirect((int)cbFrame);
    	  for (int i = 0; i < cbFrame; i++) {
				    imageBuffer.put(pbFrame[i]);
				}
    		
    		/*
    		try {
					File file = new File("C:\\Users\\Admin\\Desktop\\capture.BGRA");
					
					FileChannel writeChannel = new FileOutputStream(file, false).getChannel();
					writeChannel.write(buf);
	        writeChannel.close();
				} catch (Exception e) {    
					e.printStackTrace();
				}
				*/
				
				LibMWCapture.MWD3DRendererPushFrame(m_hD3dRenderer, imageBuffer, (int)cbStride);
				
				//((DirectBuffer)imageBuffer).cleaner().clean();
			}
    }
    
    @Override
  	public void OnAudioCapture(byte[] pbFrame, int cbFrame, long timeStamp) {
    	//System.out.println("audio cbFrame:" + cbFrame + " timeStamp:" + timeStamp);
    	
	    if (m_hDSoundRenderer != NULL) {
	    	LibMWCapture.MWDSoundRendererPushFrame2(m_hDSoundRenderer, pbFrame);
	    }
	  }
}
