package other.basic.java.for1;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��1��
 * @author xiangning
 * @since JDK1.8
 */
public class ForDemo1 {
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			if(i == 5) {
				i = -30;
			}
		}
	}

}
