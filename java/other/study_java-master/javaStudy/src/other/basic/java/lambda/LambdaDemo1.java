package other.basic.java.lambda;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��5��
 * @author xiangning
 * @since JDK1.8
 */
public class LambdaDemo1 {
	
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 20 ; i++) {
				try {
					Thread.sleep(1000L);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		
		new Thread(() -> {
			for (int i = 0; i < 20 ; i++) {
				try {
					Thread.sleep(1000L);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		
	}

}
