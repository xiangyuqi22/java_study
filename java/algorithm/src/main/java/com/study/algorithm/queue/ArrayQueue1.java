package com.study.algorithm.queue;

import java.util.Scanner;

import org.junit.Test;

/**
 * <PRE>
 * 数组队列
 * 		
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月11日
 * @author xiangning
 * @since JDK1.8
 */
public class ArrayQueue1 {
	
	
	@Test
	public void test1() {
		Integer[] arr = new Integer[3];
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(arr);
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			System.out.println("请输入：");
			System.out.println("a  ->  添加数据");
			System.out.println("p  ->  拉取数据");
			System.out.println("g  ->  获取头数据");
			System.out.println("s  ->  显示队列数据");
			System.out.println("c  ->  计算队列数据大小");
			System.out.println("e  ->  退出");
			String select = scanner.next();
			switch (select) {
			case "a":
				int nextInt = scanner.nextInt();
				try {
					arrayQueue.add(nextInt);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "p":
				try {
					Integer pull = arrayQueue.pull();
					System.out.printf("取出数据  => %d\n",pull);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "g":
				try {
					Integer pull = arrayQueue.get();
					System.out.printf("取出头数据  => %d\n",pull);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "s":
				arrayQueue.show();
				break;
			case "c":
				arrayQueue.count();
				break;
			case "e":
				exit = true;
				break;
			default:
				System.out.println("输入错误，请重新输入：");
			}
		}
		//TODO 开始测试队列
		scanner.close();
		System.out.println("已退出");
		
		
		
	}
	
}


class ArrayQueue<T>{
	//容纳队列数据的数组
	private T[] arrs;
	//取数据的指针，第一个数据，默认要从-1开始，每次取出一个数据+1
	private int front = -1;
	//有效数据的最后一个指针，默认从-1开始，每次添加一个数据，加1
	private int rear = -1;
	//队列最大容量
	private int maxSize;
	
	
	public ArrayQueue(T[] arrs) {
		this.arrs = arrs;
		this.maxSize = arrs.length;
	}
	
	public boolean isFull() {
		return rear + 1 == maxSize;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	
	/**
	 * pull:(取出数据，移动指针)
	 * @author xiangning
	 *
	 * @return
	 */
	public T pull() {
		if(isEmpty()) {
			throw new RuntimeException("当前队列为空，没有数据");
		}
		front++;
		return arrs[front];
	}
	
	/**
	 * add:(添加数据)
	 * @author xiangning
	 *
	 * @param t
	 */
	public void add(T t) {
		if(isFull()) {
			throw new RuntimeException("当前队列已满，不能再添加数据了");
		}
		rear++;
		arrs[rear] = t;		
	}
	
	/**
	 * show:(显示数据)
	 * @author xiangning
	 *
	 */
	public void show() {
		if(isEmpty()) {
			System.out.println("当前队列没有数据");
			return;
		}
		System.out.println("------显示数据----------");
	
		for (int i = front + 1; i <= rear; i++) {
			System.out.printf("%d => %d\n",i+1,arrs[i]);
		}
		
		System.out.println("---------------------");
	}
	
	/**
	 * count:(计算有多少个有效数据)
	 * @author xiangning
	 *
	 */
	public void count() {
		System.out.printf("有效数据有： %d 个\n",rear-front);
	}
	
	/**
	 * get:(获取当前第一个数据，不移动指针)
	 * @author xiangning
	 *
	 * @return
	 */
	public T get() {
		if(isEmpty()) {
			throw new RuntimeException("当前队列为空，没有数据");
		}
		return arrs[front];
	}
	
	
}





