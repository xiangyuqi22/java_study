package com.study.algorithm.hashtable;
/**
 * <PRE>
 * 功能描述：
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月15日
 * @author xiangning
 * @since JDK1.8
 */
public class NodeLinkedList<K, V> {
	
	private Node<K,V> head;
	
	/**
	 * add:(添加数据)
	 * @author xiangning
	 *
	 * @param k
	 * @param v
	 */
	public int add(K k,V v) {
		if(head == null) {
			head = new Node<K,V>(k,v);
			return 0;
		}
		Node<K,V> temp = head;
		while(true) {
			if((k == null && temp.getK() == null) || (temp.getK().equals(k)) ) {
				System.out.println(k.toString() + "已存在，无法添加到链表中");
				return -1;
			}
			if(temp.getNext() == null) {
				//如果当前是最后一个节点，则退出循环
				break;
			}
			temp = temp.getNext();
		}
		temp.setNext(new Node<K,V>(k,v));
		return 0;
	}
	
	/**
	 * show:(显示所有的数据)
	 * @author xiangning
	 *
	 */
	public void show() {
		Node<K,V> temp = head;
		while(temp != null) {
			String k = temp.getK() == null ? "null" : temp.getK().toString();
			System.out.print(k.toString() + " => " + temp.getV().toString() + " \t");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public V get(K k) {
		Node<K,V> temp = head;
		while(temp != null) {
			if((k == temp.getK()) || (temp.getK() != null && temp.getK().equals(k))) {
				return temp.getV();
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	

}
