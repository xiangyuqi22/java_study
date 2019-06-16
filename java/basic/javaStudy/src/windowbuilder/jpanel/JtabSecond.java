package windowbuilder.jpanel;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
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
 * @version 1.0 2018年12月15日
 * @author xiangning
 * @since JDK1.8
 */
public class JtabSecond {

	private JFrame frame;
	private JPanel panel_top;
	private JButton btnOne;
	private JButton btnTwo;
	private JPanel panel_center2;
	private JPanel panel_buttom;
	private JPanel panel_center;
	private JButton btnClear;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtabSecond window = new JtabSecond();
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
	public JtabSecond() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel_top = new JPanel();
		frame.getContentPane().add(panel_top, BorderLayout.NORTH);
		
		btnOne = new JButton("one");
		panel_center = new JPanel();
		panel_center.setBounds(new Rectangle(0, 0, 100, 50));
		panel_center.setBackground(Color.BLUE);
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		btnOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*if(panel_center == null) {
					System.out.println("panel_center 被清除了");
				}
				if(panel_center2!=null) {
					frame.getContentPane().remove(panel_center2);
				}*/
				panel_center2.setLocation(new Point(10000, 10000));
				panel_center.setLocation(new Point(0, 0));
				frame.getContentPane().revalidate();
			}
		});
		panel_top.add(btnOne);
		
		panel_center2 = new JPanel();
		panel_center2.setBackground(Color.RED);
		panel_center2.setBounds(new Rectangle(0, 0,200, 100));
		frame.getContentPane().add(panel_center2, BorderLayout.CENTER);
		btnTwo = new JButton("two");
		btnTwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_center.setLocation(new Point(10000, 10000));
				panel_center2.setLocation(new Point(0, 0));
				frame.getContentPane().revalidate();
				/*if(panel_center!=null) {
					frame.getContentPane().remove(panel_center);
				}*/
			}
		});
		panel_top.add(btnTwo);
		
		btnClear = new JButton("clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel_center!=null) {
					frame.getContentPane().remove(panel_center);
				}
				if(panel_center2!=null) {
					frame.getContentPane().remove(panel_center2);
				}
				//frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
			}
		});
		panel_top.add(btnClear);
		
		
		
		panel_buttom = new JPanel();
		frame.getContentPane().add(panel_buttom, BorderLayout.SOUTH);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
