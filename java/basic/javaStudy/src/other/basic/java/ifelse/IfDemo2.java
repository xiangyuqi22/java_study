package other.basic.java.ifelse;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��3��
 * @author xiangning
 * @since JDK1.8
 */
public class IfDemo2 {
	
	public static void main(String[] args) {
		long time = 3000l;
		//��ǰʱ�� ��ȥ ê��ʱ�� С�� �ж�ʱ��  Ϊ true
		System.out.println(test(100l,true,false));
		System.out.println(test(100000l,true,false));
		
		
		System.out.println(test(100l,false,true));
		System.out.println(test(100000l,false,true));
	}
	
	public static boolean test(long time , boolean gerater ,boolean less) {
		long currentTimeMillis = System.currentTimeMillis();
		long startTime = System.currentTimeMillis() - 3000L;
		long dealTime = currentTimeMillis - startTime;
		boolean re = (currentTimeMillis - startTime) < time ? true : false;
		
		if( (gerater && re) || (less && !re)) {
			return true;
		}		
		return false;
		
	}

}
