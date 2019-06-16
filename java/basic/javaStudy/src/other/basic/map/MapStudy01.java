package other.basic.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <PRE>
	
	map的key不允许重复，所以获取的是set集合		Set keySet( )
	值是允许重复的，所以获取 的是collection集合   Collection values( )
	
	map的key 是可以为null  并且只允许一个key为null   
	value 也可以为null  并且可以多个为null

	
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月26日
 * @author xiangning
 * @since JDK1.8
 */
public class MapStudy01 {
	
	public static void main(String[] args) {
		Map<String, String> map = MapUtils.getStringMap();
		
		System.out.println(map);
		
		/**
		 * boolean containsKey(Object k)
			如果此映射包含指定键的映射关系，则返回 true。
		 */
		System.out.println(map.containsKey("libai"));
		
		/**
		 * boolean containsValue(Object v)
			如果此映射将一个或多个键映射到指定值，则返回 true。
		 */
		{
			boolean containsValue = map.containsValue("李白");
			System.out.println(containsValue);
		}
		
		
		/**
		 *  Set entrySet( )
			返回此映射中包含的映射关系的 Set 视图。 	
		 */
		{
			Set<Entry<String, String>> entrySet = map.entrySet();
			Iterator<Entry<String, String>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Entry<String, String> next = iterator.next();
				System.out.println(next.getKey()  + " -----" + next.getValue());
			}
		}
		
		/**
		 * boolean equals(Object obj)
			比较指定的对象与此映射是否相等
		 */
		{
			System.out.println(map.equals("dufu"));
			Map<String, String> map2 = new HashMap<>();
			map2.putAll(map);
			System.out.println(map2);
			map.clear();
			System.out.println(map2);
			System.out.println(map);
			map.putAll(map2);
			System.out.println(map.equals(map2));
		}
		
		/**
		 * int hashCode( )
			返回此映射的哈希码值。
		 */
		{
			System.out.println(map.hashCode());
		}
		
		/**
		 * boolean isEmpty( )
			如果此映射未包含键-值映射关系，则返回 true。
		 */
		{
			System.out.println("是否为空：" + map.isEmpty());
		}
		
		/**
		 * Object remove(Object k)
			如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
		 */
		{
			System.out.println("map大小 = " + map.size());
			System.out.println(map.get("libai"));
			String objString = map.remove("libai");
			System.out.println(objString);
			System.out.println(map.get("libai"));
			System.out.println("map大小 = " + map.size());
		}
		
		/**
		 *  int size( )
			返回此映射中的键-值映射关系数。 
		 */
		{
			System.out.println(map.size());
		}
		
		/**
		 * Collection values( )
			返回此映射中包含的值的 Collection 视图。
			比如
		 */
		{
			map.put("libai", "李白");
			Collection<String> values = map.values();
			System.out.println(values);
		}
		
		{
			System.out.println(map.keySet());
		}
		
		
		System.out.println("---------------------------------------------");
		//从此映射中移除所有映射关系
		map.clear();
		System.out.println(map);
		
	}

}
