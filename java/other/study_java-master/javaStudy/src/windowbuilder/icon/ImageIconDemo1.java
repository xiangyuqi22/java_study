package windowbuilder.icon;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.imageio.plugins.common.ImageUtil;

import other.basic.util.ImageUtils;

import java.awt.BorderLayout;
import java.awt.Color;

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
public class ImageIconDemo1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageIconDemo1 window = new ImageIconDemo1();
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
	public ImageIconDemo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		ImageIcon icon = ImageUtils.getIcon("loading.gif");
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setText("gif��ͼ");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
	}

}
