package other.basic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

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
public class MapForEach {

		public static void main(String[] args) {
			Map<String , String> map  =  new HashMap<>();
			map.put("name", "姓名");
			map.put("fav", "爱好");
			map.put("age", "年龄");
			map.forEach((k,v) ->  System.out.println(k + v) );
			map.forEach((k,v) ->  syso(k,v) );
			
			System.out.println("----------------------------------");
			map.forEach((k,v) -> {
				System.out.println("key = " + k + "; value = " + v);
			});
		}
		
		public static void syso(String k,String v) {
			System.out.println(k);
			System.out.println(v);
		}
}
