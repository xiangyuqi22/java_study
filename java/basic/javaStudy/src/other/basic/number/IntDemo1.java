package other.basic.number;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��22��
 * @author xiangning
 * @since JDK1.8
 */


public class IntDemo1 {
	
	private static int aa;
	
	public static void main(String[] args) {
		int a = 15 * 1000;
		int b = a / (60 * 1000);
		int c = a % (60*1000);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		aa = getInteger();
		System.out.println(aa);
		
		System.out.println("--------------------------");
		System.out.println(Integer.valueOf("-100") > -200);
	}
	
	
	public static Integer getInteger() {
		return 1;
	}
	
}
