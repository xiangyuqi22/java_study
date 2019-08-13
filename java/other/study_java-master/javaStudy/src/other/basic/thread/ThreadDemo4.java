package other.basic.thread;

import other.basic.java.utils.GlobalUtils;

/**
 * <PRE>
 * 线程只能start启动一次,运行结束后,当前thread对象就没用了,等待gc进行回收.如果需要重复利用,需要使用线程池
 * 
 * run()运行结束后的线程再次start()时,会抛出IllegalThreadStateException异常
 * 
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月9日
 * @author xiangning
 * @since JDK1.8
 */
public class ThreadDemo4 {
	
//	private static MyThread thread = new MyThread();
	
	
	public static void main(String[] args) throws InterruptedException {
		
		MyThread thread = new MyThread();
		
		for (int i = 0; i < 3; i++) {
			System.out.println(thread.isAlive());
			GlobalUtils.sleep(1000);
			if(!thread.isAlive()) {
				System.out.println("thread = " + thread);
				thread.start();
			}
		}
		thread.join();
		System.gc();
		GlobalUtils.sleep(1000);
		System.out.println("thread.getName() = " + thread.getName());
	}
	
	
	private static class MyThread extends Thread{
		
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
			GlobalUtils.sleep(1000);
			System.out.println("当前线程运行结束");
		}
		
	}
	
	
}



