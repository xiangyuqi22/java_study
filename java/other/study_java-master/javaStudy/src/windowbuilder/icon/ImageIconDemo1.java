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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月4日
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
		lblNewLabel.setText("gif动图");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
	}

}
