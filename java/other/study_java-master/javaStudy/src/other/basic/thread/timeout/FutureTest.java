package other.basic.thread.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��18��
 * @author xiangning
 * @since JDK1.8
 */
public class FutureTest {
	static class Task implements Callable<Boolean> {
		public String name;
		private int time;

		public Task(String s, int t) {
			name = s;
			time = t;
		}

		@Override
		public Boolean call() throws Exception {
			for (int i = 0; i < time; ++i) {
				System.out.println("task " + name + " round " + (i + 1));
				Thread.sleep(2000);
//				try {
//				} catch (InterruptedException e) {
//					System.out.println(name + " is interrupted when calculating, will stop...");
//					return false; // ע�����������return�Ļ����̻߳������ִ�У���������ʱ�������ﴦ����Ȼ�󷵻�
//				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task1 = new Task("one", 10);
		Future<Boolean> f1 = executor.submit(task1);
		try {
			if (f1.get(20, TimeUnit.SECONDS)) {// future����2��֮��ȡ���
				System.out.println("one complete successfully");
			}
		} catch (InterruptedException e) {
			System.out.println("future��˯��ʱ�����");
			executor.shutdownNow();
		} catch (ExecutionException e) {
			System.out.println("future�ڳ���ȡ��������ʱ����");
			executor.shutdownNow();
		} catch (TimeoutException e) {
			System.out.println("futureʱ�䳬ʱ");

			f1.cancel(true);
			// executor.shutdownNow();
			// executor.shutdown();
		} finally {

			executor.shutdownNow();

		}
	}
}
