package com.study.vlc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.TrackDescription;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��20��
 * @author xiangning
 * @since JDK1.8
 */
public class VlcPlayerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private EmbeddedMediaPlayerComponent mediaPlayerComponent;
	private JButton pauseButton;
	private JButton rewindButton;
	private JButton skipButton;
	
	/**
	 * �жϱ��ؼ�����Ƿ���װvlc������
	 */
	private boolean hasVlc;
	/**
	 * ����ģʽ
	 */
	public static VlcPlayerDialog vlcPlayerDialog;
	private JButton btnPlay;
	private JButton button;
	private VlcPlayerDialog() {}
	public static VlcPlayerDialog getInstance() {
		if (vlcPlayerDialog == null) {
			synchronized (VlcPlayerDialog.class) {
				if (vlcPlayerDialog == null) {
					vlcPlayerDialog = new VlcPlayerDialog();
					vlcPlayerDialog.init();
				}
			}
		}
		return vlcPlayerDialog;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VlcPlayerDialog dialog = VlcPlayerDialog.getInstance();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public void init() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		hasVlc = new NativeDiscovery().discover();
		if(!hasVlc) {
			//���û��װvlc������ ���Ͳ��ٽ������²�����
			return;
		}
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mediaPlayerComponent.release();
				System.out.println("�����˳�");
				System.exit(0);
			}
		});
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

		JPanel controlsPane = new JPanel();
		pauseButton = new JButton("Pause");
		pauseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mediaPlayerComponent.getMediaPlayer().pause();
			}
		});
		
		btnPlay = new JButton("play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mediaPlayerComponent.getMediaPlayer().play();
			}
		});
		controlsPane.add(btnPlay);
		controlsPane.add(pauseButton);
		rewindButton = new JButton("Rewind");
		rewindButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mediaPlayerComponent.getMediaPlayer().skip(-10000);
			}
		});
		controlsPane.add(rewindButton);
		skipButton = new JButton("Skip");
		skipButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mediaPlayerComponent.getMediaPlayer().skip(10000);
			}
		});
		controlsPane.add(skipButton);
		contentPane.add(controlsPane, BorderLayout.SOUTH);
		
		button = new JButton("\u64AD\u653E\u5176\u4ED6");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerMedia("F:\\xiangyuqi\\mv\\��˫.mp4");
				getMediaInfo();
			}
		});
		controlsPane.add(button);
		this.setContentPane(contentPane);
	}

	
	/**
	 * playerMedia:(����ý���ļ�)
	 * @author xiangning
	 *
	 * @param filePath
	 */
	public void playerMedia(String filePath) {
		mediaPlayerComponent.getMediaPlayer().stop();
		
		mediaPlayerComponent.getMediaPlayer().prepareMedia(filePath);
		mediaPlayerComponent.getMediaPlayer().playMedia(filePath);
		mediaPlayerComponent.getMediaPlayer().play();
	}
	
	/**
	 * showFrame:(��ʾ����)
	 * @author xiangning
	 *
	 * @return
	 */
	public boolean showFrame() {
		if(!hasVlc) {
			return false;
		}
		
		if(!this.isVisible()) {
			this.setVisible(true);
		}
		return true;
	}
	
	/**
	 * isHasVlc:(�жϱ����Ƿ���װvlc������)
	 * @author xiangning
	 *
	 * @return
	 */
	public boolean isHasVlc() {
		return hasVlc;
	}
	
	public void getMediaInfo() {
		mediaPlayerComponent.getMediaPlayer().parseMedia();
		mediaPlayerComponent.getMediaPlayer().requestParseMedia();
		
		
		MediaPlayer mediaPlayer = mediaPlayerComponent.getMediaPlayer();

		List<TrackDescription> titleTracks = mediaPlayer.getTitleDescriptions();
		System.out.println("titleTracks = " + titleTracks);
		List<TrackDescription> videoTracks = mediaPlayer.getVideoDescriptions();
		List<TrackDescription> audioTracks = mediaPlayer.getAudioDescriptions();
		List<TrackDescription> spuTracks = mediaPlayer.getSpuDescriptions();
	}
	
}
