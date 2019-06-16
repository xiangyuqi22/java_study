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
public class IntegerDemo1 {
	
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 123);
		Integer integer = map.get(1);
		integer = 99;
		System.out.println(map.get(1));
		
		System.out.println("------------------------------------");
		
		Integer a = 999;
		Integer b = a;
		System.out.println(a == b);
		a = 0;
		System.out.println(a == b);
		
	}

}
