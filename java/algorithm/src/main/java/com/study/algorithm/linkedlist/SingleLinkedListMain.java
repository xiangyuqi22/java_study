package com.study.algorithm.linkedlist;

import java.util.Map;
import java.util.Stack;

/**
 * <PRE>
 * 单链接：
 * 	该链表的核心是：
 * 		第一个节点，也就是头节点，为空
 * 	每个节点都携带下一个节点的数据
 * 	通过头节点，可以获取到所有节点数据
 * 	每次对数据操作时，需要进行遍历。
 * 	数据操作时需要借助temp来表示要操作数据的前一个节点
 * 
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月13日
 * @author xiangning
 * @since JDK1.8
 */
public class SingleLinkedListMain {
	
	public static void main(String[] args) {
		
		//创建一些节点
		HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode node3 = new HeroNode(3, "吴用", "智多星");
		HeroNode node4 = new HeroNode(4, "入云龙", "公孙胜");
		
		//创建一个链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
//		System.out.println("插入无序链表");
//		singleLinkedList.addEnd(node1);
//		singleLinkedList.addEnd(node4);
//		singleLinkedList.addEnd(node2);
//		singleLinkedList.addEnd(node3);
//		//输出链表（无序）
//		singleLinkedList.show();
		
		System.out.println("插入有序链表");
		singleLinkedList.add(node1);
		singleLinkedList.add(node4);
		singleLinkedList.add(node2);
		singleLinkedList.add(node3);
		//输出链表（有序序）
		singleLinkedList.show();
		
		System.out.println("删除一个节点");
		singleLinkedList.delete(5);
		singleLinkedList.show();
		
		System.out.println("修改一个节点");
		HeroNode node5 = new HeroNode(4, "武松", "行者");
		singleLinkedList.update(node5);
		singleLinkedList.show();
		
		System.out.println("反转所有节点");
		singleLinkedList.reverseNode();
		singleLinkedList.show();
		
		singleLinkedList.showReverseNode();
		System.out.println("正常显示所有节点，以证明倒序显示节点并没有破坏链表数据");
		singleLinkedList.show();
		
		
		
	}

}



/**
 * <PRE>
 * 创建一个单列表类
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月13日
 * @author xiangning
 * @since JDK1.8
 */
class SingleLinkedList{
	
	//头节点，默认为null
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	
	/**
	 * addEnd:(在末尾添加一个节点，节点无序，列表有序，先入的数据在链表的最前头，后入的在链表的尾部)
	 * @author xiangning
	 *
	 */
	public void addEnd(HeroNode newNode) {
		HeroNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	/**
	 * add:(根据节点的编号来决定新节点在链表中的位置，此时节点有序，列表无序)
	 * @author xiangning
	 *
	 * @param newNode
	 */
	public void add(HeroNode newNode) {
		HeroNode temp = head;
		if(temp.next == null) {
			temp.next = newNode;
			return;
		}
		while(true) {
			if(temp.next == null) {
				//添加到末尾
				temp.next = newNode;
				break;
			}
			if(temp.next.no == newNode.no) {
				System.out.println("当前英雄已存在，不可再添加");
				break;
			}
			if(newNode.no < temp.next.no) {
				newNode.next = temp.next;
				temp.next = newNode;
				break;
			}else {
				 temp = temp.next;
			}
		}
	}
	
	/**
	 * delete:(删除指定编号的节点)
	 * @author xiangning
	 *
	 * @param no
	 */
	public void delete(int no) {
		
		HeroNode temp = head;
		while(temp.next != null) {
			if(temp.next.no == no) {
				temp.next = temp.next.next;
				System.out.printf("编号%d -> 删除成功\n",no);
				return;
			}else {
				temp = temp.next;
			}
		}
		System.out.printf("删除失败，没有找到编号%d的英雄\n",no);
	}
	
	/**
	 * update:(修改英雄)
	 * @author xiangning
	 *
	 * @param heroNode
	 */
	public void update(HeroNode heroNode) {
		
		HeroNode temp = head;
		while(temp.next != null) {
			if(temp.next.no == heroNode.no) {
				heroNode.next = temp.next.next;
				temp.next = heroNode;
				System.out.printf("英雄%s -> 修改成功\n", heroNode.name);
				return;
			}
			temp = temp.next;
		}
		System.out.printf("没有找到%d英雄 -> 修改失败\n",heroNode.name);
	}
	
	
	/**
	 * reverseNode:(反转所有节点)
	 * @author xiangning
	 *
	 */
	public void reverseNode() {
		HeroNode  newHead = new HeroNode(0,"","");
		HeroNode temp = head.next;
		while(temp != null){
			HeroNode node = temp;
			temp = temp.next;
			node.next = newHead.next;
			newHead.next = node;			
		}
		head.next = newHead.next; 
	}
	
	/**
	 * showReverseNode:(倒序打印节点)
	 * @author xiangning
	 *
	 */
	public void showReverseNode() {
		//遍历节点，将节点压入栈中
		Stack<HeroNode> stack = new Stack<>();
		HeroNode temp = head.next;
		while(temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		System.out.println("倒序显示节点---》开始");
		while(stack.size() > 0) {
			HeroNode node = stack.pop();
			System.out.println(node);
		}
		System.out.println("倒序显示节点---》结束");
		System.out.println("正常打印节点，证明节点数据没有被破坏！");
		this.show();
	}
	
	
	/**
	 * reversePrint:(倒序打印)
	 * @author xiangning
	 *
	 */
	public void reversePrint() {
		
	}
	
	
	
	
	
	public void copyMap(Map<String,Object> source,Map<String,Object> target) {
		for (Map.Entry<String,Object> entry : source.entrySet()) {
			target.put(entry.getKey(), entry.getValue());
		}
	}
	
	
	/**
	 * show:(遍历输出链表)
	 * @author xiangning
	 *
	 */
	public void show() {
		HeroNode temp = head.next;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	
}



















/**
 * <PRE>
 * 英雄节点，这将是链接的每个节点数据
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月13日
 * @author xiangning
 * @since JDK1.8
 */
class HeroNode{
	//英雄编号
	public int no;
	
	//英雄名字
	public String name;
	
	//英雄昵称
	public String nickName;
	
	//下一个节点
	public HeroNode next;

	//构造一个英雄
	public HeroNode(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
		
}





