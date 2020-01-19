package com.study.algorithm.queue;

import java.util.Scanner;

import org.junit.Test;

/**
 * <PRE>
 * ���ζ���
 * ���ظ�����
 * ��������ȡģ
 * 
 * 
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
public class CircleQueue1 {
	
	@Test
	public void test1() {
		Integer[] arr = new Integer[4];
		CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(arr);
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
					circleQueue.add(nextInt);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "p":
				try {
					Integer pull = circleQueue.pull();
					System.out.printf("ȡ������  => %d\n",pull);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "g":
				try {
					Integer pull = circleQueue.get();
					System.out.printf("ȡ��ͷ����  => %d\n",pull);
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
				System.out.println("����������������룺");
			}
		}
		//TODO ��ʼ���Զ���
		scanner.close();
		System.out.println("���˳�");
	}

}



class CircleQueue<T>{
	//���ɶ������ݵ�����
	private T[] arrs;
	//ȡ���ݵ�ָ�룬ָ��ǰ��ȡ�������ݣ���ʼֵΪ0
	private int front;
	//��Ч���ݵ����һ��ָ�룬Ĭ�ϴ�0��ʼ��ÿ����һ�����ݣ���ǰֵ��1
	private int rear;
	//�����������
	private int maxSize;
	
	
	public CircleQueue(T[] arrs) {
		this.arrs = arrs;
		this.maxSize = arrs.length;
	}
	
	/**
	 * isFull:(�ж��Ƿ�����������ǰ��Ч����ΪmaxSize-1ʱ���ͱ�ʾ������)
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
	 * pull:(ȡ�����ݣ��ƶ�ָ��)
	 * @author xiangning
	 *
	 * @return
	 */
	public T pull() {
		if(isEmpty()) {
			throw new RuntimeException("��ǰ����Ϊ�գ�û������");
		}
		T t = arrs[front];
		front = (front+1)%maxSize;
		return t;
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
		arrs[rear] = t;		
		rear = (rear+1)%maxSize;
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
		for (int i = front; i < (front + count()); i++) {
			System.out.printf("%d -> %d",i,arrs[i%maxSize]);
		}
		System.out.println("---------------------");
	}
	
	/**
	 * count:(�����ж��ٸ���Ч����)
	 * @author xiangning
	 *
	 */
	public int count() {
		System.out.printf("��Ч�����У� %d ��\n",(rear+maxSize-front)% maxSize);
		return (rear+maxSize-front)% maxSize;
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
