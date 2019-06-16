package other.basic.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.function.Consumer;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;

import other.basic.java.bean.User;

/**
 * <PRE>
 *   可排序的
 *   key不允许 为Null 值 可以为null
 *   非同步的
 *   所有关于排序 ，取值范围 都因为实现了  NavigableMap 接口 而NavigableMap  又继承了 SortedMap 接口
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月28日
 * @author xiangning
 * @since JDK1.8
 */
public class MapStudy03_TreeMap {
	
	public static void main(String[] args) {
		TreeMap<String,User> treeMap = new TreeMap(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int a = 0;
				for (int i = 0; i < o1.length(); i++) {
					char charAt = o1.charAt(i);
					a += (int)charAt;
				}
				int b = 0;
				for (int i = 0; i < o2.length(); i++) {
					char charAt = o2.charAt(i);
					b += (int)charAt;
				}
				return a - b ; //升序
//				return b - a ;
			}
		});
		
		{
			User user = new User();
			user.setId(1004L);
			user.setName("sudongpo");
			user.setAge(51);
			treeMap.put("user4", user);
		}
		{
			User user = new User();
			user.setId(1002L);
			user.setName("dufu");
			user.setAge(22);
			treeMap.put("user2", user);
		}
		{
			User user = new User();
			user.setId(1001L);
			user.setName("libai");
			user.setAge(19);
			treeMap.put("user1", user);
		}
		
		{
			User user = new User();
			user.setId(1003L);
			user.setName("baijuyi");
			user.setAge(34);
			treeMap.put("user3", user);
		}
		
		treeMap.forEach((k,v) ->{
			System.out.println("k = " + k + ";value = " + v);
		});
		
		System.out.println("----------------------------------");
		
		System.out.println(treeMap.ceilingEntry("user6"));
		
		Collection<User> values = treeMap.values();
		System.out.println(values);
		
		System.out.println("treeMap.firstEntry() = " + treeMap.firstEntry());
		System.out.println("----------------------------------");

		NavigableSet<String> navigableKeySet = treeMap.navigableKeySet();
		System.out.println(navigableKeySet.lower("user4"));
		
		
		System.out.println("----------------------------------");
		Iterator<String> iterator = navigableKeySet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------------------------");
		
		Spliterator<String> spliterator = navigableKeySet.spliterator();
		spliterator.forEachRemaining(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		System.out.println("-----------------------------------");
		System.out.println(treeMap.lowerKey("user4"));
		
		
		
		{
			System.out.println("ceilingEntry(K key)   返回一个键-值映射关系，它与大于等于给定键的最小键关联；如果不存在这样的键，则返回 null。");
			System.out.println(treeMap.ceilingEntry("user0"));  //这里应该返回user1
			System.out.println(treeMap.ceilingEntry("user1"));  //这里应该返回user1
			System.out.println(treeMap.ceilingEntry("user4"));  //这里应该返回user4
			System.out.println(treeMap.ceilingEntry("user5"));  //这里应该返回null
		}
		
		{
			System.out.println("ceilingKey(K key)   返回大于等于给定键的最小键；如果不存在这样的键，则返回 null。");
			System.out.println(treeMap.ceilingKey("user0"));  //这里应该返回user1
			System.out.println(treeMap.ceilingKey("user1"));  //这里应该返回user1
			System.out.println(treeMap.ceilingKey("user4"));  //这里应该返回user4
			System.out.println(treeMap.ceilingKey("user5"));  //这里应该返回null
		}
		{
			System.out.println("floorEntry(K key)  返回一个键-值映射关系，它与小于等于给定键的最大键关联；如果不存在这样的键，则返回 null。");
			System.out.println("floorEntry(K key)  与  ceilingEntry(K key) 相对应");
			System.out.println(treeMap.floorEntry("user5"));
		}
		
		{
			System.out.println("comparator()  返回对此映射中的键进行排序的比较器；如果此映射使用键的自然顺序，则返回 null。");
			System.out.println(treeMap.comparator().compare("user3", "u5"));
		}
		
		{
			System.out.println("descendingKeySet() 返回此映射中所包含键的逆序 NavigableSet 视图。");
			NavigableSet<String> descendingKeySet = treeMap.descendingKeySet();
			System.out.println(descendingKeySet);
		}
		
		{
			System.out.println("descendingMap()   返回此映射中所包含映射关系的逆序视图。");
			NavigableMap<String, User> descendingMap = treeMap.descendingMap();
			System.out.println(descendingMap);
		}
		{
			System.out.println("headMap(K toKey)  -- 返回此映射的部分视图，其键值严格小于 toKey。");
			{
				SortedMap<String, User> sortedMap = treeMap.headMap("user3");
				System.out.println(sortedMap);
			}
		}
		{
			System.out.println("headMap(K toKey, boolean inclusive)  -- 返回此映射的部分视图，其键值严格小于 toKey。");
			//true ： 找小于或等于的map   ；false ：找小于当前key的map
			{
				NavigableMap<String, User> navigableMap = treeMap.headMap("user2",true);
				System.out.println(navigableMap);
			}
			{
				NavigableMap<String, User> navigableMap = treeMap.headMap("user2",false);
				System.out.println(navigableMap);
			}
			{
				NavigableMap<String, User> navigableMap = treeMap.headMap("user1",true);
				System.out.println(navigableMap);
			}
		}

		
		
		System.out.println("-----------------------------------");
		System.out.println(treeMap.size());
		Entry<String, User> pollLastEntry = treeMap.pollLastEntry();
		System.out.println("pollLastEntry = " + pollLastEntry);
		System.out.println(treeMap.size());
		
		System.out.println("-----------------------------------");
		System.out.println(treeMap.size());
		Entry<String, User> firstEntry = treeMap.pollFirstEntry();
		System.out.println("pollLastEntry = " + firstEntry);
		System.out.println(treeMap.size());
		
		
		System.out.println("String TreeMap---------------------------------");
		TreeMap<String,String> map = (TreeMap)MapUtils.getTreeMap();
		System.out.println(map);
		
		System.out.println("遍历 map.pollFirstEntry()-----------------------------------------------");
		
		Entry entry = null;
		while ( (entry = map.pollFirstEntry()) != null ) {
			System.out.println(entry == null ? "" : entry);
		}
		System.out.println("遍历 map.pollLastEntry()-----------------------------------------------");
		map = (TreeMap)MapUtils.getTreeMap();
		while ( (entry = map.pollLastEntry()) != null ) {
			System.out.println(entry == null ? "" : entry);
		}
		
		{
			System.out.println("遍历  map.lowerKey--------------------------------------------");
			map = (TreeMap)MapUtils.getTreeMap();
			String lastKey = map.lastKey();
			String key = lastKey;
			while ( key != null ) {
				System.out.println(key + "-----" + map.get(key));
				key = map.lowerKey(key);
			}
		}
		
		{
			System.out.println("遍历  map.higherKey--------------------------------------------");
			map = (TreeMap)MapUtils.getTreeMap();
			String firstKey = map.firstKey();
			String key = firstKey;
			while ( key != null ) {
				System.out.println(key + "-----" + map.get(key));
				key = map.higherKey(key);
			}
		}
		
		{
			System.out.println("subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)  返回此映射的部分视图，其键的范围从 fromKey 到 toKey。");
			NavigableMap<String, String> subMap = map.subMap("likui", true, "sudongpo", true);
			System.out.println(subMap);
			NavigableMap<String, String> descendingMap = subMap.descendingMap();
			System.out.println(descendingMap);
		}
		
	}

}
