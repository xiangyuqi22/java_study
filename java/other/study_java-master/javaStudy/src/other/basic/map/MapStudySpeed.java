package other.basic.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import other.basic.java.utils.GlobalUtils;


/**
 * <PRE>
各map的插入速度
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月26日
 * @author xiangning
 * @since JDK1.8
 */
public class MapStudySpeed {
	
	public static void main(String[] args) {
		/**
		 * hashMap
		 */
		
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new HashMap<String,String>() , 10000);
			long end = System.currentTimeMillis();
			System.out.println("hashmap插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new HashMap<String,String>() , 100000);
			long end = System.currentTimeMillis();
			System.out.println("hashmap插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new HashMap<String,String>() , 1000000);
			long end = System.currentTimeMillis();
			System.out.println("hashmap插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		
		/**
		 * linkedHashMap
		 */
		System.out.println("--------------------------------------------------");
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new LinkedHashMap<String,String>() , 10000);
			long end = System.currentTimeMillis();
			System.out.println("linkedHashMap插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new LinkedHashMap<String,String>() , 100000);
			long end = System.currentTimeMillis();
			System.out.println("linkedHashMap插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new LinkedHashMap<String,String>() , 1000000);
			long end = System.currentTimeMillis();
			System.out.println("linkedHashMap插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		/**
		 * hashTable
		 */
		System.out.println("--------------------------------------------------");
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new Hashtable() , 10000);
			long end = System.currentTimeMillis();
			System.out.println("Hashtable插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new Hashtable<String,String>() , 100000);
			long end = System.currentTimeMillis();
			System.out.println("Hashtable插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
		{
			long start  = System.currentTimeMillis();
			Map<String, String> map = insertMapData(new Hashtable<String,String>() , 1000000);
			long end = System.currentTimeMillis();
			System.out.println("Hashtable插入" + map.size() / 10000 + "万条数据，总耗时：" + ((double)( end - start )) / 1000 + "秒");
			System.out.println("取出" + + map.size() / 10000 + "万条数据，总耗时：" + ((double)getMapDataTime(map)) / 1000 + "秒");
		}
	}

	protected static Map<String, String> insertMapData(Map<String,String> map , int size) {
		for (int i = 0; i < size; i++) {
			map.put(getString(), getString());
		}
		return map;
	}

	/**
	 * getString:(获取随机字符)
	 * @author xiangning
	 *
	 */
	private static String getString() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString();
	}
	
	protected static long getMapDataTime(Map<String,String> map) {
		long start  = System.currentTimeMillis();
		map.forEach((k,v) -> {
			map.get(k);
//			System.out.println(map.get(k));
		});
		long end = System.currentTimeMillis();
//		GlobalUtils.sleep(2000);
		return end - start;
	}
	

}
