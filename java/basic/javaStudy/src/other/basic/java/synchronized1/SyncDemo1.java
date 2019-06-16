package other.basic.java.synchronized1;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��3��
 * @author xiangning
 * @since JDK1.8
 */
public class SyncDemo1 {
	
	public static void main(String[] args) {
		
		Num n = new Num();
		
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					synchronized (n) {
						n.add();
					}
				}
			}).start();
		}
		
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		
		System.out.println(n.a);
		
	}
	

}

class Num {
	int a ;
	public void add() {
		a++;
	}
	
	public int getA() {
		return a;
	}
	
	public void sub() {
		a--;
	}
	
}


