package com.study.algorithm.hashtable;
/**
 * <PRE>
 * 功能描述：哈希表/散列表
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月15日
 * @author xiangning
 * @since JDK1.8
 */
public class HashTab<K, V> {
	
	private NodeLinkedList<K, V>[] nodeLinkedListArray = null;
	
	private int size;

	public HashTab(int size) {
		super();
		if(size <= 0) {
			throw new RuntimeException("初始长度必须大于0");
		}
		this.size = size;
		this.nodeLinkedListArray = new NodeLinkedList[size];
	}
	
	/**
	 * getIndex:(哈希取模获取当前数据可添加入的索引)
	 * @author xiangning
	 *
	 * @param k
	 * @return
	 */
	public int getIndex(K k) {
		if(k == null) {
			return 0;
		}
		return k.hashCode() % this.size;
	}
	
	public int put(K k,V v) {
		int index = getIndex(k);
		NodeLinkedList<K, V> nodeLinkedList = this.nodeLinkedListArray[index];
		if(nodeLinkedList == null) {
			nodeLinkedList = new NodeLinkedList<K,V>();
			this.nodeLinkedListArray[index] = nodeLinkedList;
		}
		return nodeLinkedList.add(k, v);
	}
	
	public void show() {
		for (int i = 0; i < nodeLinkedListArray.length; i++) {
			NodeLinkedList<K, V> nodeLinkedList = nodeLinkedListArray[i];
			if(nodeLinkedList != null) {
				System.out.printf("第  %d 条数据 ==> " , i+1);
				nodeLinkedList.show();
			}
		}
	}
	
	public V get(K k) {
		int index = getIndex(k);
		NodeLinkedList<K, V> nodeLinkedList = this.nodeLinkedListArray[index];
		if(nodeLinkedList == null) {
			return null;
		}
		return nodeLinkedList.get(k);
	}
	
	

}
