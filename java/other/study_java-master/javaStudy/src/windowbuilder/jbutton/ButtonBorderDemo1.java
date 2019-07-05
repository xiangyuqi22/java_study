package windowbuilder.jbutton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月27日
 * @author xiangning
 * @since JDK1.8
 */
public class ButtonBorderDemo1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonBorderDemo1 window = new ButtonBorderDemo1();
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
	public ButtonBorderDemo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u7EAF\u989C\u8272\u6309\u94AE");
		button.setForeground(Color.RED);
		button.setBackground(Color.WHITE);
		button.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		button.setBounds(109, 79, 191, 62);
		frame.getContentPane().add(button);
	}

}
