package com.study.algorithm.linkedlist;

import java.util.Map;
import java.util.Stack;

/**
 * <PRE>
 * �����ӣ�
 * 	������ĺ����ǣ�
 * 		��һ���ڵ㣬Ҳ����ͷ�ڵ㣬Ϊ��
 * 	ÿ���ڵ㶼Я����һ���ڵ������
 * 	ͨ��ͷ�ڵ㣬���Ի�ȡ�����нڵ�����
 * 	ÿ�ζ����ݲ���ʱ����Ҫ���б�����
 * 	���ݲ���ʱ��Ҫ����temp����ʾҪ�������ݵ�ǰһ���ڵ�
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��13��
 * @author xiangning
 * @since JDK1.8
 */
public class SingleLinkedListMain {
	
	public static void main(String[] args) {
		
		//����һЩ�ڵ�
		HeroNode node1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode node2 = new HeroNode(2, "¬����", "������");
		HeroNode node3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode node4 = new HeroNode(4, "������", "����ʤ");
		
		//����һ������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
//		System.out.println("������������");
//		singleLinkedList.addEnd(node1);
//		singleLinkedList.addEnd(node4);
//		singleLinkedList.addEnd(node2);
//		singleLinkedList.addEnd(node3);
//		//�����������
//		singleLinkedList.show();
		
		System.out.println("������������");
		singleLinkedList.add(node1);
		singleLinkedList.add(node4);
		singleLinkedList.add(node2);
		singleLinkedList.add(node3);
		//�������������
		singleLinkedList.show();
		
		System.out.println("ɾ��һ���ڵ�");
		singleLinkedList.delete(5);
		singleLinkedList.show();
		
		System.out.println("�޸�һ���ڵ�");
		HeroNode node5 = new HeroNode(4, "����", "����");
		singleLinkedList.update(node5);
		singleLinkedList.show();
		
		System.out.println("��ת���нڵ�");
		singleLinkedList.reverseNode();
		singleLinkedList.show();
		
		singleLinkedList.showReverseNode();
		System.out.println("������ʾ���нڵ㣬��֤��������ʾ�ڵ㲢û���ƻ���������");
		singleLinkedList.show();
		
		
		
	}

}



/**
 * <PRE>
 * ����һ�����б���
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��13��
 * @author xiangning
 * @since JDK1.8
 */
class SingleLinkedList{
	
	//ͷ�ڵ㣬Ĭ��Ϊnull
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	
	/**
	 * addEnd:(��ĩβ���һ���ڵ㣬�ڵ������б�����������������������ǰͷ��������������β��)
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
	 * add:(���ݽڵ�ı���������½ڵ��������е�λ�ã���ʱ�ڵ������б�����)
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
				//��ӵ�ĩβ
				temp.next = newNode;
				break;
			}
			if(temp.next.no == newNode.no) {
				System.out.println("��ǰӢ���Ѵ��ڣ����������");
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
	 * delete:(ɾ��ָ����ŵĽڵ�)
	 * @author xiangning
	 *
	 * @param no
	 */
	public void delete(int no) {
		
		HeroNode temp = head;
		while(temp.next != null) {
			if(temp.next.no == no) {
				temp.next = temp.next.next;
				System.out.printf("���%d -> ɾ���ɹ�\n",no);
				return;
			}else {
				temp = temp.next;
			}
		}
		System.out.printf("ɾ��ʧ�ܣ�û���ҵ����%d��Ӣ��\n",no);
	}
	
	/**
	 * update:(�޸�Ӣ��)
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
				System.out.printf("Ӣ��%s -> �޸ĳɹ�\n", heroNode.name);
				return;
			}
			temp = temp.next;
		}
		System.out.printf("û���ҵ�%dӢ�� -> �޸�ʧ��\n",heroNode.name);
	}
	
	
	/**
	 * reverseNode:(��ת���нڵ�)
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
	 * showReverseNode:(�����ӡ�ڵ�)
	 * @author xiangning
	 *
	 */
	public void showReverseNode() {
		//�����ڵ㣬���ڵ�ѹ��ջ��
		Stack<HeroNode> stack = new Stack<>();
		HeroNode temp = head.next;
		while(temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		System.out.println("������ʾ�ڵ�---����ʼ");
		while(stack.size() > 0) {
			HeroNode node = stack.pop();
			System.out.println(node);
		}
		System.out.println("������ʾ�ڵ�---������");
		System.out.println("������ӡ�ڵ㣬֤���ڵ�����û�б��ƻ���");
		this.show();
	}
	
	
	/**
	 * reversePrint:(�����ӡ)
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
	 * show:(�����������)
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
 * Ӣ�۽ڵ㣬�⽫�����ӵ�ÿ���ڵ�����
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��13��
 * @author xiangning
 * @since JDK1.8
 */
class HeroNode{
	//Ӣ�۱��
	public int no;
	
	//Ӣ������
	public String name;
	
	//Ӣ���ǳ�
	public String nickName;
	
	//��һ���ڵ�
	public HeroNode next;

	//����һ��Ӣ��
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





