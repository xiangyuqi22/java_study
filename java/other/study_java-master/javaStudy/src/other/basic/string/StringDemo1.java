package other.basic.string;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��4��
 * @author xiangning
 * @since JDK1.8
 */
public class StringDemo1 {
	
	public static void main(String[] args) {
		String originName = "mystudy.jpg";
		String suffix = originName.substring(originName.lastIndexOf("."),originName.length());
		System.out.println(suffix);
	}

}
