package com.study.algorithm.tree.binarytree;

import javax.sound.midi.Soundbank;

import org.junit.Test;

/**
 * <PRE>
 * ����������������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��15��
 * @author xiangning
 * @since JDK1.8
 */
public class BinaryTreeDemo {
	
	@Test
	public void BinaryTreeTest1() {
		HeroNode heroNode1 = new HeroNode(10, "�ν�");
		HeroNode heroNode2 = new HeroNode(20, "����");
		HeroNode heroNode3 = new HeroNode(30, "¬����");
		HeroNode heroNode32 = new HeroNode(32, "��˳");
		HeroNode heroNode35 = new HeroNode(35, "����");
		HeroNode heroNode37 = new HeroNode(37, "����ʤ");
		HeroNode heroNode4 = new HeroNode(40, "�ֳ�");
		HeroNode heroNode5 = new HeroNode(50, "��ʤ");
		HeroNode heroNode6 = new HeroNode(60, "����");
		HeroNode heroNode05 = new HeroNode(5, "����");
		
//		heroNode1.setLeft(heroNode2);
//		heroNode1.setRight(heroNode3);
//		
//		heroNode3.setLeft(heroNode5);
//		heroNode3.setRight(heroNode4);
		
		
		
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(heroNode3);
		binaryTree.add(heroNode1);
		binaryTree.add(heroNode2);
		binaryTree.add(heroNode4);
		binaryTree.add(heroNode5);
		binaryTree.add(heroNode6);
		binaryTree.add(heroNode35);
		binaryTree.add(heroNode32);
		binaryTree.add(heroNode37);
		binaryTree.add(heroNode05);
		
//		binaryTree.deleteNode(6);
//		binaryTree.deleteNode(30);
//		binaryTree.deleteNode2(35);
		binaryTree.deleteNode2(30);
//		binaryTree.deleteNode2(20);
		
		
		System.out.println("ǰ�����-------------------------------------");
		binaryTree.preOrder();
		System.out.println("�������-------------------------------------");
		binaryTree.infixOrder();
		System.out.println("�������-------------------------------------");
		binaryTree.postOrder();
		
		
		System.out.println("=====================================");
		HeroNode preOrderSearch = binaryTree.preOrderSearch(5);
		System.out.println(preOrderSearch);
		
		System.out.println("=====================================");
		HeroNode heroNode = binaryTree.infixOrderSearch(5);
		System.out.println(heroNode);
		
		System.out.println("=====================================");
		heroNode = binaryTree.postOrderSearch(5);
		System.out.println(heroNode);
	}

}

class BinaryTree{
	private HeroNode root;

	public HeroNode getRoot() {
		return root;
	}

	public void deleteNode2(int id) {
		if(this.root == null) {
			System.out.println("û�и��ڵ�");
		}else {
			this.root.deleteNode2(id);
		}
	}

	public void postOrder() {
		if(this.root == null) {
			System.out.println("û�пɱ����Ľڵ�");
		}else {
			this.root.postOrder();
		}
	}

	public void infixOrder() {
		if(this.root == null) {
			System.out.println("û�пɱ����Ľڵ�");
		}else {
			this.root.infixOrder();
		}
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	
	public void add(HeroNode heroNode) {
		if(this.root == null) {
			this.root = heroNode;
		}else {
			this.root.add(heroNode);
		}
	}
	
	public void preOrder() {
		if(this.root == null) {
			System.out.println("û�пɱ����Ľڵ�");
		}else {
			this.root.preOrder();
		}
	}
	
	//ǰ�����
	public HeroNode preOrderSearch(int id) {
		if(this.root == null) {
			return null;
		}else {
			return this.root.preOrderSearch(id);
		}
	}
	//�������
	public HeroNode infixOrderSearch(int id) {
		if(this.root == null) {
			return null;
		}else {
			return this.root.infixOrderSearch(id);
		}
	}
	
	//�������
	public HeroNode postOrderSearch(int id) {
		if(this.root == null) {
			return null;
		}else {
			return this.root.postOrderSearch(id);
		}
	}
	
	//ɾ���ڵ�
	public void deleteNode(int id) {
		if(this.root == null) {
			System.out.println("������û�нڵ�");
			return;
		}
		if(this.root.getId() == id) {
			this.root = null;
			return;
		}
		this.root.deleteNode(id);
	}
	
	
	
	
}

//--------------------------------------------------------------------------------------------------------------------
class HeroNode{
	
	private int id;
	
	private String name;
	
	private HeroNode left;
	
	private HeroNode right;

	public HeroNode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}
	
	//ǰ����� ����������
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	//����������󣬸�����
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	
	
