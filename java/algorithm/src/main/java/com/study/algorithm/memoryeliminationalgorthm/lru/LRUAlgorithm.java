package com.study.algorithm.memoryeliminationalgorthm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <PRE>
 * �ڴ���̭�㷨֮LRU�㷨
 * least recently used
 * �������ʹ��
 * ���������ݷ���ָ�����ȵĶ����С����ʹ�õ����ݻ������ݷ��ڵ�һλ�������ݽ��룬��̭���һλ��
 * 
 * ���ۣ�
 * 	����ʱ��Ҫ�������������е����ݿ�������Ȼ����Ҫ�������ƶ���ͷ��
 * 
 * 
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��4��
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
		cacheLRU.put("libai", "���");
		cacheLRU.put("dufu", "�Ÿ�");
		cacheLRU.put("baijuyi", "�׾���");
		cacheLRU.put("liqingzhao", "������");
		cacheLRU.put("xinqiji", "������");
		System.out.println(cacheLRU);
		cacheLRU.get("baijuyi");
		System.out.println(cacheLRU);
		cacheLRU.get("libai");
		System.out.println(cacheLRU);
		cacheLRU.put("sudongpo", "�ն���");
		System.out.println(cacheLRU);
		cacheLRU.put("liyu", "����");
		System.out.println(cacheLRU);
		cacheLRU.get("sudongpo");
		System.out.println(cacheLRU);
	}
	
	

}
