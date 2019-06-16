package windowbuilder.reference;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class ReferenceJpanel extends JPanel {
	

	
	private JLabel label_vertical = new JLabel();
	private JLabel label_horizontal = new JLabel();
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private boolean canPaint;

	public ReferenceJpanel() {
		this.setLayout(null);
		Random rand = new Random();
		addLine();
		for (int i = 0; i < 20; i++) {
			CButton jButton = new CButton("按钮" + (i+1) ,  this , label_vertical , label_horizontal);
			jButton.setBounds(rand.nextInt(800),rand.nextInt(800) ,80, 30);
			this.add(jButton);
		}
		
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();
				repaint();
				
			}
		});
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
				canPaint = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();
				canPaint = false;
				repaint();
				
				List<CButton> list = new ArrayList<>();
				CButton minXButton = null;
				CButton minYButton = null;
				int minx = 1000;
				int miny = 1000;
				Component[] components = getComponents();
				for (Component component : components) {
					if(component instanceof CButton) {
						CButton button = (CButton)component;
						int x = button.getX();
						int y = button.getY();
						if(x >= startX && x <= endX && y >= startY && y <= endY ) {
							if(x < minx) {
								minx = x;
								minXButton = button;
							}
							if(y < miny) {
								miny = y ;
								minYButton = button;
							}
							list.add(button);
						}
					}
				}
				
				if(list.size() < 2) {
					return;
				}
				
				String showInputDialog = JOptionPane.showInputDialog("输入0,20");
				if(showInputDialog == null ) {
					return;
				}
				String[] split = showInputDialog.split(",");
				
				//true  x 从小到大
				//false y 从小到大
				boolean flag = "1".equals(split[0]) ? true : false;
				
				/**
				 * 排序
				 */
				list.sort(new Comparator<CButton>() {

					@Override
					public int compare(CButton c1, CButton c2) {
						if(flag) {
							return c1.getX() - c2.getX();
						}
						return c1.getY() - c2.getY();
					}
				});
				
				int margin = Integer.valueOf(split[1]);
				CButton minButton = list.get(0);
				for (int i = 1; i < list.size(); i++) {
					CButton cButton = list.get(i);
					if(flag) {
						int x = i * (cButton.getWidth() + margin) ; 
						cButton.setLocation(minButton.getX() + x, minButton.getY());
					}else {
						int y = i * (cButton.getHeight() + margin);
						cButton.setLocation(minButton.getX() , minButton.getY() + y);
					}
				}
				repaint();
			}
			
		});
		
	}

	private void addLine() {
		new Thread(() -> {
			try {
				Thread.sleep(2000l);
				System.out.println("绘制jlabel");
				System.out.println("getHeight() = " + getHeight());
				setLabelLine(1, getHeight(), label_vertical);
				setLabelLine(getWidth(),1, label_horizontal);
				label_vertical.setLocation(0, 100);
				label_horizontal.setLocation(110, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} ).start();
	}
	
	
	private void setLabelLine(int width,int height,JLabel jlabel) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.red);
		g2d.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
		g2d.dispose();// 释放资源
		jlabel.setIcon(new ImageIcon(bufferedImage));
		jlabel.setSize(new Dimension(width, height));
		this.add(jlabel);
		jlabel.setVisible(false);
	}
	
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(canPaint) {
			int width = endX - startX;
			int height = endY - startY;
			if(width <= 0 || height <=0 ) {
				return;
			}
			Graphics g2d = (Graphics2D)g;
			g2d.setColor(Color.red);
			g2d.drawRect(startX - 1 , startY - 1,width - 1,height - 1);
			g2d.dispose();
		}
	}
	

	
//	
//	@Override
//	public void paintComponent(Graphics g)
//	{
//		System.out.println("绘制图像");
//		super.paintComponents(g);
//	}

}
