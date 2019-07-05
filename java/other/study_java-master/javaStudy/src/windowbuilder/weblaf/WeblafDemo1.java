package windowbuilder.weblaf;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import com.alee.laf.button.WebButtonUI;
import com.alee.laf.combobox.WebComboBoxUI;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月26日
 * @author xiangning
 * @since JDK1.8
 */
public class WeblafDemo1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeblafDemo1 window = new WeblafDemo1();
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
	public WeblafDemo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 972, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u6309\u94AE");
		button.setPreferredSize(new Dimension(200, 50));
		button.setUI(new WebButtonUI());
		button.setBounds(52, 206, 123, 29);
		frame.getContentPane().add(button);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(52, 36, 258, 141);
		frame.getContentPane().add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setUI(new WebComboBoxUI());
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "23", "32", "32", "43", "4", "324312", "32"}));
		comboBox.setBounds(52, 265, 258, 27);
		frame.getContentPane().add(comboBox);
	}
}
