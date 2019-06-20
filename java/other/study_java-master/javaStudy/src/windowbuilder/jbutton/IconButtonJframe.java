package windowbuilder.jbutton;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		StbButtonGroup group = new StbButtonGroup();
		
		{
			IconButton btnNewButton = new IconButton("play");
			group.add(btnNewButton,true,true);
			contentPane.add(btnNewButton);
		}
		
		{
			IconButton btnNewButton = new IconButton("play");
			group.add(btnNewButton,false,true);
			contentPane.add(btnNewButton);
		}
		{
			IconButton btnNewButton = new IconButton("play");
			group.add(btnNewButton,false,true);
			contentPane.add(btnNewButton);
		}
		{
			IconButton btnNewButton = new IconButton("play");
			group.add(btnNewButton,false,true);
			contentPane.add(btnNewButton);
			btnNewButton.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					btnNewButton.setEnabled(false);
				}
				
			});
		}
	}
}

class IconButton extends JButton {

	private final String  PNG = ".png";
	//iconName
	/**
	 * Creates a new instance of IconButton. 
	 * @param iconName  按钮名称  严格按照名字来命令   按钮默认作用+动作+后缀
	 * play_normal.png  				默认图标
	 * play_rollover.png				鼠标移入后
	 * play_disabled.png				按钮禁用状态
	 * play_disabledSelected.png		选中+禁用
	 * play_rolloverSelected.png		按钮选中后,鼠标移入
	 * play_pressed.png					鼠标按下
	 * play_selected.png				选中状态
	 * 
	 */
	public IconButton(String iconName) {
		ImageIcon normalIcon = ImageUtils.getIcon(iconName + "_normal" + PNG);
		if(normalIcon == null) {
			return;
		}
		super.setIcon(normalIcon);
		super.setDisabledIcon(ImageUtils.getIcon(iconName + "_disabled" + PNG));
		super.setRolloverIcon(ImageUtils.getIcon(iconName + "_rollover" + PNG));
		super.setDisabledSelectedIcon(ImageUtils.getIcon(iconName + "_disabledSelected" + PNG));
		super.setPressedIcon(ImageUtils.getIcon(iconName + "_pressed" + PNG));
		super.setRolloverSelectedIcon(ImageUtils.getIcon(iconName + "_rolloverSelected" + PNG));
		super.setSelectedIcon(ImageUtils.getIcon(iconName + "_selected" + PNG));
		
		Dimension d = new Dimension(normalIcon.getIconWidth(), normalIcon.getIconHeight());
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
