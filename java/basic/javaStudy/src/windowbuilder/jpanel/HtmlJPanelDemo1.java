package windowbuilder.jpanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月27日
 * @author xiangning
 * @since JDK1.8
 */
public class HtmlJPanelDemo1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HtmlJPanelDemo1 window = new HtmlJPanelDemo1();
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
	public HtmlJPanelDemo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		String html="<html>"
				+ "<body>"
				+ "<b color = 'red'> 1这是一个HTML</b>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "<p color = 'red'> 这是一个HTML</p>"
				+ "</body>"
				+ "</html>";
		JEditorPane editorPane = new JEditorPane("text/html",html);
		
		JScrollPane js = new JScrollPane(editorPane);
		frame.getContentPane().add(js, BorderLayout.CENTER);
	}

}
