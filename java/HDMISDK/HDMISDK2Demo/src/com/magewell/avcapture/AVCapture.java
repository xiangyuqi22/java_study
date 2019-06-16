package com.magewell.avcapture;

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

import com.magewell.libmwcapture.*;

public class AVCapture extends JFrame {
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
	
	private static final int CAPTURE_WIDTH = VIDEOSIZE[2][0];
	private static final int CAPTURE_HEIGHT = VIDEOSIZE[2][1];
	private static final double FRAME_RATE = FRAMERATE[0];
	private static final String CAPTURE_COLORSPACE = COLORSPACE[2];
	private static final long m_dwFourcc = LibMWCapture.MWGetFourcc(CAPTURE_COLORSPACE);
	
	private static final int m_nSamplesPerSec = 48000;
	private static final int m_nChannels = 2;
	private static final int m_nSamplesPerFrame = 192;
	
	protected long m_hChannel = NULL;
	protected long m_hExitVideoThread = NULL;
	protected long m_hExitAudioThread = NULL;
	protected long m_hWnd = NULL;
	protected long m_hD3dRenderer = NULL;
	protected boolean m_bCapturing = false;
	
	protected String m_strColorSpace = CAPTURE_COLORSPACE;
	protected static double m_dbCurrentFPS = FRAME_RATE;
	protected static long m_dwLast;
	protected static int m_nLastFrameCount;
	
	protected ByteBuffer m_pImageBuffer;
	protected Thread m_CaptureThread;
	protected Thread m_AudioCaptureThread;
	
	private JApplet m_PriviewApplet;
	private JLabel m_VideoInfoLabel;
	private Timer m_FPSTimer;
	
