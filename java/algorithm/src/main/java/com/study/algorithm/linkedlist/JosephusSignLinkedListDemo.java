package com.study.algorithm.linkedlist;

import java.util.Arrays;

/**
 * <PRE>
 * 约瑟夫问题，以单向环形链表实现
 * 
 * 据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，
 * 39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人
 * 就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从。首先从一个人开始，越
 * 过k-2个人（因为第一个人已经被越过），并杀掉第k个人。接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行，直到
 * 最终只剩下一个人留下，这个人就可以继续活着。问题是，给定了和，一开始要站在什么地方才能避免被处决？Josephus要他的朋友先
 * 假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月19日
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
	 * adds:(一次性添加n个人，n也是链表的长度)
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
	 * show:(遍历所有的节点)
	 * @author xiangning
	 *
	 */
	public void show() {
		if(first == null) {
			System.out.println("列表中没有人员");
			return;
		}
		People people = first;
		while(true) {
			System.out.printf("编号 -> %d \n",people.getNo());
			people = people.getNext();
			if(people == first) {
				break;
			}
		}
	}
	
	/**
	 * popList:(展示约瑟夫问题)
	 * 
	 * 
	 * 
	 * @author xiangning
	 *
	 * @param start	从第几个人开始报数，
	 * @param num	每隔几个人出列
	 */
	public void popList(int start,int num) {
		
		if(first == null) {
			System.out.println("列表中没有人员");
			return;
		}
		if(start <1 || num < 1 ) {
			System.out.println("输入数据有错，不能小于1");
			return;
		}
		
		/**
		 * 1、先遍历链表，找到第一个人为first
		 * 2、第一个人报数1，往后再报num-1次，得到这要出殡的上一个人。
		 */
		System.out.printf("链表长度【%d】\n",getListLength());
		
		People temp = first;
		for (int i = 1; i < start; i++) {
			first = first.getNext();
		}
		
		System.out.printf("从编号为%d的人开始报数。\n",first.getNo());
		int l = getListLength();
		int leng = l/2;
		leng = l%2 == 0 ? leng : leng+1;
		int[] arrs = new int[leng];
		int count = 0;
		while(true) {
			temp = first;
			//找到要出列的上一个人
			for (int i = 1; i < num ; i++) {
				temp = temp.getNext();
			}
			if(leng <= ++count) {
				arrs[count - leng] = temp.getNext().getNo();
			}
			System.out.printf("%d -> ",temp.getNext().getNo());
			//将下一个人出列
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
