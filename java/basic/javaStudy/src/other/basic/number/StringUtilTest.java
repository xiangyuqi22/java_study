package other.basic.number;

import java.util.regex.Pattern;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��8��
 * @author xiangning
 * @since JDK1.8
 */
public class StringUtilTest {
	
	public static void main(String[] args) {
		System.out.println(isNum("+324678654324656"));
	}
	
	public static boolean isNum(String str) {
		boolean flg = false;

		if (str != null && (str = str.trim()).length() > 0) {
			String dbl = "((^(\\-|\\+)?([0-9]+)?(\\.)?)([0-9]+$))|((^(\\-|\\+)?([0-9]+)?)[0-9]+([0-9\\.]$))";
			flg = Pattern.compile(dbl).matcher(str).matches();
		}

		return flg;
	}
	
	
}
