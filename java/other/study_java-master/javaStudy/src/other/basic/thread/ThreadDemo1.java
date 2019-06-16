package other.basic.thread;
/**
 * <PRE>
 * java线程
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月4日
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
