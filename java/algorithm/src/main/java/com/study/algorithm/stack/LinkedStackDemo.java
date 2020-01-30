package com.study.algorithm.stack;

import org.junit.Test;

/**
 * <PRE>
 * 以链表实现栈
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月20日
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
	 * size:(求栈的大小)
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
			throw new RuntimeException("当前栈为空");
		}
		Node temp = first.getNext();
		first.setNext(temp.getNext());
		return temp.getData();
	}

	@Override
	public void show() {
		if (isEmpty()) {
			System.out.println("栈为空，无可遍历数据");
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
			throw new RuntimeException("当前栈为空");
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
