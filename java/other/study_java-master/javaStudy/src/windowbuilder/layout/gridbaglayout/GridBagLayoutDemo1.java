package windowbuilder.layout.gridbaglayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月23日
 * @author xiangning
 * @since JDK1.8
 */
public class GridBagLayoutDemo1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridBagLayoutDemo1 window = new GridBagLayoutDemo1();
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
	public GridBagLayoutDemo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
		scrollPane.setViewportView(panel);
		scrollPane.setHorizontalScrollBar(null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("\u5F00\u673A\u6027\u80FD\u6D4B\u8BD5\u4EFB\u52A1");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.gridwidth  = 4;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u6A21\u5757:\u6D4B\u8BD5\u6A21\u5757");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		panel.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("\u6D4B\u8BD5\u9879:\u5F00\u673A\u6D4B\u8BD5");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("\u4E0A\u4F20\u8005:\u51EF\u901A\u79D1\u6280");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 2;
		panel.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("\u4E0A\u4F20\u65F6\u95F4:2019\u5E747\u670823\u65E5");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 2;
		panel.add(label_4, gbc_label_4);
	}

}
