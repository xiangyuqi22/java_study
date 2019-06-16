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
public class IfDemo1 {
	
	public static void main(String[] args) {
		
		System.out.println("��ת��" + demo1("-10", true));
		System.out.println("����ת��" + demo1("-10", false));
		System.out.println("��ת��" + demo1("10", false));
		System.out.println("����ת��" + demo1("10", true));
		
	}

	protected static int demo1(String line , boolean hasDefect) {
		boolean type = line.startsWith("-");
		boolean jump = (type && hasDefect) || (!type && !hasDefect) ? true : false;
		if( jump ) {
			if(line.startsWith("-")){
				line = line.substring(0 ,  line.length());
			}
			//������ĸ�������ڵĻ�����ô����ȱ���˾���Ҫ��ת��ָ���к�ִ��
			int row = Integer.valueOf(line);
			if(row > 0) {
				return row;
			}
		}
		return -1000;
	}

}
