package other.basic.callback.exception.thread;

import javax.management.RuntimeErrorException;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��10��
 * @author xiangning
 * @since JDK1.8
 */
public class Main {
	
	public static void main(String[] args) {
		MyThread t = new MyThread(new TheThread());
		t.setName("�߳����������쳣");
		t.start();
		System.out.println("�߳�ִ�н���");
	}
	
}

class TheThread implements Runnable{

	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println("currentThread.getName() = " + currentThread.getName() );
		MyThread t = new MyThread(new TheThread2());
		t.start();
		throw new NullPointerException("�׳�һ����ָ���쳣");
	}
}


class TheThread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("���뵽�ڶ����߳�");
		throw new RuntimeException(" ���߳����������׳�һ������ʱ�쳣");
	}
	
}




class MyThread extends Thread{
	public MyThread(Runnable runnable) {
		super(runnable);
		this.setUncaughtExceptionHandler(new UnchecckedExceptionhandler());
	}
}
