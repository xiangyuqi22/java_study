package other.basic.map;

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
 * @version 1.0 2018年12月7日
 * @author xiangning
 * @since JDK1.8
 */
public class MapDemo1 {
	
	public static void main(String[] args) {
		Map map = new HashMap<>();
		if(map.get("a") == null) {
			System.out.println("yes is null");
		}
	}

}
