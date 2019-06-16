package other.basic.java.thread;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��6��
 * @author xiangning
 * @since JDK1.8
 */
public class ThreadJoin {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000L);
					System.out.println("t1 .....");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000L);
					System.out.println("t2 .....");
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
	}

}
