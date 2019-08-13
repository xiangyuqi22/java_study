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
public class ThreadActives {
	
	public static void main(String[] args) throws InterruptedException {
//		demo1();
		
		demo2();
		
		
		
		
	}
	
	/**
	 * demo2:(�߳�startǰ��״̬)
	 * @author xiangning
	 *
	 */
	private static void demo2() {
		
		Thread thread = new Thread(() -> {});
		System.out.println(thread.isAlive());
		thread.start();
		System.out.println(thread.isAlive());

	}
	
	
	
	
	
	
	private static void demo1() {
		new Thread(
				() ->{
					try {
						for (int i = 0; i < 10; i++) {
							new Thread(
									() -> {
										try {
											new Thread(
													() -> {
														System.out.println("�����̣߳� " + Thread.activeCount());
														try {
															Thread.sleep(1000L);
														} catch (InterruptedException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
													}
													).start();
											Thread.sleep(200L);
											System.out.println("�����̣߳� " + Thread.activeCount());
											Thread.sleep(1000L);
//											System.out.println(Thread.currentThread().getName());
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									).start();
						}
						Thread.sleep(200L);
						System.out.println("һ���̣߳� " + Thread.activeCount());
						Thread.sleep(1000L);
						System.out.println("t1 .....");
					} catch (InterruptedException e) {
					}
				}
				).start();
		
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����̣߳� " + Thread.activeCount());
	}

}
