package com.study.vlc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.TrackDescription;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月20日
 * @author xiangning
 * @since JDK1.8
 */
public class VlcPlayer {

	private JFrame frame;
	private EmbeddedMediaPlayerComponent mediaPlayerComponent;
	private JButton pauseButton;
	private JButton rewindButton;
	private JButton skipButton;
	
	/**
	 * 判断本地计算机是否有装vlc播放器
	 */
	private boolean hasVlc;
	/**
	 * 单例模式
	 */
	public static VlcPlayer vlcPlayer;
	private JButton btnPlay;
	private JButton button;
	private VlcPlayer() {}
	public static VlcPlayer getInstance() {
		if (vlcPlayer == null) {
			synchronized (VlcPlayer.class) {
				if (vlcPlayer == null) {
					vlcPlayer = new VlcPlayer();
					vlcPlayer.initialize();
				}
			}
		}
		return vlcPlayer;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VlcPlayer window = new VlcPlayer();
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		hasVlc = new NativeDiscovery().discover();
		if(!hasVlc) {
			//如果没有装vlc播放器 ，就不再进行往下操作了
			return;
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mediaPlayerComponent.release();
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
				playerMedia("F:\\xiangyuqi\\mv\\无双.mp4");
				getMediaInfo();
			}
		});
		controlsPane.add(button);
		frame.setContentPane(contentPane);
	}
	
	/**
	 * playerMedia:(播放媒体文件)
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
	 * showFrame:(显示窗体)
	 * @author xiangning
	 *
	 * @return
	 */
	public boolean showFrame() {
		if(!hasVlc) {
			return false;
		}
		
		if(!frame.isVisible()) {
			frame.setVisible(true);
		}
		return true;
	}
	
	/**
	 * isHasVlc:(判断本机是否有装vlc播放器)
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
