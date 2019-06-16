package other.basic.map;

import java.util.Hashtable;
import java.util.Map;

import other.basic.java.bean.User;
import other.basic.java.utils.GlobalUtils;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月27日
 * @author xiangning
 * @since JDK1.8
 */
public class HashTableDemo01 {
	
	public static void main(String[] args) {
		Map<String,User> table = new Hashtable();
		User user1 = new User();
		table.put("1", user1);
		User user2 = new User();
		table.put("2", user2);
		User user3 = new User();
		table.put("3", user3);
		System.out.println(table.size());
		user1 = null;
		System.gc();
		GlobalUtils.sleep(10000);
		System.out.println(table.size());
		
		for (String string : table.keySet()) {
			System.out.println(table.get(string));
		}
		
		
	}

}
