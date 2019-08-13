package other.basic.synchronized1;

import other.basic.java.utils.GlobalUtils;

/**
 * <PRE>
 * 线程同步
 * 前置
 * 	类中有 synchronized a()  synchronized b()
 * 同实例对象,
 * 	当进入到a方法是,a,b方法都会锁定
 * 
 * 不同实例对象,对象1,对象2
 * 	当进入到对象1的a方法时,对象2的a,b方法都不受影响
 * 
 * 也就是synchronized只对同一个对象有效
 * 如果要让a b方法都同步,那么需要使用静态方法,
 * 
 * 静态方法 加 synchronized  锁定当前类
 * 
 * 非静态方法加 synchronized  锁定当前对象
 * synchronized 
 * 	如果是在非静态方法中 代码块是锁定当前对象
 * 	如果是在静态方法中,代码块是锁定当前类
 * 
 * 
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月10日
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
