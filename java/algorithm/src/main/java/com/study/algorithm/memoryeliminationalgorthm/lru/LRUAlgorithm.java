package com.study.algorithm.memoryeliminationalgorthm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <PRE>
 * 内存淘汰算法之LRU算法
 * least recently used
 * 最近最少使用
 * 将缓存数据放在指定长度的队列中。最近使用的数据或新数据放在第一位，新数据进入，淘汰最后一位。
 * 
 * 代价：
 * 	命中时需要遍历链表，将命中的数据块索引，然后将需要的数据移动到头部
 * 
 * 
 * 
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月4日
 * @author xiangning
 * @since JDK1.8
 */
public class LRUAlgorithm<K, V> extends LinkedHashMap<K, V>{
	
	private int cacheSize;
	
	public LRUAlgorithm(int cacheSize) {
        super(cacheSize,0.75f,true);
        this.cacheSize = cacheSize;
    }
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return cacheSize < super.size();
    }
	
	
	public static void main(String[] args) {
		LRUAlgorithm<String, String> cacheLRU = new LRUAlgorithm<String,String>(5);
		cacheLRU.put("libai", "李白");
		cacheLRU.put("dufu", "杜甫");
		cacheLRU.put("baijuyi", "白居易");
		cacheLRU.put("liqingzhao", "李清照");
		cacheLRU.put("xinqiji", "辛弃疾");
		System.out.println(cacheLRU);
		cacheLRU.get("baijuyi");
		System.out.println(cacheLRU);
		cacheLRU.get("libai");
		System.out.println(cacheLRU);
		cacheLRU.put("sudongpo", "苏东坡");
		System.out.println(cacheLRU);
		cacheLRU.put("liyu", "李煜");
		System.out.println(cacheLRU);
		cacheLRU.get("sudongpo");
		System.out.println(cacheLRU);
	}
	
	

}
