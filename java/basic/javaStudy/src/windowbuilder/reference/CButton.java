package windowbuilder.reference;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��13��
 * @author xiangning
 * @since JDK1.8
 */
public class CButton extends JButton {

	private int mouseX;
	private int mouseY;
	private int buttonX;
	private int buttonY;
	private BufferedImage bufferedImage;
	

	public CButton(String text , JPanel  panel, final JLabel label_vertical, JLabel label_horizontal) {
		super(text);
		this.addMouseMotionListener(new MouseMotionAdapter() {
			// ����϶�ʱ
			@Override
			public void mouseDragged(MouseEvent e) {
				// ����϶�
				int xEnd = e.getXOnScreen() - mouseX + buttonX;
				int yEnd = e.getYOnScreen() - mouseY + buttonY;
				if (xEnd <= 0) {
					xEnd = 0;
				}
				if (xEnd > panel.getWidth()) {
					xEnd = panel.getWidth() - getWidth();
				}
				if (yEnd <= 0) {
					yEnd = 0;
				}
				if (yEnd > panel.getHeight()) {
					yEnd = panel.getHeight() - getHeight();
				}
				setLocation(new Point(xEnd, yEnd));
				label_vertical.setVisible(true);
				label_horizontal.setVisible(true);
				label_vertical.setLocation(new Point(xEnd, 0));
				label_horizontal.setLocation(new Point(0, yEnd));
				
			}
		});

		this.addMouseListener(new MouseAdapter() {
			
			// ��갴��ʱ
			@Override
			public void mousePressed(MouseEvent e) {
				// ��갴��ʱ����¼��ǰ��ťλ��
				mouseX = e.getXOnScreen();
				mouseY = e.getYOnScreen();
				buttonX = getX();
				buttonY = getY();
				label_vertical.setVisible(true);
				label_horizontal.setVisible(true);
				label_vertical.setLocation(new Point(buttonX, 0));
				label_horizontal.setLocation(new Point(0, buttonY));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int min = 40;
				int minX = min;
				int minY = min;
				Component[] components = panel.getComponents();
				for (Component component : components) {
					if(component instanceof CButton) {
						CButton button = (CButton)component;
						CButton THIS = CButton.this;
						if(button == THIS) {
							continue;
						}
						int a = Math.abs(THIS.getX() - button.getX());
						minX = Math.min(minX, a);
						int b = Math.abs(THIS.getY() - button.getY());
						minY = Math.min(minY, b);
					}
				}
				minX =  minX < min ? minX : 0;
				minY =  minY < min ? minY : 0;
				System.out.println(minX);
				System.out.println(minY);
				setLocation(new Point(getX() - minX , getY() - minY));
				//���ٲο���
				label_vertical.setVisible(false);
				label_horizontal.setVisible(false);
			}
		});

	}
	
	

}
