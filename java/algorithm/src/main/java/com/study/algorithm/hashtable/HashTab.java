package com.study.algorithm.hashtable;
/**
 * <PRE>
 * ������������ϣ��/ɢ�б�
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��15��
 * @author xiangning
 * @since JDK1.8
 */
public class HashTab<K, V> {
	
	private NodeLinkedList<K, V>[] nodeLinkedListArray = null;
	
	private int size;

	public HashTab(int size) {
		super();
		if(size <= 0) {
			throw new RuntimeException("��ʼ���ȱ������0");
		}
		this.size = size;
		this.nodeLinkedListArray = new NodeLinkedList[size];
	}
	
	/**
	 * getIndex:(��ϣȡģ��ȡ��ǰ���ݿ�����������)
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
				System.out.printf("��  %d ������ ==> " , i+1);
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
