package other.basic.stringbuilder;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��31��
 * @author xiangning
 * @since JDK1.8
 */
public class StringBuilderDemo1 {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		sb.append("d");
		sb.append("e");
		sb.append("f");
		sb.append("g");
		sb.append("h");
		sb.append("i");
		System.out.println(sb.toString());
		sb.setLength(0);
		System.out.println(sb.toString());
	}

}
