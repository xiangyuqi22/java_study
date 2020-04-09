package com.study.algorithm.tree.binarytree;

import org.junit.Test;

/**
 * <PRE>
 * 功能描述：顺序二叉树
 * 顺序二叉树通常只考虑完全二叉树
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月19日
 * @author xiangning
 * @since JDK1.8
 */
public class SortBinaryTree {
	
	/**
	 * sortBinaryTreeTest1:(将数组转换为顺序二叉树)
	 * @author xiangning
	 *
	 */
	@Test
	public void sortBinaryTreeTest1() {
		int arrs[] = new int[] {1,2,3,4,5,6,7,8,9};
		if(arrs.length>0) {
			HeroNode root = new HeroNode(1,"1");
			sortBinaryTree1(arrs, root, 0);
			root.preOrder();
		}
		
	}
	
	public void sortBinaryTree1(int[] arrs,HeroNode node,int n) {
		int leftIndex = 2*n + 1;
		int rightIndex = 2*n + 2;
		if(leftIndex < arrs.length) {
			HeroNode left = new HeroNode(leftIndex,"" + leftIndex);
			node.setLeft(left);
			sortBinaryTree1(arrs, left, n+1);
		}
		if(rightIndex < arrs.length) {
			HeroNode right = new HeroNode(rightIndex,"" + rightIndex);
			node.setRight(right);
			sortBinaryTree1(arrs, right, n+1);
		}
		
	}

}
