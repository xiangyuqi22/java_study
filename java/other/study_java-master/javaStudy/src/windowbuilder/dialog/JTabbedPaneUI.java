package windowbuilder.dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��10��
 * @author xiangning
 * @since JDK1.8
 */
public class JTabbedPaneUI extends BasicTabbedPaneUI {

	@Override
	public void paint(Graphics g, JComponent c) {
		// TODO Auto-generated method stub
		super.paint(g, c);
	}

	@Override
	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect,
			Rectangle textRect) {
	}

	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
	     
	}

	
	
}
