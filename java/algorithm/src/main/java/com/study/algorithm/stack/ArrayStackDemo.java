package com.study.algorithm.stack;

import java.util.Scanner;

import org.junit.Test;
import org.openjdk.jmh.runner.RunnerException;

/**
 * <PRE>
 * ����ģ��ջ
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��20��
 * @author xiangning
 * @since JDK1.8
 */
public class ArrayStackDemo {

	
	@Test
	public void test1() {
		StackUtils.scannerUtils(null);
	}
	
	@Test
	public void test() {
		StackUtils.scannerUtils(new ArrayStack(5));
	}
	
	

}

class ArrayStack implements StackInterface{
	
	//����һ�����ݣ������洢ջ������
	private int[] arrs = null;
	
	//����һ��ջ��������������ʾջ��λ�ã�Ĭ��ֵΪ-1����ʾջΪ��
	private int topIndex = -1;
	
	//����ջ�Ĵ�С
	private int maxSize;

	public ArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		arrs = new int[maxSize];
	}
	

	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}
	

	@Override
	public boolean isFull() {
		return topIndex == this.maxSize -1;
	}
	

	@Override
	public boolean push(int data) {
		if(isFull()) {
			return false;
		}
		arrs[++topIndex] = data;
		return true;
	}
	

	@Override
	public int pop()  throws Exception{
		if(isEmpty()) {
			throw new RuntimeException("��ǰջΪ��");
		}
		return arrs[topIndex--];
	}
	

	@Override
	public void show() {
		if(isEmpty()) {
			System.out.println("ջΪ�գ��޿ɱ�������");
		}
		for (int i = 0; i <= topIndex; i++) {
			System.out.printf("stack[%d]:%d\n",i,arrs[i]);
		}
	}


	@Override
	public int peek() throws Exception {
		if(isEmpty()) {
			throw new RuntimeException("��ǰջΪ��");
		}
		return arrs[topIndex];
	}
	
	
}
