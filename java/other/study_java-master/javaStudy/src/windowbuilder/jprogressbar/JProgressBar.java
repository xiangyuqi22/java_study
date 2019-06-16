package windowbuilder.jprogressbar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月6日
 * @author xiangning
 * @since JDK1.8
 */
public class JProgressBar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JProgressBar window = new JProgressBar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JProgressBar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		javax.swing.JProgressBar progressBar = new javax.swing.JProgressBar();
		progressBar.setMaximum(10);
		progressBar.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(progressBar, BorderLayout.SOUTH);
		
		JButton btnRun = new JButton("run");
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SwingWorker<String, Integer>() {

					@Override
					protected String doInBackground() throws Exception {
						for (int i = 0; i <= 10; i++) {
							Thread.sleep(1000);
							publish(i);
						}
						return null;
					}

					@Override
					protected void process(List<Integer> chunks) {
						for (Integer integer : chunks) {
							progressBar.setValue(integer);
						}
					}
					
				}.execute();;
			}
		});
		frame.getContentPane().add(btnRun, BorderLayout.NORTH);
	}

}
