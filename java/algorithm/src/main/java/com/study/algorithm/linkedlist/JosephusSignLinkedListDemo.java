package com.study.algorithm.linkedlist;

import java.util.Arrays;

/**
 * <PRE>
 * Լɪ�����⣬�Ե���������ʵ��
 * 
 * ��˵������̫��ʷѧ�� Josephus�й����µĹ��£���������ռ���������غ�39 ����̫����Josephus���������Ѷ㵽һ�����У�
 * 39����̫�˾�����Ը��Ҳ��Ҫ������ץ�������Ǿ�����һ����ɱ��ʽ��41�����ų�һ��ԲȦ���ɵ�1���˿�ʼ������ÿ��������3�˸���
 * �ͱ�����ɱ��Ȼ��������һ�����±�����ֱ�������˶���ɱ����Ϊֹ��Ȼ��Josephus ���������Ѳ�������ӡ����ȴ�һ���˿�ʼ��Խ
 * ��k-2���ˣ���Ϊ��һ�����Ѿ���Խ��������ɱ����k���ˡ����ţ���Խ��k-1���ˣ���ɱ����k���ˡ������������ԲȦһֱ���У�ֱ��
 * ����ֻʣ��һ�������£�����˾Ϳ��Լ������š������ǣ������˺ͣ�һ��ʼҪվ��ʲô�ط����ܱ��ⱻ������JosephusҪ����������
 * ��װ��ӣ������������Լ������ڵ�16�����31��λ�ã������ӹ����ⳡ������Ϸ��
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��19��
 * @author xiangning
 * @since JDK1.8
 */
public class JosephusSignLinkedListDemo {

	public static void main(String[] args) {
		JosephusSignLinkedList josephusSignLinkedList = new JosephusSignLinkedList();
		josephusSignLinkedList.adds(41);
		josephusSignLinkedList.show();
		josephusSignLinkedList.popList(1,2);
	}

}

class JosephusSignLinkedList {
	private People first;

	/**
	 * adds:(һ�������n���ˣ�nҲ������ĳ���)
	 * 
	 * @author xiangning
	 *
	 */
	public void adds(int num) {
		People temPeople = null;
		for (int i = 1; i <= num; i++) {
			People newPeople = new People(i);
			if (i == 1) {
				first = newPeople;
				first.setNext(first);
				temPeople = first;
			} else {
				newPeople.setNext(first);
				temPeople.setNext(newPeople);
				temPeople = newPeople;
			}
		}
	}
	
	/**
	 * show:(�������еĽڵ�)
	 * @author xiangning
	 *
	 */
	public void show() {
		if(first == null) {
			System.out.println("�б���û����Ա");
			return;
		}
		People people = first;
		while(true) {
			System.out.printf("��� -> %d \n",people.getNo());
			people = people.getNext();
			if(people == first) {
				break;
			}
		}
	}
	
	/**
	 * popList:(չʾԼɪ������)
	 * 
	 * 
	 * 
	 * @author xiangning
	 *
	 * @param start	�ӵڼ����˿�ʼ������
	 * @param num	ÿ�������˳���
	 */
	public void popList(int start,int num) {
		
		if(first == null) {
			System.out.println("�б���û����Ա");
			return;
		}
		if(start <1 || num < 1 ) {
			System.out.println("���������д�����С��1");
			return;
		}
		
		/**
		 * 1���ȱ��������ҵ���һ����Ϊfirst
		 * 2����һ���˱���1�������ٱ�num-1�Σ��õ���Ҫ�������һ���ˡ�
		 */
		System.out.printf("�����ȡ�%d��\n",getListLength());
		
		People temp = first;
		for (int i = 1; i < start; i++) {
			first = first.getNext();
		}
		
		System.out.printf("�ӱ��Ϊ%d���˿�ʼ������\n",first.getNo());
		int l = getListLength();
		int leng = l/2;
		leng = l%2 == 0 ? leng : leng+1;
		int[] arrs = new int[leng];
		int count = 0;
		while(true) {
			temp = first;
			//�ҵ�Ҫ���е���һ����
			for (int i = 1; i < num ; i++) {
				temp = temp.getNext();
			}
			if(leng <= ++count) {
				arrs[count - leng] = temp.getNext().getNo();
			}
			System.out.printf("%d -> ",temp.getNext().getNo());
			//����һ���˳���
			temp.setNext(temp.getNext().getNext());
			first = temp.getNext();			
			if(first.getNext() == first) {
				break;
			}
		}
		System.out.printf("%d \n",first.getNo());
		arrs[arrs.length-1] = first.getNo();
		
		for (int i = 0; i < arrs.length; i++) {
			System.out.printf("%d -> ",arrs[i]);
		}
		
		
	}
	
	public int getListLength() {
		if(first == null) {
			return 0;
		}
		int length = 1;
		People temp =first;
		while(first != temp.getNext()) {
			length++;
			temp = temp.getNext();
		}
		
		return length;
	}
	
	
	

}

class People {

	private int no;
	private People next;

	public People(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public People getNext() {
		return next;
	}

	public void setNext(People next) {
		this.next = next;
	}

}
