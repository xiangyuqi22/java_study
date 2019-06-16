package windowbuilder.jtable.demo2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月26日
 * @author xiangning
 * @since JDK1.8
 */
public class JtableDemo2 {

	private JFrame frame;
	private CTableDemo table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtableDemo2 window = new JtableDemo2();
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
	public JtableDemo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new CTableDemo();
		JTableDemo2Model jTableDemo2Model = new JTableDemo2Model();
		table.setModel(jTableDemo2Model);
		int[] rows = new int[] {1,2,3};
		int[] col = new int[] {1};
		jTableDemo2Model.mergeCells(rows, col);  
		table.repaint();
		scrollPane.setViewportView(table);
	}

}
