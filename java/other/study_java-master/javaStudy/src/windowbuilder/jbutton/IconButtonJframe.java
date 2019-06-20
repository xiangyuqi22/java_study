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
	 * @param iconName  ��ť����  �ϸ�������������   ��ťĬ������+����+��׺
	 * play_normal.png  				Ĭ��ͼ��
	 * play_rollover.png				��������
	 * play_disabled.png				��ť����״̬
	 * play_disabledSelected.png		ѡ��+����
	 * play_rolloverSelected.png		��ťѡ�к�,�������
	 * play_pressed.png					��갴��
	 * play_selected.png				ѡ��״̬
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
