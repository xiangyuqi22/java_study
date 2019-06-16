package windowbuilder.jpanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月14日
 * @author xiangning
 * @since JDK1.8
 */
public class MyPanel1 extends JPanel {

	@Override
	protected void printComponent(Graphics g) {
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
	}
	
	
	
	
}
