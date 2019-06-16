package other.basic.mapdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月25日
 * @author xiangning
 * @since JDK1.8
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<Integer,Object> map = new HashMap<Integer,Object>();
		map.put(2, "two");
		map.put(1, "one");
		map.put(4, "four");
		map.put(3, "three");
		System.out.println(map.get(1));
		System.out.println(map);
		for (Entry<Integer, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
