package windowbuilder.jpanel.show;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
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
 * @version 1.0 2019年6月24日
 * @author xiangning
 * @since JDK1.8
 */
public class Visiable {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visiable window = new Visiable();
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
	public Visiable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel.add(panel_3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.MAGENTA);
		panel.add(panel_4, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		panel.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u5173\u95ED\u5DE6\u4FA7");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				panel_2.setVisible(false);
				panel_2.setPreferredSize(new Dimension(500, panel_2.getHeight()));
				//jpanel改变状态后需要调用以下两个方法刷新面板,否则面板不会即时更新
				panel_2.revalidate();
				panel_2.repaint();
//				frame.revalidate();
//				frame.getContentPane().revalidate();
//				frame.repaint();
//				frame.getContentPane().repaint();
			}
		});
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u663E\u793A\u5DE6\u4FA7");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setPreferredSize(new Dimension(0, panel_2.getHeight()));
				panel_2.revalidate();
				panel_2.repaint();
				//				panel_2.setVisible(true);
			}
		});
		panel_1.add(button_1);
	}

}
