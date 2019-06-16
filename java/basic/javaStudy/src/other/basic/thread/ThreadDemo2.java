package other.basic.thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月4日
 * @author xiangning
 * @since JDK1.8
 */
public class ThreadDemo2 {

	private JFrame frame;
	
	Thread t2;
	public boolean flag;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadDemo2 window = new ThreadDemo2();
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
	public ThreadDemo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnStop = new JButton("stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flag = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(t2.isAlive());
			}
		});
		frame.getContentPane().add(btnStop);
		
		JButton btnStart = new JButton("start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				synchronized (t2) {
					flag = false;
					t2.notify();
				}
				System.out.println(t2.isAlive());
			}
		});
		frame.getContentPane().add(btnStart);
		
		createThread();
	}
	
	
	public void createThread() {
		t2 = new Thread(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						if(flag) {
							try {
								synchronized (t2) {
									t2.wait();
								}
							} catch (Exception e) {
								System.out.println(e);
							}
						}
					} catch (InterruptedException e) {
					}
					System.out.println(count++);
				}
			}
		});
		t2.start();
	}
	
	

}
