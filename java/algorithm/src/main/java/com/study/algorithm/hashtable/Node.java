package com.study.algorithm.hashtable;
/**
 * <PRE>
 * 功能描述：节点，一个节点代表存储的一个数据
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月15日
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
