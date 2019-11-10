package other.basic.map;

import java.util.HashMap;
import java.util.Map;

import other.basic.java.bean.User;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年9月4日
 * @author xiangning
 * @since JDK1.8
 */
public class MapObjectDemo {
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		User user = new User();
		user.setName("libai");
		map.put("user",user);
		
		user.setName("dufu");
		
		System.out.println(map);
	}

}
