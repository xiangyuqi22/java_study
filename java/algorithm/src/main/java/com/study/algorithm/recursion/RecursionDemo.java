package com.study.algorithm.recursion;

import org.junit.Test;

/**
 * <PRE>
 * �ݹ��㷨
 * �ݹ���ù���
		1. ������ִ�е�һ������ʱ���ͻῪ��һ�������Ŀռ�(ջ)
		2. ÿ���ռ������(�ֲ�����)���Ƕ�����.
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��31��
 * @author xiangning
 * @since JDK1.8
 */
public class RecursionDemo {
	
	
	@Test
	public void mazeDemo() {
		//����һ����ͼ
		int[][] map = new int[8][7];
		
		//������ǽ
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(i == 0 || i == map.length-1 || j == 0 || j==map[i].length -1) {
					map[i][j] = 1;
				}
			}
		}
		
		//������ǽ
		map[3][1] = 1;
		map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][2] = 1;
		//��ʾ���ƺõĵ�ͼ
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
		//�ݹ�����
		this.maze(map,1,1);
		
		
		//��ʾ������·��ͼ
		System.out.println("------��ʾ������·��ͼ------");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		
	}

	/**
	 * maze:(�Թ�������Ĵ���)
	 * @author xiangning
	 * 
	 * 1��ǽ��
	 * 2������·��
	 * 3��������·��
	 *
	 * @param map	��ͼ
	 * @param i	��ǰ������
	 * @param j	��ǰ������
	 * @return	��ǰ���ߣ�����true����ǰ�����ߣ�����false
	 */
	public boolean maze(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		}
		if(map[i][j] == 0) {
			//��ǰ·��ͨ��
			map[i][j] = 2;
			if( maze(map,i+1,j) || maze(map,i,j+1) || maze(map,i-1,j) || maze(map,i,j-1)  ) {
				return true;
			}
			map[i][j] = 3;
			return false;
		}else {
			//�����ǰ·�߹�������Ϊǽ�棬���߲�ͨ
			return false;
		}
	}

}
