package other.basic.number;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��24��
 * @author xiangning
 * @since JDK1.8
 */
public class Remainder {
	
	public static void main(String[] args) {
		//ȡ��
		int count = 9;
		int rows = 10;
		
		int size = count/rows;
		
		int a  = count%rows;
//		
//		System.out.println(size);
//		
//		System.out.println(a);
//		
		
		if(a > 0) {
			System.out.println(++size);
		}else {
			System.out.println(size);
		}
		
		
		System.out.println(6/5);
		
		
	}

}
