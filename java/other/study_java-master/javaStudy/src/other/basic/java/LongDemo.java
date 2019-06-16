package other.basic.java;
/**
 * <PRE>
 * ֪ʶ�㣺
 * 	Long / Integer  ���ж�  ==  ������-128 ~ 127 ��Ч  �������ֵ ����Ҫʹ�� equals
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��26��
 * @author xiangning
 * @since JDK1.8
 */
public class LongDemo {
	public static void main(String[] args) {
		Long a = 127L;
		Long b = 127L;
		System.out.println( a ==  b );
		System.out.println(a.equals(b));
		
		
		Integer aa = 128;
		Integer bb = 128;
		System.out.println(aa == bb);
		System.out.println(aa.equals(bb));
		
		
		
	}
}
