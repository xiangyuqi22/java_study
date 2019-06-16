package other.basic.java;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��12��
 * @author xiangning
 * @since JDK1.8
 */
public class ThreadDemo {
	
	public static void main(String[] args) {
		/*ThreadDemo t = new ThreadDemo();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.one();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.two();
			}
		}).start();*/
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ThreadDemo.three();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ThreadDemo.four();
			}
		}).start();
		
	}
	
	private void one() {
		for (int i = 100; i < 120; i++) {
			try {
				Thread.sleep(200);
				System.out.println(i);
			} catch (InterruptedException e) {
			}
		}
	}
	
	private void two() {
		for (int i = 200; i < 220; i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
			}
		}
	}
	
	private static void three() {
		for (int i = 300; i < 320; i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
			}
		}
	}
	
	private static void four() {
		for (int i = 400; i < 420; i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
			}
		}
	}
}
