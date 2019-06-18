package windowbuilder.jbutton;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import other.basic.util.ImageUtils;

import java.awt.Color;
import java.awt.Dimension;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月17日
 * @author xiangning
 * @since JDK1.8
 */
public class IconButtonJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IconButtonJframe frame = new IconButtonJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IconButtonJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		IconButton btnNewButton = new IconButton("");
		contentPane.add(btnNewButton);
	}
}

class IconButton extends JButton {

	private final String  PNG = ".png";
	//iconName
	/**
	 * Creates a new instance of IconButton. 
	 * @param iconName  按钮名称  严格按照名字来命令   按钮默认作用+动作+后缀
	 * play_normal.png
	 * play_rollover.png
	 * play_disabled.png
	 * play_disabledSelected.png
	 * play_rolloverSelected.png
	 * play_pressed.png
	 * play_selected.png
	 * 
	 */
	public IconButton(String iconName) {
		ImageIcon playIcon = ImageUtils.getIcon(iconName + "_normal" + PNG);
		if(playIcon == null) {
			return;
		}
		
		super.setDisabledIcon(null);
		super.setRolloverIcon(null);
		super.setDisabledSelectedIcon(null);
		super.setPressedIcon(null);
		super.setRolloverSelectedIcon(null);
		super.setSelectedIcon(null);
		
		
//		ImageIcon playIcon = ImageUtils.getIcon("pause.png");
		super.setIcon(ImageUtils.getIcon("play.png"));
		super.setRolloverIcon(ImageUtils.getIcon("pause.png"));
		super.setBounds(110, 110, 48, 48);
		Dimension d = new Dimension(48, 48);
		super.setSize(d);
		super.setMaximumSize(d);
		super.setMinimumSize(d);
		// 不绘制边框
		super.setBorderPainted(false);
		// 不绘制焦点
		super.setFocusPainted(false);
		// 不绘制内容区
		super.setContentAreaFilled(false);
		// 设置焦点控制
		super.setFocusable(true);
		super.setBorder(null);
		super.setContentAreaFilled(false);
	}

}
