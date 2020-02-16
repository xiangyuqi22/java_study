package com.study.algorithm.tree.binarytree;

import javax.sound.midi.Soundbank;

import org.junit.Test;

/**
 * <PRE>
 * 功能描述：二叉树
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月15日
 * @author xiangning
 * @since JDK1.8
 */
public class BinaryTreeDemo {
	
	@Test
	public void BinaryTreeTest1() {
		HeroNode heroNode1 = new HeroNode(10, "宋江");
		HeroNode heroNode2 = new HeroNode(20, "吴用");
		HeroNode heroNode3 = new HeroNode(30, "卢俊义");
		HeroNode heroNode32 = new HeroNode(32, "张顺");
		HeroNode heroNode35 = new HeroNode(35, "燕青");
		HeroNode heroNode37 = new HeroNode(37, "公孙胜");
		HeroNode heroNode4 = new HeroNode(40, "林冲");
		HeroNode heroNode5 = new HeroNode(50, "关胜");
		HeroNode heroNode6 = new HeroNode(60, "李逵");
		HeroNode heroNode05 = new HeroNode(5, "武松");
		
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
		
		
		System.out.println("前序遍历-------------------------------------");
		binaryTree.preOrder();
		System.out.println("中序遍历-------------------------------------");
		binaryTree.infixOrder();
		System.out.println("后序遍历-------------------------------------");
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
			System.out.println("没有根节点");
		}else {
			this.root.deleteNode2(id);
		}
	}

	public void postOrder() {
		if(this.root == null) {
			System.out.println("没有可遍历的节点");
		}else {
			this.root.postOrder();
		}
	}

	public void infixOrder() {
		if(this.root == null) {
			System.out.println("没有可遍历的节点");
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
			System.out.println("没有可遍历的节点");
		}else {
			this.root.preOrder();
		}
	}
	
	//前序查找
	public HeroNode preOrderSearch(int id) {
		if(this.root == null) {
			return null;
		}else {
			return this.root.preOrderSearch(id);
		}
	}
	//中序查找
	public HeroNode infixOrderSearch(int id) {
		if(this.root == null) {
			return null;
		}else {
			return this.root.infixOrderSearch(id);
		}
	}
	
	//后序查找
	public HeroNode postOrderSearch(int id) {
		if(this.root == null) {
			return null;
		}else {
			return this.root.postOrderSearch(id);
		}
	}
	
	//删除节点
	public void deleteNode(int id) {
		if(this.root == null) {
			System.out.println("该树上没有节点");
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
	
	//前序遍历 ，父，左，右
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	//中序遍历，左，父，右
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	
	
	//后序遍历，左，右，父
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	
	//前序查找，父，左，右
	public HeroNode preOrderSearch(int id) {
		System.out.println("前序查找 --> 查询次数");
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
	
	//中序查找
	public HeroNode infixOrderSearch(int id) {
		HeroNode heroNode = null;
		if(this.left != null) {
			heroNode = this.left.infixOrderSearch(id);
			if(heroNode != null) {
				return heroNode;
			}
		}
		System.out.println("中序查找 --> 查询次数");
		if(this.id == id) {
			return this;
		}
		if(this.right != null) {
			heroNode = this.right.infixOrderSearch(id);
		}
		
		return heroNode;
	}
	
	//后序查找
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
		System.out.println("后序查找 --> 查询次数");
		if(this.id == id) {
			return this;
		}
		return heroNode;
	}
	
	/**
	 * add:(添加一个节点)
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
			System.out.println("当前节点已存在");
		}
	}
	
	/**
	 * deleteNode:(删除一个节点及其子节点)
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
	
	//只删除一个节点，将左节点上移，问题（不能删除根节点）
	public void deleteNode2(int id) {
		HeroNode heroNode = this.getParentNode(id);
		if(heroNode != null) {
			if(heroNode.left != null && heroNode.left.id == id) {
				HeroNode temp = heroNode.left;	//需要删除的节点
				HeroNode deleteRight = temp.left;	//删除节点的左节点，删除父节点的左节点将指向它
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
				temp = temp.left;//待删除节点的左节点
				while(temp.right != null) {
					temp = temp.right;
				}
				temp.right = heroNode.right.right;
				heroNode.right = deleteRight;
			}
		}else {
			System.out.println("待删除的节点不存在");
		}
	}
	
	/**
	 * getParentNode:(获取当前节点的父节点)
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








