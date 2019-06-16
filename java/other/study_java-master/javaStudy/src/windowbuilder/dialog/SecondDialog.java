package windowbuilder.dialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import sun.net.www.content.image.jpeg;

import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月10日
 * @author xiangning
 * @since JDK1.8
 */
public class SecondDialog {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondDialog window = new SecondDialog();
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
	public SecondDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		System.out.println(tabbedPane.getComponents().length);
		System.out.println(tabbedPane.getUIClassID());
		tabbedPane.setUI(new JTabbedPaneUI());
		{
			JPanel jPanel = new JPanel();
			JLabel labell = new JLabel("11111");
			jPanel.add(labell);
			tabbedPane.addTab("1", null, jPanel, null);
		}
		
		{
			JPanel jPanel = new JPanel();
			JLabel labell = new JLabel("22222");
			jPanel.add(labell);
			tabbedPane.addTab("2", null, jPanel, null);
		}
		tabbedPane.setSelectedIndex(1);
		tabbedPane.addTab("3", null,  new JPanel(), null);
		tabbedPane.addTab("4", null,  new JPanel(), null);
		tabbedPane.addTab("5", null,  new JPanel(), null);
		tabbedPane.addTab("6", null,  new JPanel(), null);
//		tabbedPane.removeTabAt(0);
		
	
	}

}
