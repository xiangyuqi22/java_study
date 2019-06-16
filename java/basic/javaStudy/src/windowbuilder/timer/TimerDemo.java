package windowbuilder.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��7��
 * @author xiangning
 * @since JDK1.8
 */
public class TimerDemo implements Runnable{
	
	Timer timer;
	
	public static void main(String[] args) throws InterruptedException {
		TimerDemo t = new TimerDemo();
		Thread tt = new Thread(t);
		tt.start();
		t = null;
		System.gc();
		Thread.sleep(5000);
	}
	
	public void timer() {
		timer = new Timer(500,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("timer");
			}
		});
		timer.start();
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("timer");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
