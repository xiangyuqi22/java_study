package com.study.algorithm.array;

import org.junit.Test;

/**
 * <PRE>
 * ϡ���㷨��
 * �ռ�ѹ��
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��10��
 * @author xiangning
 * @since JDK1.8
 */
public class SparseAlgorithm {
	
	
	/**
	 * createArray:(����һ����ά����)
	 * @author xiangning
	 *
	 * @return
	 */
	public static int[][] createArray(int size){
		int[][] arrays = new int[size][size];
		arrays[1][1] = 1;
		arrays[2][2] = 2;
		arrays[3][3] = 3;
		arrays[4][4] = 4;
		arrays[5][4] = 9;
		arrays[4][5] = 6;
		arrays[2][4] = 10;
		
		System.out.println("-------------------------------------ԭʼ����-------------------------------------");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%d\t",arrays[i][j]);
			}
			System.out.println();
		}
		return arrays;
	}
	
	
	@Test
	public void test1() {
		int[][] array = createArray(10);
		
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i][j] != 0 ) {
					sum++;
				}
			}
		}
		
		int[][] arrs = new int[sum+1][3];
		
		
		arrs[0][0] = array.length;
		arrs[0][1] = array[0].length;
		arrs[0][2] = sum;
		
		
		int count = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i][j] != 0 ) {
					arrs[count][0] = i;
					arrs[count][1] = j;
					arrs[count][2] = array[i][j];
					count++;
				}
			}
		}
		
		System.out.println("-------------------------------------ѹ������-------------------------------------");
		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%d\t",arrs[i][j]);
			}
			System.out.println();
		}
		
		
		System.out.println("-------------------------------------��ѹ����-------------------------------------");
		
		
		int[][] array2 = new int[arrs[0][0]][arrs[0][1]];
		
		for (int i = 1; i < arrs.length; i++) {
			array2[arrs[i][0]][arrs[i][1]] = arrs[i][2];
		}
		
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				System.out.printf("%d\t",array2[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
