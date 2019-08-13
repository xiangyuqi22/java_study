package other.basic.thread;

import other.basic.java.utils.GlobalUtils;

/**
 * <PRE>
 * �߳�ֻ��start����һ��,���н�����,��ǰthread�����û����,�ȴ�gc���л���.�����Ҫ�ظ�����,��Ҫʹ���̳߳�
 * 
 * run()���н�������߳��ٴ�start()ʱ,���׳�IllegalThreadStateException�쳣
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��9��
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
			System.out.println("��ǰ�߳����н���");
		}
		
	}
	
	
}



