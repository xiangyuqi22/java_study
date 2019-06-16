package other.basic.callback.exception.thread;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * <PRE>
 * �����߳��е��쳣
 * ����Ҫ�����쳣���̼߳�������쳣����Ϳ�����
 * ����дһ����̳�Thread ����ֱ�Ӽ���Ϳ�����
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��10��
 * @author xiangning
 * @since JDK1.8
 */
public class UnchecckedExceptionhandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		if(e instanceof RuntimeException) {
			System.out.println("����һ������ʱ�쳣");
		}
		System.out.println("������ȡ���߳��쳣");
		System.out.println("�߳�����" + t.getName());
		System.out.println("�쳣���ݣ�" + e.getMessage());
	}

}
