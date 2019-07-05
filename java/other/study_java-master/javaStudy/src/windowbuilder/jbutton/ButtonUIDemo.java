package windowbuilder.jbutton;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

import other.basic.util.ImageUtils;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��4��
 * @author xiangning
 * @since JDK1.8
 */
public class ButtonUIDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonUIDemo window = new ButtonUIDemo();
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
	public ButtonUIDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 Border emptyBorder = BorderFactory.createEmptyBorder(0,0, 0, 0);  
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = 100;
		int height = 100;
		{
			JButton button = new JButton("��֪���Ǹ��˲�������");
			button.setSelected(true);
			button.setIcon(ImageUtils.getIcon("batch-img.png"));
			button.setBorder(emptyBorder);
			//ȥ����ťĬ�ϱ߿�
			button.setBorderPainted(false);
			//ȥ�����ֱ߿�
			button.setFocusPainted(false);
			button.setPreferredSize(new Dimension(width,height));
			RoundButtonUI ui = new RoundButtonUI();
			frame.getContentPane().setLayout(new GridLayout(0, 6, 0, 0));
			button.setUI(ui);
			frame.getContentPane().add(button);
		}
		{
			JButton button = new JButton("New button");
			button.setEnabled(false);
			button.setIcon(ImageUtils.getIcon("batch-img.png"));
			button.setBorder(emptyBorder);
			//ȥ����ťĬ�ϱ߿�
			button.setBorderPainted(false);
			//ȥ�����ֱ߿�
			button.setFocusPainted(false);
			button.setPreferredSize(new Dimension(width,height));
			RoundButtonUI ui = new RoundButtonUI();
			button.setUI(ui);
			frame.getContentPane().add(button);
		}
		{
			JButton button = new JButton("New button");
			button.setIcon(ImageUtils.getIcon("batch-img.png"));
			button.setBorder(emptyBorder);
			//ȥ����ťĬ�ϱ߿�
			button.setBorderPainted(false);
			//ȥ�����ֱ߿�
			button.setFocusPainted(false);
			button.setPreferredSize(new Dimension(width,height));
			RoundButtonUI ui = new RoundButtonUI();
			button.setUI(ui);
			frame.getContentPane().add(button);
		}
		{
			JButton button = new JButton("New button");
			button.setIcon(ImageUtils.getIcon("batch-img.png"));
			button.setBorder(emptyBorder);
			//ȥ����ťĬ�ϱ߿�
			button.setBorderPainted(false);
			//ȥ�����ֱ߿�
			button.setFocusPainted(false);
			button.setPreferredSize(new Dimension(width,height));
			RoundButtonUI ui = new RoundButtonUI();
			button.setUI(ui);
			frame.getContentPane().add(button);
		}
		{
			JButton button = new JButton("New button");
			button.setIcon(ImageUtils.getIcon("batch-img.png"));
			button.setBorder(emptyBorder);
			//ȥ����ťĬ�ϱ߿�
			button.setBorderPainted(false);
			//ȥ�����ֱ߿�
			button.setFocusPainted(false);
			button.setPreferredSize(new Dimension(width,height));
			RoundButtonUI ui = new RoundButtonUI();
			button.setUI(ui);
			frame.getContentPane().add(button);
		}
		{
			JButton button = new JButton("New button");
			button.setIcon(ImageUtils.getIcon("batch-img.png"));
			button.setBorder(emptyBorder);
			//ȥ����ťĬ�ϱ߿�
			button.setBorderPainted(false);
			//ȥ�����ֱ߿�
			button.setFocusPainted(false);
			button.setPreferredSize(new Dimension(width,height));
			RoundButtonUI ui = new RoundButtonUI();
			button.setUI(ui);
			frame.getContentPane().add(button);
		}
		
	}

}
