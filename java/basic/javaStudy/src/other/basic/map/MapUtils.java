package other.basic.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月26日
 * @author xiangning
 * @since JDK1.8
 */
public class MapUtils {
	
	public static Map<String,String> getStringMap(){
		Map<String,String> map = new HashMap<>();
		setMap(map);
		map.put(null,null);
		map.put(null,"");
		return map;
	}
	
	
	/**
	 * getLinkedHashMap:()
	 * linkedHashMap ： 相对于hashMap　　它是有序的，存取相对对要慢一些，同时也是非同步的，即线程不安全的。
	 * 
	 * 
	 * @author xiangning
	 *
	 * @return
	 */
	public static Map<String,String> getLinkedHashMap(){
		Map<String,String> map = new LinkedHashMap<>();
		setMap(map);
		map.put(null,null);
		map.put(null,"");
		return map;
	}
	public static Map<String,String> getTreeMap(){
		Map<String,String> map = new TreeMap<>();
		setMap(map);
		return map;
	}
	
	public static void setMap(Map<String,String> map){
		map.put("libai", "李白");
		map.put("litaibai", "李白");
		map.put("dufu", "杜甫");
		map.put("baijuyi", "白居易");
		map.put("sudongpo", "苏东坡");
		map.put("songjiang", "宋江");
		map.put("likui", "李逵");
		map.put("xiangning",null);
	}
	
	
	

}
