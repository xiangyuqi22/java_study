package windowbuilder.jpanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��15��
 * @author xiangning
 * @since JDK1.8
 */
public class JtabJpanelFirst {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtabJpanelFirst window = new JtabJpanelFirst();
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
	public JtabJpanelFirst() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(15, 15, 145, 144);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(212, 15, 145, 144);
		tabbedPane.add("1", panel_3);
		tabbedPane.add("2", panel_4);
		tabbedPane.setSelectedIndex(0);
	}

}
