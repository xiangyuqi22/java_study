package com.study.algorithm.stack;

import java.util.Scanner;

import org.junit.Test;
import org.openjdk.jmh.runner.RunnerException;

/**
 * <PRE>
 * 数组模拟栈
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月20日
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
	
	//定义一个数据，用来存储栈中数据
	private int[] arrs = null;
	
	//定义一个栈顶索引，用来表示栈顶位置，默认值为-1，表示栈为空
	private int topIndex = -1;
	
	//定义栈的大小
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
			throw new RuntimeException("当前栈为空");
		}
		return arrs[topIndex--];
	}
	

	@Override
	public void show() {
		if(isEmpty()) {
			System.out.println("栈为空，无可遍历数据");
		}
		for (int i = 0; i <= topIndex; i++) {
			System.out.printf("stack[%d]:%d\n",i,arrs[i]);
		}
	}


	@Override
	public int peek() throws Exception {
		if(isEmpty()) {
			throw new RuntimeException("当前栈为空");
		}
		return arrs[topIndex];
	}
	
	
}
