package windowbuilder.linstener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月6日
 * @author xiangning
 * @since JDK1.8
 */
public class KeyLinstenerDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyLinstenerDemo window = new KeyLinstenerDemo();
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
	public KeyLinstenerDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String key  = e.getKeyText(e.getKeyCode()) + ":" + e.getKeyChar() + ":" + e.getKeyCode();
				System.out.println("点击了按键：" + key);
				
				JLabel lblNewLabel_1 = new JLabel(key);
				panel.add(lblNewLabel_1);
				panel.revalidate();
				panel.repaint();
				
				System.out.println("e.getModifiers() = " + e.getModifiers() );
				
				if (e.getModifiers() == 2 && e.getKeyCode() == 67) {
					System.out.println("CTRL+C......");
				}
				
				if (e.getModifiers() == 2 && e.getKeyCode() == 86) {
					System.out.println("CTRL+V......");
				}
				if (e.getModifiers() == 2 && e.getKeyCode() == 127) {
					System.out.println("CTRL+delete......");
				}
				
				
			}
		});
		
	}

}
