package com.study.algorithm.stack;

import org.junit.Test;

/**
 * <PRE>
 * ������ʵ��ջ
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��20��
 * @author xiangning
 * @since JDK1.8
 */
public class LinkedStackDemo {

	
	
	@Test
	public void test1() {
		StackUtils.scannerUtils(null);
	}
	
	@Test
	public void test() {
		StackUtils.scannerUtils(new LinkedStack(10));
	}

}

class LinkedStack implements StackInterface {
	private Node first = null;

	private int maxSize;

	public LinkedStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		first = new Node(-1);
	}

	@Override
	public boolean isEmpty() {
		return first.getNext() == null;
	}

	@Override
	public boolean isFull() {
		return size() == this.maxSize;
	}

	/**
	 * size:(��ջ�Ĵ�С)
	 * 
	 * @author xiangning
	 *
	 * @return
	 */
	public int size() {
		int count = 0;
		Node temp = first.getNext();
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	@Override
	public boolean push(int data) {
		if (isFull()) {
			return false;
		}
		Node node = new Node(data);
		node.setNext(first.getNext());
		first.setNext(node);
		return true;
	}

	@Override
	public int pop() throws Exception {
		if (isEmpty()) {
			throw new RuntimeException("��ǰջΪ��");
		}
		Node temp = first.getNext();
		first.setNext(temp.getNext());
		return temp.getData();
	}

	@Override
	public void show() {
		if (isEmpty()) {
			System.out.println("ջΪ�գ��޿ɱ�������");
			return;
		}
		Node temp = first.getNext();
		int count = 1;
		while (temp != null) {
			System.out.printf("stack[%d]:%d\n", count++, temp.getData());
			temp = temp.getNext();
		}
	}

	@Override
	public int peek() throws Exception{
		if (isEmpty()) {
			throw new RuntimeException("��ǰջΪ��");
		}
		return first.getNext().getData();
	}

}

class Node {
	private int data;
	private Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
