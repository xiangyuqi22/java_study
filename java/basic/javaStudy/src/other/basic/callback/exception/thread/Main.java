package other.basic.callback.exception.thread;

import javax.management.RuntimeErrorException;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月10日
 * @author xiangning
 * @since JDK1.8
 */
public class Main {
	
	public static void main(String[] args) {
		MyThread t = new MyThread(new TheThread());
		t.setName("线程名：主动异常");
		t.start();
		System.out.println("线程执行结束");
	}
	
}

class TheThread implements Runnable{

	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println("currentThread.getName() = " + currentThread.getName() );
		MyThread t = new MyThread(new TheThread2());
		t.start();
		throw new NullPointerException("抛出一个空指针异常");
	}
}


class TheThread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("进入到第二个线程");
		throw new RuntimeException(" 在线程里面主动抛出一个运行时异常");
	}
	
}




class MyThread extends Thread{
	public MyThread(Runnable runnable) {
		super(runnable);
		this.setUncaughtExceptionHandler(new UnchecckedExceptionhandler());
	}
}
