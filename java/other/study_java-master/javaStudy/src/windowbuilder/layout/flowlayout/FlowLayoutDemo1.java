package windowbuilder.layout.flowlayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月3日
 * @author xiangning
 * @since JDK1.8
 */
public class FlowLayoutDemo1 {

	private JFrame frame;
	private JLabel label1;
	private JComboBox box1;
	private JPanel rightPanel;
	private Dimension leftDim;
	private Dimension rightDim;
	private JPanel leftPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayoutDemo1 window = new FlowLayoutDemo1();
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
	public FlowLayoutDemo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.red);
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setPreferredSize(new Dimension(300, leftPanel.getHeight()));
		
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.CYAN);
		frame.getContentPane().add(rightPanel, BorderLayout.CENTER);
		rightPanel.setPreferredSize(new Dimension(300, leftPanel.getHeight()));
		rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		int leftWidth = (int)(rightPanel.getWidth()/3);
		int rightWidth = (int)(rightPanel.getWidth() * 2/3);
		leftWidth = 100;
		rightWidth = 200;
		
		leftDim = new Dimension(leftWidth, 30);
		rightDim = new Dimension(rightWidth, 30);
		
		{
			label1 = new JLabel("New label");
			label1.setPreferredSize(leftDim);
			rightPanel.add(label1);
			
			box1 = new JComboBox();
			box1.setPreferredSize(rightDim);
			rightPanel.add(box1);
		}
		{
			JLabel label2 = new JLabel("New label");
			label2.setPreferredSize(leftDim);
			rightPanel.add(label2);
			
			JComboBox box2 = new JComboBox();
			box2.setPreferredSize(rightDim);
			rightPanel.add(box2);
		}
		{
			JLabel label3 = new JLabel("New label");
			label3.setPreferredSize(leftDim);
			rightPanel.add(label3);
			
			JComboBox box3 = new JComboBox();
			box3.setPreferredSize(rightDim);
			rightPanel.add(box3);
		}
		{
			JLabel label4 = new JLabel("New label");
			label4.setPreferredSize(leftDim);
			rightPanel.add(label4);
			
			JComboBox box4 = new JComboBox();
			box4.setPreferredSize(rightDim);
			rightPanel.add(box4);
		}
		
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = rightPanel.getWidth();
				System.out.println("width = " + width);
				double left = width/3;
				double right = width - left - 10;
				leftDim.setSize((int)left,30);
				rightDim.setSize((int)right, 30);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("label1.getWidth() = " + label1.getWidth());
				System.out.println("rightPanel.getWidth() = " + rightPanel.getWidth());
				System.out.println("box1.getWidth() = " + box1.getWidth());
			}
		}).start();
		
		
	}

}