	public AVCapture() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent  e) {
				StopCapture();
				DestroyVideoRenderer();
				
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
		
		this.setTitle("AVCapture");
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
		if (m_hChannel == NULL)
			return false;
		
		m_hExitVideoThread = LibMWCapture.CreateEvent();
		if (m_hExitVideoThread == NULL)
			return false;
			
		m_hExitAudioThread = LibMWCapture.CreateEvent();
		if (m_hExitAudioThread == NULL) 
			return false;
		
		m_bCapturing = true;
		
		m_CaptureThread = new Thread(new VideoCaptureThread());
		System.out.println("Video Capture Thread: " + m_CaptureThread);
		m_CaptureThread.setPriority(Thread.MAX_PRIORITY);
		m_CaptureThread.start();
		
		m_AudioCaptureThread = new Thread(new AudioCaptureThread());
		System.out.println("Audio Capture Thread: " + m_AudioCaptureThread);
		m_AudioCaptureThread.setPriority(Thread.MAX_PRIORITY);
		m_AudioCaptureThread.start();
		
		return true;
	}
	
	public void StopCapture() {
		
		m_bCapturing = false;
		
		if (m_hExitVideoThread != NULL ) {
			LibMWCapture.SetEvent(m_hExitVideoThread);
			LibMWCapture.CloseHandle(m_hExitVideoThread);
			m_hExitVideoThread = NULL;
			
			System.out.println("Video capture thread exit");
			
			m_CaptureThread.interrupt();
			try {
				m_CaptureThread.join();
			} catch (InterruptedException e) {
				System.out.println("Capture Thread Interrupt fail !");
				e.printStackTrace();
			}
		}
		
		if (m_hExitAudioThread != NULL) {
			LibMWCapture.SetEvent(m_hExitAudioThread);
			LibMWCapture.CloseHandle(m_hExitAudioThread);
			m_hExitAudioThread = NULL;
			
			System.out.println("Audio capture thread exit");
			
			m_AudioCaptureThread.interrupt();
			try {
				m_AudioCaptureThread.join();
			} catch (InterruptedException e) {
				System.out.println("Audio Capture Thread Interrupt fail !");
				e.printStackTrace();
			}
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
			new AVCapture();
		}else {
			JOptionPane.showMessageDialog(null, "Can't find device!", "Error", JOptionPane.ERROR_MESSAGE);
			LibMWCapture.ExitNative();
			LibMWCapture.MWCaptureExitInstance();
		}
	}
	
	class VideoCaptureThread implements Runnable {
		@Override
		public void run() {
			long cbStride = LibMWCapture.FOURCC_CalcMinStride(m_dwFourcc, CAPTURE_WIDTH, 4);
			long cbFrame = LibMWCapture.FOURCC_CalcImageSize(m_dwFourcc, CAPTURE_WIDTH, CAPTURE_HEIGHT, cbStride);
			
			m_pImageBuffer = ByteBuffer.allocateDirect((int)cbFrame);
			m_pImageBuffer.clear();
			
			long hCaptureEvent	= LibMWCapture.CreateEvent();
			long hNotifyEvent		= LibMWCapture.CreateEvent();
			long hTimerEvent		= LibMWCapture.CreateEvent();
			
			do {
				if (!LibMWCapture.MWStartVideoCapture(m_hChannel, hCaptureEvent)) {
					System.out.println("MWStartVideoCapture failed! Please Check ProCapture device");
					break;
				}
				
				long hSignalNotify = LibMWCapture.MWRegisterNotify(m_hChannel, hNotifyEvent, NOTIFY_VIDEO_SIGNAL_CHANGE);
				if (hSignalNotify == NULL)
					break;
				
				long hTimerNotify = LibMWCapture.MWRegisterTimer(m_hChannel, hTimerEvent);
				if (hTimerNotify == NULL)
					break;
				
				m_dwLast = System.currentTimeMillis();
				m_nLastFrameCount   = 0;
				
				long llFrameCount = 0;
				long llBeign = 0;
				llBeign = LibMWCapture.MWGetDeviceTime(m_hChannel);
				
				VIDEO_CAPTURE_STATUS captureStatus;
				while(m_bCapturing) {
					if (!LibMWCapture.MWScheduleTimer(m_hChannel, hTimerNotify, llBeign + (llFrameCount ++) * (int) (10000000 / FRAME_RATE)))
						continue;
					
					long [] hEventArr = {m_hExitVideoThread, hTimerEvent, hNotifyEvent};
					long dwRet = LibMWCapture.WaitForMultipleObjects(3, hEventArr, false, INFINITE);
					if (dwRet == WAIT_OBJECT_0 || dwRet == WAIT_FAILED){
						break;
					}
					else if (dwRet == WAIT_OBJECT_0 + 1) {
						LibMWCapture.MWCaptureVideoFrameToVirtualAddress(m_hChannel, -1, m_pImageBuffer, cbFrame, cbStride, false, m_dwFourcc, CAPTURE_WIDTH, CAPTURE_HEIGHT);
						
						long [] hCaptureEventArr = {m_hExitVideoThread, hCaptureEvent};
						dwRet = LibMWCapture.WaitForMultipleObjects(2, hCaptureEventArr, false, INFINITE);
						if (dwRet == WAIT_OBJECT_0)
							break;
						
						captureStatus = LibMWCapture.MWGetVideoCaptureStatus(m_hChannel);
						//System.out.println("Video Capture Status: " + captureStatus.bFrameCompleted);
						
						if (m_hD3dRenderer != NULL) {
							LibMWCapture.MWD3DRendererPushFrame(m_hD3dRenderer, m_pImageBuffer, (int)cbStride);
						}
						
						
						m_nLastFrameCount ++;
						long dwCurrent = System.currentTimeMillis();
						if (dwCurrent - m_dwLast  >= 1000) {
							m_dbCurrentFPS = (double)m_nLastFrameCount * 1000 / (dwCurrent - m_dwLast);
							m_nLastFrameCount = 0;
							m_dwLast = dwCurrent;
						}
					}
					else if (dwRet == WAIT_OBJECT_0 + 2){
						
					}
				}
				
				LibMWCapture.MWUnregisterNotify(m_hChannel, hSignalNotify);
				LibMWCapture.MWUnregisterTimer(m_hChannel, hTimerNotify);
				LibMWCapture.MWStopVideoCapture(m_hChannel);
				
			} while (false);
			
			LibMWCapture.CloseHandle(hCaptureEvent);
			LibMWCapture.CloseHandle(hTimerEvent);
			LibMWCapture.CloseHandle(hNotifyEvent);
		}
	}
	
		class AudioCaptureThread implements Runnable {
		@Override
		public void run() {		
			long hAudioEvent = LibMWCapture.CreateEvent();
			
			long m_hDSoundRenderer = NULL;
			
			m_hDSoundRenderer = LibMWCapture.MWCreateDSoundRenderer(m_nSamplesPerSec, m_nChannels, m_nSamplesPerFrame, 10);
			if (m_hDSoundRenderer == NULL) {
				return;
			}
			
			do {
				if (!LibMWCapture.MWStartAudioCapture(m_hChannel)) {
					break;
				}
				
				long hAudioNotify = LibMWCapture.MWRegisterNotify(m_hChannel, hAudioEvent, NOTIFY_AUDIO_FRAME_BUFFERED);
				if (hAudioNotify == NULL)
					break;

				AUDIO_CAPTURE_FRAME audioFrame = new AUDIO_CAPTURE_FRAME();
				while(m_bCapturing) {					
					long [] hEventArr = {m_hExitVideoThread, hAudioEvent};
					long dwRet = LibMWCapture.WaitForMultipleObjects(2, hEventArr, false, INFINITE);
					if (dwRet == WAIT_OBJECT_0 || dwRet == WAIT_FAILED) {
						break;
					} else if (dwRet == WAIT_OBJECT_0 + 1) {
						LibMWCapture.MWCaptureAudioFrame(m_hChannel, audioFrame);
						/*
						System.out.println("audioFrame.cFrameCount:" + audioFrame.cFrameCount + " iFrame:" + audioFrame.iFrame 
						+ " dwSyncCode:" + audioFrame.dwSyncCode + " dwReserved:" + audioFrame.dwReserved  + " llTimestamp:" + audioFrame.llTimestamp 
						+ " " + audioFrame.adwSamples[0] + " " + audioFrame.adwSamples[1]);
						*/
						
						LibMWCapture.MWDSoundRendererPushFrame(m_hDSoundRenderer, audioFrame.adwSamples);
					}
				}
				
				LibMWCapture.MWUnregisterNotify(m_hChannel, hAudioNotify);
				LibMWCapture.MWStopAudioCapture(m_hChannel);
			} while (false);
			
			LibMWCapture.CloseHandle(hAudioEvent);
			
			if (m_hDSoundRenderer != NULL) {
				LibMWCapture.MWDestroyDSoundRenderer(m_hDSoundRenderer);
				m_hDSoundRenderer = NULL;
			}
		}
	}
}
