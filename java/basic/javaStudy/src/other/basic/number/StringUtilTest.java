package other.basic.number;

import java.util.regex.Pattern;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月8日
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
