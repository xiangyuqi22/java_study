package windowbuilder.jbutton;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月4日
 * @author xiangning
 * @since JDK1.8
 */
public class RoundButtonUI extends BasicButtonUI {
	
	
	private Color normal = Color.red;
	
	private Color rollover = Color.BLUE;
	
	private Color textColor = Color.BLACK;

	private Color selected = Color.DARK_GRAY;
	
	private Color disable = Color.GRAY;
	
	/**
	 * 选中时
	 */
	private Color selectedRollover = Color.GRAY;
	
	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		ButtonModel model = b.getModel();
		Graphics2D g2d = (Graphics2D) g;
		//消除锯齿
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		Color color = normal;
		if (model.isSelected()) {
			color = selected;
			if(model.isRollover()) {
				color = selectedRollover;
			}
		}else if(model.isRollover()) {
			color = rollover;
		}
		if (!model.isEnabled()) {
			color = disable;
		}
		g2d.setColor(color);
		int width = b.getWidth();
		int height = b.getHeight();
		//清空画布,否则会出现重叠
		g2d.clearRect(0, 0, width, height);
		int rectWidth = width/2;
		int rectHeight = height/2;
		
		g2d.fillRoundRect(width/4, 0 , width/2, height/2, width,  height);
		
		Icon icon = b.getIcon();
		if(icon != null) {
			ImageIcon imageIcon = (ImageIcon)icon;
			int iconWidth = imageIcon.getIconWidth();
			int iconHeight = imageIcon.getIconHeight();
			int x = (width - iconWidth)/2;
			int y = (rectHeight - iconHeight)/2;
			g2d.drawImage(imageIcon.getImage(), x, y, iconWidth, iconHeight, null);
		}
		
		int stringWith = getButtonStringWith(b);
		int stringHeight = getStringHeight(b.getFont());
		g2d.setFont(b.getFont());
		g2d.setColor(textColor);
		g2d.drawString(b.getText(), (width - stringWith)/2, height/2 + stringHeight);
	}
	

	public static int getButtonStringWith(AbstractButton jButton) {
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(jButton.getFont()); 
		int width = fm.stringWidth(jButton.getText());
		return width;
	}
	
	public static int getStringHeight(Font font) {
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font); 
		int height = fm.getHeight();
		return height;
	}
	
	
	
	

}
