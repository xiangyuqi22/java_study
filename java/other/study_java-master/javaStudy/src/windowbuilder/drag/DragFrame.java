package windowbuilder.drag;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月27日
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
