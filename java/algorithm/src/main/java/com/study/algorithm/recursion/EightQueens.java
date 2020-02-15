package com.study.algorithm.recursion;

import java.util.Arrays;

import org.junit.Test;

/**
 * <PRE>
 * 递归-八皇后问题(回溯算法)
	八皇后问题算法思路分析
	
	第一个皇后先放第一行第一列
	第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
	继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
	当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
	然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤 【示意图】
	
	说明：理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，
	用一个一维数组即可解决问题. arr[8] = {0 , 4, 7, 5, 2, 6, 1, 3} 
	//对应arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第i+1个皇后，放在第i+1行的第val+1列



 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年2月3日
 * @author xiangning
 * @since JDK1.8
 */
public class EightQueens {
	
	@Test
	public void test1() {
		check(0);
		System.out.printf("一共有%d种解法\n",count);
		System.out.printf("一共进行了%d次判断运算",maxGudge);
		
		
	}
	
	
	//定义有多少个皇后
	private int max = 8;
	
	//定义一个数组用来表示皇后摆放的位置
	//使用一维数组表示，下标表示第几行，值表示第几列 
	private int[] arrs = new int[max];
	
	//定义有多少种放置方式
	private int count;
	
	//定义当前算法中有多少次判断
	private int maxGudge;
	
	
	//打印数组
	private void print() {
		count++;
		System.out.println(Arrays.toString(arrs));;
	}
	
	
	/**
	 * gudge:(判断第n个皇后与前面皇后所放的位置是否有冲突)
	 * @author xiangning
	 *
	 * @param n 第n+1个皇后，n从0开始，0即第一个皇后
	 * @return
	 */
	private boolean gudge(int n) {
		
		for (int i = 0; i < n; i++) {
			maxGudge++;
			if(arrs[i] == arrs[n] || Math.abs(n-i) == Math.abs(arrs[n] - arrs[i])) {
				//arrs[i] == arrs[n] 如果它们所处在同一列，则表示有冲突
				// Math.abs(n-i) == Math.abs(arrs[n] - arrs[i]) 如果在正方形对角线，则表示有冲突
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * check:(检查并放置皇后)
	 * @author xiangning
	 *
	 * @param n 放置第n个皇后
	 */
	private void check(int n) {
		if(n >= max) {
			//超过了最多的皇后，则直接返回
			print();
			return;
		}
		for (int i = 0; i < max ;i++) {
			arrs[n] = i;//先把第n个皇后放在第一列
			if(gudge(n)) {
				//如果第n个皇后跟前面的没有冲突，那么再放下一个皇后
				check(n+1);
			}
		}
	}
	
	

}
