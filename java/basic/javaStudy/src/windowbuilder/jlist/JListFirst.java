package windowbuilder.jlist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月5日
 * @author xiangning
 * @since JDK1.8
 */
public class JListFirst {

	private JFrame frame;
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListFirst window = new JListFirst();
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
	public JListFirst() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel(" ");
		
		
		TheList theList = new TheList();
		list = new MyJList<String>(theList);
		/*theList.valueChanged(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				theList.setName(list.getSelectedValue());
				theList.setAge(list.getSelectedIndex());
				label.setText(theList.toString());
			}
			
		});*/
		
		frame.getContentPane().add(list, BorderLayout.NORTH);
		
		frame.getContentPane().add(label, BorderLayout.CENTER);
		
		JButton btnGet = new JButton("get");
		btnGet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(list.getSelectedValuesList().toString());
			}
		});
		frame.getContentPane().add(btnGet, BorderLayout.SOUTH);
	}

}
