package other.basic.java.keyword;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月31日
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
