package other.basic.thread;
/**
 * <PRE>
 * java�߳�
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��4��
 * @author xiangning
 * @since JDK1.8
 */

public class ThreadDemo1 {
	Thread t1;
	Thread t2;
	public static boolean flag;
	public static void main(String[] args) {
		ThreadDemo1 threadDemo1 = new ThreadDemo1();
		Thread t1 = threadDemo1.t1;
		
		
	}
	
	
	public void startThread() {
		t2 = new Thread(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						if(flag) {
							t2.wait();
						}
					} catch (InterruptedException e) {
					}
					System.out.println(count++);
				}
			}
		});
		
		
		
		
		
	}
	
}
