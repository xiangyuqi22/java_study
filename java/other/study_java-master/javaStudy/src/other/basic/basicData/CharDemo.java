package other.basic.basicData;
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
public class CharDemo {
	
	public static void main(String[] args) {
		System.out.println((int)'m' == 'm');
		String paramValue2 = "yyyymmDD".toLowerCase();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < paramValue2.length(); i++) {
			char charAt = paramValue2.charAt(i);
			if(charAt == 'm') {
				sb.append("M");
			}else {
				sb.append(charAt);
			}
		}
		paramValue2 = sb.toString();
		System.out.println(paramValue2);
	}

}
