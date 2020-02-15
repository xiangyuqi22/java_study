package com.study.algorithm.hashtable;
/**
 * <PRE>
 * �����������ڵ㣬һ���ڵ����洢��һ������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��15��
 * @author xiangning
 * @since JDK1.8
 */
public class Node<K, V> {
	
	private K k;
	private V v;
	
	private Node<K,V> next;
	
	

	public Node(K k, V v) {
		super();
		this.k = k;
		this.v = v;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	public Node<K, V> getNext() {
		return next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}
	
	
	
	
	

}
