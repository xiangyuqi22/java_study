package other.basic.number;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月24日
 * @author xiangning
 * @since JDK1.8
 */
public class LongDemo1 {
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		
		String str = null;
		map.put("num1", str);
		System.out.println(map.get("num1"));
		System.out.println(map.get("num1") instanceof String);
		
		map.put("num1", "11");
		Long num1 = Long.parseLong(map.get("num1"));
		
		System.out.println(num1);
		
		num1 = null;
		long a = num1;
		System.out.println(a);
		
		
	}

}
