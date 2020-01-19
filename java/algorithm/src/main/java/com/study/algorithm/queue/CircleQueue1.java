package com.study.algorithm.queue;

import java.util.Scanner;

import org.junit.Test;

/**
 * <PRE>
 * 环形队列
 * 可重复利用
 * 核心在于取模
 * 
 * 
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
public class CircleQueue1 {
	
	@Test
	public void test1() {
		Integer[] arr = new Integer[4];
		CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(arr);
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
					circleQueue.add(nextInt);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "p":
				try {
					Integer pull = circleQueue.pull();
					System.out.printf("取出数据  => %d\n",pull);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "g":
				try {
					Integer pull = circleQueue.get();
					System.out.printf("取出头数据  => %d\n",pull);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "s":
				circleQueue.show();
				break;
			case "c":
				circleQueue.count();
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



class CircleQueue<T>{
	//容纳队列数据的数组
	private T[] arrs;
	//取数据的指针，指向当前可取出的数据，初始值为0
	private int front;
	//有效数据的最后一个指针，默认从0开始，每增加一个数据，当前值加1
	private int rear;
	//队列最大容量
	private int maxSize;
	
	
	public CircleQueue(T[] arrs) {
		this.arrs = arrs;
		this.maxSize = arrs.length;
	}
	
	/**
	 * isFull:(判断是否已满，当当前有效数据为maxSize-1时，就表示已民满)
	 * @author xiangning
	 *
	 * @return
	 */
	public boolean isFull() {
		return (rear + 1 - front)%maxSize == 0;
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
		T t = arrs[front];
		front = (front+1)%maxSize;
		return t;
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
		arrs[rear] = t;		
		rear = (rear+1)%maxSize;
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
		for (int i = front; i < (front + count()); i++) {
			System.out.printf("%d -> %d",i,arrs[i%maxSize]);
		}
		System.out.println("---------------------");
	}
	
	/**
	 * count:(计算有多少个有效数据)
	 * @author xiangning
	 *
	 */
	public int count() {
		System.out.printf("有效数据有： %d 个\n",(rear+maxSize-front)% maxSize);
		return (rear+maxSize-front)% maxSize;
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
