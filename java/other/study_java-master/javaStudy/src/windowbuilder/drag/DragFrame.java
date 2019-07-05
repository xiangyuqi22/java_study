package windowbuilder.drag;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��27��
 * @author xiangning
 * @since JDK1.8
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DragFrame extends JFrame {
	private boolean startDrag = false;
	private Point p = null;

	public static void main(String[] args) {
		DragFrame df = new DragFrame();
		df.setUndecorated(true);
		df.setSize(400, 400);
		df.setVisible(true);
	}

	public DragFrame() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				startDrag = true;
				p = e.getPoint();
			}

			public void mouseReleased(MouseEvent e) {
				startDrag = false;
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p1 = e.getPoint();
				Point p2 = getLocation(null);
				p2.x += p1.x - p.x;
				p2.y += p1.y - p.y;
				setLocation(p2);
			}
		});
	}
}
