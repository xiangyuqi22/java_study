package other.basic.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <PRE>
 * �̳߳�
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��6��
 * @author xiangning
 * @since JDK1.8
 */
public class ThreadExecutors {
	
	static int count = 1;
	public static void main(String[] args) throws InterruptedException {
		 ExecutorService exe = Executors.newFixedThreadPool(50);  
		 
		 for (int i = 0; i < 10; i++) {
			exe.execute(() -> {
				try {
					Thread.sleep((count++) * 1000L);
					System.out.println("t1 .....");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
			});
		 }
		 exe.shutdown();
		 while(true) {
//			 exe.shutdownNow();
			 if(exe.isTerminated()) {
				 System.out.println("�����߳����н��� ");
				 break ;
			 }
			 Thread.sleep(1000L);
		 }
		 
		 
	}
}
