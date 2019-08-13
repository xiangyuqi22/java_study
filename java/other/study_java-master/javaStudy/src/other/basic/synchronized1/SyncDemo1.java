package other.basic.synchronized1;

import other.basic.java.utils.GlobalUtils;

/**
 * <PRE>
 * �߳�ͬ��
 * ǰ��
 * 	������ synchronized a()  synchronized b()
 * ͬʵ������,
 * 	�����뵽a������,a,b������������
 * 
 * ��ͬʵ������,����1,����2
 * 	�����뵽����1��a����ʱ,����2��a,b����������Ӱ��
 * 
 * Ҳ����synchronizedֻ��ͬһ��������Ч
 * ���Ҫ��a b������ͬ��,��ô��Ҫʹ�þ�̬����,
 * 
 * ��̬���� �� synchronized  ������ǰ��
 * 
 * �Ǿ�̬������ synchronized  ������ǰ����
 * synchronized 
 * 	������ڷǾ�̬������ �������������ǰ����
 * 	������ھ�̬������,�������������ǰ��
 * 
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��10��
 * @author xiangning
 * @since JDK1.8
 */
public class SyncDemo1 {

	public static void main(String[] args) {
		new SyncDemo1().demo3();
	}

	private void demo() {
		final Sync s = new Sync();

		for (int i = 1; i <= 3; i++) {
			final int a = i;
			new Thread(() -> {
				switch (a) {
				case 1:
					s.f1();
					break;
				case 2:
					s.f2();
					break;
				case 3:
					new Sync().f1();
					break;
				}
			}).start();
		}
	}

	private void demo2() {
		final Sync s = new Sync();

		for (int i = 1; i <= 3; i++) {
			final int a = i;
			new Thread(() -> {
				switch (a) {
				case 1:
					s.f1();
					break;
				case 2:
					s.f5();
					break;
				case 3:
					new Sync().f5();
					break;
				}
			}).start();
		}
	}
	
	private void demo3() {
		for (int i = 1; i <= 3; i++) {
			final int a = i;
			new Thread(() -> {
				switch (a) {
				case 1:
					Sync.f6();
					break;
				case 2:
					Sync.f7();
					break;
				case 3:
					new Sync().f1();
					break;
				}
			}).start();
		}
	}

	public static class Sync {

		public synchronized void f1() {
			while (true) {
				System.out.println("f1 -->> " + Thread.currentThread().getName());
				GlobalUtils.sleep(1000);
			}
		}

		public synchronized void f2() {
			while (true) {
				System.out.println("f2 -->> " + Thread.currentThread().getName());
				GlobalUtils.sleep(1000);
			}
		}

		public void f3() {
			synchronized (this) {
				while (true) {
					System.out.println("f3 -->> " + Thread.currentThread().getName());
					GlobalUtils.sleep(1000);
				}
			}
		}

		public static void f5() {
			synchronized (Sync.class) {
				while (true) {
					System.out.println("f5 -->> " + Thread.currentThread().getName());
					GlobalUtils.sleep(1000);
				}
			}
		}

		public synchronized static void f6() {
			while (true) {
				System.out.println("f6 -->> " + Thread.currentThread().getName());
				GlobalUtils.sleep(1000);
			}
		}
		public synchronized static void f7() {
			while (true) {
				System.out.println("f7 -->> " + Thread.currentThread().getName());
				GlobalUtils.sleep(1000);
			}
		}
	}

}
