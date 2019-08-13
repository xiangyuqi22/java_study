package other.basic.java.stopthread;

import javax.swing.JTextArea;

import other.basic.java.utils.GlobalUtils;
import other.basic.util.StringUtil;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月8日
 * @author xiangning
 * @since JDK1.8
 */
public class MyThread extends Thread {
	
	private JTextArea textArea;
	
	private boolean isPause;
	
	private boolean isStop;

	public MyThread(JTextArea textArea) {
		super();
		this.textArea = textArea;
	}

	@Override
	public void run() {
		while(true) {
			GlobalUtils.sleep(1000);
			textArea.append("现在时间是  -->> " + StringUtil.getNowTime() + "\n");
			if(isPause) {
				synchronized (this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			if(isStop) {
				break;
			}
		}
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
	
	
	
	

}
