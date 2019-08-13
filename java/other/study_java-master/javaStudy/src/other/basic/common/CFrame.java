package other.basic.common;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import other.basic.java.utils.ShowUtils;
import other.basic.util.ImageUtils;

/**
 * 凯通扩展CFrame
 * 
 * @author fanguanqun
 *
 */
public class CFrame extends JFrame {
	
	public static int X_FRAME ;
	
	public static int Y_FRAME ;
	
	public static int WIDTH_FRAME;
	
	public static int HEIGHT_FRAME;
	

	public CFrame() {
		this.setIconImage(ImageUtils.getImage("logo-full.png"));
	}

	public CFrame(String title) {
		super(title);
	}

	public void fitSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth() * 2 / 3, (int) screenSize.getHeight() * 2 / 3);
	}

	public void maximized() {
//		if (getToolkit().isFrameStateSupported(this.MAXIMIZED_HORIZ)) {
//			setExtendedState(this.MAXIMIZED_HORIZ);
//		} else {
//			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//			setSize(screenSize);
//			setLocation(0, 0);
//		}
		//设置默认大小（必须要有）
		fitSize();
		moveCenter();
		//设置当前窗体最大化
		setExtendedState(this.MAXIMIZED_BOTH);
	}
	
	public void maximized2(boolean isMax) {
		//设置默认大小（必须要有）
		fitSize();
		//设置当前窗体最大化
		//获取屏幕分辨率大小  
		moveCenter();
		if(isMax) {
			Dimension   screen   =   Toolkit.getDefaultToolkit().getScreenSize();  
			//getScreenInsets是指获得屏幕的 insets  
			Insets   insets   =   Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());   
			//设置frame的大小  
			setBounds(0, 0, screen.width, screen.height-insets.bottom);
		}else {
			setBounds(0, 0, 1280, 720);
			moveCenter();
		}
	}
	
	
	
	

	public void moveCenter() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screenSize.getWidth() - getWidth()) / 2;
		int y = (int) (screenSize.getHeight() - getHeight()) / 2;
		setLocation(x, y);
	}
	
	/**
	 * addCloseWindowListener:(添加窗口关闭监听事件)
	 * @author xiangning
	 *
	 * @param frame
	 */
	public void addCloseWindowListener(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent  e) {
				//询问是否需要关闭窗口
//				setExtendedState(JFrame.NORMAL);
				if (ShowUtils.selectMessage(frame, "退出", "您确定要退出吗")) {
					System.exit(0);
				}
			}
		});
		
	}
	
	/**
	 * 
	 * showPanel:(如果当前容器不是可见的，那么设置它为可见，如果是可见的，那不设置)
	 * @author xiangning
	 *
	 */
	public void showPanel() {
		if(!this.isVisible()) {
			this.setVisible(true);
		}
	}
	

}
