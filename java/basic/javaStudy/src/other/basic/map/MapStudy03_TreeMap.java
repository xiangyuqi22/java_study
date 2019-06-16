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
 *   �������
 *   key������ ΪNull ֵ ����Ϊnull
 *   ��ͬ����
 *   ���й������� ��ȡֵ��Χ ����Ϊʵ����  NavigableMap �ӿ� ��NavigableMap  �ּ̳��� SortedMap �ӿ�
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��28��
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
				return a - b ; //����
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
			System.out.println("ceilingEntry(K key)   ����һ����-ֵӳ���ϵ��������ڵ��ڸ���������С����������������������ļ����򷵻� null��");
			System.out.println(treeMap.ceilingEntry("user0"));  //����Ӧ�÷���user1
			System.out.println(treeMap.ceilingEntry("user1"));  //����Ӧ�÷���user1
			System.out.println(treeMap.ceilingEntry("user4"));  //����Ӧ�÷���user4
			System.out.println(treeMap.ceilingEntry("user5"));  //����Ӧ�÷���null
		}
		
		{
			System.out.println("ceilingKey(K key)   ���ش��ڵ��ڸ���������С������������������ļ����򷵻� null��");
			System.out.println(treeMap.ceilingKey("user0"));  //����Ӧ�÷���user1
			System.out.println(treeMap.ceilingKey("user1"));  //����Ӧ�÷���user1
			System.out.println(treeMap.ceilingKey("user4"));  //����Ӧ�÷���user4
			System.out.println(treeMap.ceilingKey("user5"));  //����Ӧ�÷���null
		}
		{
			System.out.println("floorEntry(K key)  ����һ����-ֵӳ���ϵ������С�ڵ��ڸ�������������������������������ļ����򷵻� null��");
			System.out.println("floorEntry(K key)  ��  ceilingEntry(K key) ���Ӧ");
			System.out.println(treeMap.floorEntry("user5"));
		}
		
		{
			System.out.println("comparator()  ���ضԴ�ӳ���еļ���������ıȽ����������ӳ��ʹ�ü�����Ȼ˳���򷵻� null��");
			System.out.println(treeMap.comparator().compare("user3", "u5"));
		}
		
		{
			System.out.println("descendingKeySet() ���ش�ӳ������������������ NavigableSet ��ͼ��");
			NavigableSet<String> descendingKeySet = treeMap.descendingKeySet();
			System.out.println(descendingKeySet);
		}
		
		{
			System.out.println("descendingMap()   ���ش�ӳ����������ӳ���ϵ��������ͼ��");
			NavigableMap<String, User> descendingMap = treeMap.descendingMap();
			System.out.println(descendingMap);
		}
		{
			System.out.println("headMap(K toKey)  -- ���ش�ӳ��Ĳ�����ͼ�����ֵ�ϸ�С�� toKey��");
			{
				SortedMap<String, User> sortedMap = treeMap.headMap("user3");
				System.out.println(sortedMap);
			}
		}
		{
			System.out.println("headMap(K toKey, boolean inclusive)  -- ���ش�ӳ��Ĳ�����ͼ�����ֵ�ϸ�С�� toKey��");
			//true �� ��С�ڻ���ڵ�map   ��false ����С�ڵ�ǰkey��map
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
		
		System.out.println("���� map.pollFirstEntry()-----------------------------------------------");
		
		Entry entry = null;
		while ( (entry = map.pollFirstEntry()) != null ) {
			System.out.println(entry == null ? "" : entry);
		}
		System.out.println("���� map.pollLastEntry()-----------------------------------------------");
		map = (TreeMap)MapUtils.getTreeMap();
		while ( (entry = map.pollLastEntry()) != null ) {
			System.out.println(entry == null ? "" : entry);
		}
		
		{
			System.out.println("����  map.lowerKey--------------------------------------------");
			map = (TreeMap)MapUtils.getTreeMap();
			String lastKey = map.lastKey();
			String key = lastKey;
			while ( key != null ) {
				System.out.println(key + "-----" + map.get(key));
				key = map.lowerKey(key);
			}
		}
		
		{
			System.out.println("����  map.higherKey--------------------------------------------");
			map = (TreeMap)MapUtils.getTreeMap();
			String firstKey = map.firstKey();
			String key = firstKey;
			while ( key != null ) {
				System.out.println(key + "-----" + map.get(key));
				key = map.higherKey(key);
			}
		}
		
		{
			System.out.println("subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)  ���ش�ӳ��Ĳ�����ͼ������ķ�Χ�� fromKey �� toKey��");
			NavigableMap<String, String> subMap = map.subMap("likui", true, "sudongpo", true);
			System.out.println(subMap);
			NavigableMap<String, String> descendingMap = subMap.descendingMap();
			System.out.println(descendingMap);
		}
		
	}

}
