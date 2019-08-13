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
 * ��ͨ��չCFrame
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
		//����Ĭ�ϴ�С������Ҫ�У�
		fitSize();
		moveCenter();
		//���õ�ǰ�������
		setExtendedState(this.MAXIMIZED_BOTH);
	}
	
	public void maximized2(boolean isMax) {
		//����Ĭ�ϴ�С������Ҫ�У�
		fitSize();
		//���õ�ǰ�������
		//��ȡ��Ļ�ֱ��ʴ�С  
		moveCenter();
		if(isMax) {
			Dimension   screen   =   Toolkit.getDefaultToolkit().getScreenSize();  
			//getScreenInsets��ָ�����Ļ�� insets  
			Insets   insets   =   Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());   
			//����frame�Ĵ�С  
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
	 * addCloseWindowListener:(��Ӵ��ڹرռ����¼�)
	 * @author xiangning
	 *
	 * @param frame
	 */
	public void addCloseWindowListener(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent  e) {
				//ѯ���Ƿ���Ҫ�رմ���
//				setExtendedState(JFrame.NORMAL);
				if (ShowUtils.selectMessage(frame, "�˳�", "��ȷ��Ҫ�˳���")) {
					System.exit(0);
				}
			}
		});
		
	}
	
	/**
	 * 
	 * showPanel:(�����ǰ�������ǿɼ��ģ���ô������Ϊ�ɼ�������ǿɼ��ģ��ǲ�����)
	 * @author xiangning
	 *
	 */
	public void showPanel() {
		if(!this.isVisible()) {
			this.setVisible(true);
		}
	}
	

}
