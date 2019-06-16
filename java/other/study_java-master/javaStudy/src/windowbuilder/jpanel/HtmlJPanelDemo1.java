package windowbuilder.jpanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��27��
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
				+ "<b color = 'red'> 1����һ��HTML</b>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "<p color = 'red'> ����һ��HTML</p>"
				+ "</body>"
				+ "</html>";
		JEditorPane editorPane = new JEditorPane("text/html",html);
		
		JScrollPane js = new JScrollPane(editorPane);
		frame.getContentPane().add(js, BorderLayout.CENTER);
	}

}
