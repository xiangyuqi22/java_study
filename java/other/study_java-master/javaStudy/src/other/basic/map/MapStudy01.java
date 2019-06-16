package other.basic.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <PRE>
	
	map��key�������ظ������Ի�ȡ����set����		Set keySet( )
	ֵ�������ظ��ģ����Ի�ȡ ����collection����   Collection values( )
	
	map��key �ǿ���Ϊnull  ����ֻ����һ��keyΪnull   
	value Ҳ����Ϊnull  ���ҿ��Զ��Ϊnull

	
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��26��
 * @author xiangning
 * @since JDK1.8
 */
public class MapStudy01 {
	
	public static void main(String[] args) {
		Map<String, String> map = MapUtils.getStringMap();
		
		System.out.println(map);
		
		/**
		 * boolean containsKey(Object k)
			�����ӳ�����ָ������ӳ���ϵ���򷵻� true��
		 */
		System.out.println(map.containsKey("libai"));
		
		/**
		 * boolean containsValue(Object v)
			�����ӳ�佫һ��������ӳ�䵽ָ��ֵ���򷵻� true��
		 */
		{
			boolean containsValue = map.containsValue("���");
			System.out.println(containsValue);
		}
		
		
		/**
		 *  Set entrySet( )
			���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ�� 	
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
			�Ƚ�ָ���Ķ������ӳ���Ƿ����
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
			���ش�ӳ��Ĺ�ϣ��ֵ��
		 */
		{
			System.out.println(map.hashCode());
		}
		
		/**
		 * boolean isEmpty( )
			�����ӳ��δ������-ֵӳ���ϵ���򷵻� true��
		 */
		{
			System.out.println("�Ƿ�Ϊ�գ�" + map.isEmpty());
		}
		
		/**
		 * Object remove(Object k)
			�������һ������ӳ���ϵ������Ӵ�ӳ�����Ƴ�����ѡ��������
		 */
		{
			System.out.println("map��С = " + map.size());
			System.out.println(map.get("libai"));
			String objString = map.remove("libai");
			System.out.println(objString);
			System.out.println(map.get("libai"));
			System.out.println("map��С = " + map.size());
		}
		
		/**
		 *  int size( )
			���ش�ӳ���еļ�-ֵӳ���ϵ���� 
		 */
		{
			System.out.println(map.size());
		}
		
		/**
		 * Collection values( )
			���ش�ӳ���а�����ֵ�� Collection ��ͼ��
			����
		 */
		{
			map.put("libai", "���");
			Collection<String> values = map.values();
			System.out.println(values);
		}
		
		{
			System.out.println(map.keySet());
		}
		
		
		System.out.println("---------------------------------------------");
		//�Ӵ�ӳ�����Ƴ�����ӳ���ϵ
		map.clear();
		System.out.println(map);
		
	}

}
