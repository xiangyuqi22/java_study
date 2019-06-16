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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月13日
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
			// 鼠标拖动时
			@Override
			public void mouseDragged(MouseEvent e) {
				// 鼠标拖动
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
			
			// 鼠标按下时
			@Override
			public void mousePressed(MouseEvent e) {
				// 鼠标按下时，记录当前按钮位置
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
				//销毁参考线
				label_vertical.setVisible(false);
				label_horizontal.setVisible(false);
			}
		});

	}
	
	

}
