package other.basic.java;
/**
 * <PRE>
 * �����������Ͳ����������õ�����
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��25��
 * @author xiangning
 * @since JDK1.8
 */
public class BasicVariable {
	
	public static void main(String[] args) {
		boolean b = false;
		changeBoolean(b);
		System.out.println(b);
		
		Boolean c = false;
		changeBoolean(c);
		System.out.println(c);
	}
	
	
	public static void changeBoolean(Boolean  bool) {
		bool = true;
	}
}

