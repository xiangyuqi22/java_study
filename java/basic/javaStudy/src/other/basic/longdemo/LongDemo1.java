package other.basic.longdemo;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��1��
 * @author xiangning
 * @since JDK1.8
 */
public class LongDemo1 {
	
	private Long aa;
	
	public static void main(String[] args) {
		long a= 0 ;
		Long b= null;
		b = a;
		System.out.println(b);
		Long c = 1l;
		c = new LongDemo1().getAa();
		System.out.println(c == 0 );
	}
	
	public Long getAa() {
		return aa;
	}
}
