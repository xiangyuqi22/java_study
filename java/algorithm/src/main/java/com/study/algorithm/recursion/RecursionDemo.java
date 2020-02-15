package com.study.algorithm.recursion;

import org.junit.Test;

/**
 * <PRE>
 * 递归算法
 * 递归调用规则：
		1. 当程序执行到一个方法时，就会开辟一个独立的空间(栈)
		2. 每个空间的数据(局部变量)，是独立的.
 * 
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月31日
 * @author xiangning
 * @since JDK1.8
 */
public class RecursionDemo {
	
	
	@Test
	public void mazeDemo() {
		//定义一个地图
		int[][] map = new int[8][7];
		
		//绘制外墙
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(i == 0 || i == map.length-1 || j == 0 || j==map[i].length -1) {
					map[i][j] = 1;
				}
			}
		}
		
		//绘制内墙
		map[3][1] = 1;
		map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][2] = 1;
		//显示绘制好的地图
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
		//递归走球
		this.maze(map,1,1);
		
		
		//显示走完后的路线图
		System.out.println("------显示走完后的路线图------");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		
	}

	/**
	 * maze:(迷宫问题核心代码)
	 * @author xiangning
	 * 
	 * 1：墙面
	 * 2：可行路线
	 * 3：不可行路线
	 *
	 * @param map	地图
	 * @param i	当前纵坐标
	 * @param j	当前横坐标
	 * @return	当前可走，返回true，当前不可走，返回false
	 */
	public boolean maze(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		}
		if(map[i][j] == 0) {
			//当前路是通的
			map[i][j] = 2;
			if( maze(map,i+1,j) || maze(map,i,j+1) || maze(map,i-1,j) || maze(map,i,j-1)  ) {
				return true;
			}
			map[i][j] = 3;
			return false;
		}else {
			//如果当前路走过，或者为墙面，或者不通
			return false;
		}
	}

}
