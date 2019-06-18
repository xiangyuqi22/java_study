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
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��17��
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
	 * @param iconName  ��ť����  �ϸ�������������   ��ťĬ������+����+��׺
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
		// �����Ʊ߿�
		super.setBorderPainted(false);
		// �����ƽ���
		super.setFocusPainted(false);
		// ������������
		super.setContentAreaFilled(false);
		// ���ý������
		super.setFocusable(true);
		super.setBorder(null);
		super.setContentAreaFilled(false);
	}

}
