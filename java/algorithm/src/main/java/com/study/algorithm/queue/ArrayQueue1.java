package com.study.algorithm.queue;

import java.util.Scanner;

import org.junit.Test;

/**
 * <PRE>
 * �������
 * 		
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��11��
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
			System.out.println("�����룺");
			System.out.println("a  ->  �������");
			System.out.println("p  ->  ��ȡ����");
			System.out.println("g  ->  ��ȡͷ����");
			System.out.println("s  ->  ��ʾ��������");
			System.out.println("c  ->  ����������ݴ�С");
			System.out.println("e  ->  �˳�");
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
					System.out.printf("ȡ������  => %d\n",pull);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "g":
				try {
					Integer pull = arrayQueue.get();
					System.out.printf("ȡ��ͷ����  => %d\n",pull);
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
				System.out.println("����������������룺");
			}
		}
		//TODO ��ʼ���Զ���
		scanner.close();
		System.out.println("���˳�");
		
		
		
	}
	
}


class ArrayQueue<T>{
	//���ɶ������ݵ�����
	private T[] arrs;
	//ȡ���ݵ�ָ�룬��һ�����ݣ�Ĭ��Ҫ��-1��ʼ��ÿ��ȡ��һ������+1
	private int front = -1;
	//��Ч���ݵ����һ��ָ�룬Ĭ�ϴ�-1��ʼ��ÿ�����һ�����ݣ���1
	private int rear = -1;
	//�����������
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
	 * pull:(ȡ�����ݣ��ƶ�ָ��)
	 * @author xiangning
	 *
	 * @return
	 */
	public T pull() {
		if(isEmpty()) {
			throw new RuntimeException("��ǰ����Ϊ�գ�û������");
		}
		front++;
		return arrs[front];
	}
	
	/**
	 * add:(�������)
	 * @author xiangning
	 *
	 * @param t
	 */
	public void add(T t) {
		if(isFull()) {
			throw new RuntimeException("��ǰ�������������������������");
		}
		rear++;
		arrs[rear] = t;		
	}
	
	/**
	 * show:(��ʾ����)
	 * @author xiangning
	 *
	 */
	public void show() {
		if(isEmpty()) {
			System.out.println("��ǰ����û������");
			return;
		}
		System.out.println("------��ʾ����----------");
	
		for (int i = front + 1; i <= rear; i++) {
			System.out.printf("%d => %d\n",i+1,arrs[i]);
		}
		
		System.out.println("---------------------");
	}
	
	/**
	 * count:(�����ж��ٸ���Ч����)
	 * @author xiangning
	 *
	 */
	public void count() {
		System.out.printf("��Ч�����У� %d ��\n",rear-front);
	}
	
	/**
	 * get:(��ȡ��ǰ��һ�����ݣ����ƶ�ָ��)
	 * @author xiangning
	 *
	 * @return
	 */
	public T get() {
		if(isEmpty()) {
			throw new RuntimeException("��ǰ����Ϊ�գ�û������");
		}
		return arrs[front];
	}
	
	
}





