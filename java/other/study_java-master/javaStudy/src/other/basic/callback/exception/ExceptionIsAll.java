package other.basic.callback.exception;
/**
 * <PRE>
 * java���쳣�Ƿ���Դﵽ�̼߳���
 * �� ������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��10��
 * @author xiangning
 * @since JDK1.8
 */
public class ExceptionIsAll {
	
	public static void main(String[] args) {
		try {
			new Thread(new TheThread()).start();
		} catch (Exception e) {
			System.out.println("�쳣������");
		}
	}
}


class TheThread implements Runnable{
	
	 @Override
	    public void run() {
		 System.out.println("��������ʼ���쳣");
	     Integer.valueOf("�޿��κλ���ȥds");
	    }
}