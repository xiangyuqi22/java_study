package windowbuilder.jpanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��14��
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