	//������������ң���
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	
	//ǰ����ң���������
	public HeroNode preOrderSearch(int id) {
		System.out.println("ǰ����� --> ��ѯ����");
		if(this.id == id) {
			return this;
		}
		HeroNode heroNode = null;
		if(this.left != null) {
			heroNode = this.left.preOrderSearch(id);
			if(heroNode != null) {
				return heroNode;
			}
		}
		if(this.right != null){
			heroNode = this.right.preOrderSearch(id);
		}
		return heroNode;
	}
	
	//�������
	public HeroNode infixOrderSearch(int id) {
		HeroNode heroNode = null;
		if(this.left != null) {
			heroNode = this.left.infixOrderSearch(id);
			if(heroNode != null) {
				return heroNode;
			}
		}
		System.out.println("������� --> ��ѯ����");
		if(this.id == id) {
			return this;
		}
		if(this.right != null) {
			heroNode = this.right.infixOrderSearch(id);
		}
		
		return heroNode;
	}
	
	//�������
	public HeroNode postOrderSearch(int id) {
		HeroNode heroNode = null;
		if(this.left != null) {
			heroNode = this.left.postOrderSearch(id);
			if(heroNode != null) {
				return heroNode;
			}
		}
		if(this.right != null) {
			heroNode = this.right.postOrderSearch(id);
			if(heroNode != null) {
				return heroNode;
			}
		}
		System.out.println("������� --> ��ѯ����");
		if(this.id == id) {
			return this;
		}
		return heroNode;
	}
	
	/**
	 * add:(���һ���ڵ�)
	 * @author xiangning
	 *
	 * @param heroNode
	 */
	public void add(HeroNode heroNode) {
		if(heroNode.id < this.id) {
			if(this.left == null) {
				this.left = heroNode;
			}else {
				this.left.add(heroNode);
			}
		}else if (heroNode.id > this.id) {
			if(this.right == null) {
				this.right = heroNode;
			}else {
				this.right.add(heroNode);
			}
		}else {
			System.out.println("��ǰ�ڵ��Ѵ���");
		}
	}
	
	/**
	 * deleteNode:(ɾ��һ���ڵ㼰���ӽڵ�)
	 * @author xiangning
	 *
	 * @param id
	 */
	public void deleteNode(int id) {
		HeroNode heroNode = this.getParentNode(id);
		if(heroNode != null) {
			if(heroNode.left != null && heroNode.left.id == id) {
				heroNode.left = null;
			}else if(heroNode.right != null && heroNode.right.id == id) {
				heroNode.right = null;
			}
		}
	}
	
	//ֻɾ��һ���ڵ㣬����ڵ����ƣ����⣨����ɾ�����ڵ㣩
	public void deleteNode2(int id) {
		HeroNode heroNode = this.getParentNode(id);
		if(heroNode != null) {
			if(heroNode.left != null && heroNode.left.id == id) {
				HeroNode temp = heroNode.left;	//��Ҫɾ���Ľڵ�
				HeroNode deleteRight = temp.left;	//ɾ���ڵ����ڵ㣬ɾ�����ڵ����ڵ㽫ָ����
				if(temp.left == null) {
					heroNode.left = temp.right;
					return;
				}
				if(temp.right == null){
					heroNode.left = temp.left;
					return;
				}
				temp = temp.left;
				while(temp.right != null) {
					temp = temp.right;
				}
				temp.right = heroNode.left.right;
				heroNode.left = deleteRight;
			}else if(heroNode.right != null && heroNode.right.id == id) {
				HeroNode temp = heroNode.right;
				HeroNode deleteRight = heroNode.left;
				if(temp.left == null) {
					heroNode.right = temp.right;
					return;
				}
				if(temp.right == null){
					heroNode.right = temp.left;
					return;
				}
				temp = temp.left;//��ɾ���ڵ����ڵ�
				while(temp.right != null) {
					temp = temp.right;
				}
				temp.right = heroNode.right.right;
				heroNode.right = deleteRight;
			}
		}else {
			System.out.println("��ɾ���Ľڵ㲻����");
		}
	}
	
	/**
	 * getParentNode:(��ȡ��ǰ�ڵ�ĸ��ڵ�)
	 * @author xiangning
	 *
	 * @param id
	 * @return
	 */
	public HeroNode getParentNode(int id) {
		HeroNode heroNode = null;
		if(this.left != null) {
			if(this.left.id == id) {
				return this;
			}
			heroNode = this.left.getParentNode(id);
			if(heroNode != null) {
				return heroNode;
			}
		}
		if(this.right != null) {
			if(this.right.id == id) {
				return this;
			}
			heroNode = this.right.getParentNode(id);
			if(heroNode != null) {
				return heroNode;
			}
		}
		return null;
		
	}
	

	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}
	
}








