package other.basic.stringbuffer;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��31��
 * @author xiangning
 * @since JDK1.8
 */


public class StringBufferDemo {
	
	public static void main(String[] args) {
//		StringBuffer s = new StringBuffer(".....");
//		System.out.println(s.length());
//		
		StringBuffer strs = new StringBuffer(".");
		System.out.println(strs.toString());
		strs.delete(0, strs.length());
		System.out.println(strs.toString());
//		w : while (true) {
//			if(strs.toString().length() > 3) {
//				strs = new StringBuffer(".");
//			}
//			System.out.println(strs);
//		} 
	}
}
