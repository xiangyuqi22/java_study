package other.basic.java.keyword;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��31��
 * @author xiangning
 * @since JDK1.8
 */
public class VolatileDemo {
	
	private volatile int a = 0;
	
	private Lock lock = new ReentrantLock();
	
	private  void increase() {
		lock.lock();
		a++;
		lock.unlock();
	}
	
//	private synchronized void increase() {
//		a++;
//	}
	
	
	public static void main(String[] args) {
		
		VolatileDemo volatileDemo = new VolatileDemo();
		
		for (int i = 0; i < 10; i++) {
			new Thread(() ->{
				for (int j = 0; j < 100000; j++) {
					
					volatileDemo.increase();
					
				}
			}).start();
		}
		
		while(Thread.activeCount() > 1 ) {
			  Thread.yield();
		}
		
		System.out.println(volatileDemo.a);
		
	}
	
	

}
