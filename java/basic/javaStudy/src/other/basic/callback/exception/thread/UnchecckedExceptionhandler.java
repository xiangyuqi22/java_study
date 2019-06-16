package other.basic.callback.exception.thread;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * <PRE>
 * 捕获线程中的异常
 * 将需要捕获异常的线程加入这个异常处理就可以了
 * 可以写一个类继承Thread 将其直接加入就可以了
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月10日
 * @author xiangning
 * @since JDK1.8
 */
public class UnchecckedExceptionhandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		if(e instanceof RuntimeException) {
			System.out.println("这是一个运行时异常");
		}
		System.out.println("主动获取到线程异常");
		System.out.println("线程名：" + t.getName());
		System.out.println("异常内容：" + e.getMessage());
	}

}
