package com.study.algorithm.search;

import java.util.Arrays;

import org.junit.Test;

/**
 * <PRE>
 * 功能描述：斐波那契 查找算法
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月13日
 * @author xiangning
 * @since JDK1.8
 */
public class FibonacciSearch {
	
	int count;

	@Test
	public void fibonacciSearchTest() {
//		int[] arrs = new int[] {122, 122, 124, 124, 126, 128};
		int[] arrs = new int[] {2, 4, 6, 7, 9, 14, 14, 23, 31, 37, 41, 46, 52, 53, 67, 74, 78, 78, 80, 84, 88, 95, 117, 122, 122, 124, 124, 126, 128};
		int key = 68;
		int resultIndex = fibonacciSearch1(arrs,key);
		System.out.println("resultIndex = " + resultIndex);
		System.out.println("插入排序，查询次数 = " + count);
	}

	
	
	private int fibonacciSearch1(int[] arrs, int key) {
		//1、创建一个斐波那契数列，数列逻辑如：{1,1,2,3,5,8,13,21,34}
		int[] fibArrs = new int[20];
		fibArrs[0] = 1;
		fibArrs[1] = 1;
		for (int i = 2; i < fibArrs.length; i++) {
			fibArrs[i] = fibArrs[i-1] + fibArrs[i-2];
		}
		System.out.println("获取到的斐波那契数列  = " + Arrays.toString(fibArrs));
		
		int low = 0;
		int high = arrs.length - 1;
		int mid = 0;
		int k = 0;
		while(arrs.length >= fibArrs[k]) {
			k++;
		}
		System.out.println("数组长度 = " + fibArrs[k]);
		
		//创建一个适合斐波那契长度的数列
		int[] tempArrs = Arrays.copyOf(arrs, fibArrs[k]);
		
		//将新扩充的数组后面的数据以原始数据的最后一个数据进行填充
		for (int i = arrs.length; i < tempArrs.length; i++) {
			tempArrs[i] = arrs[high];
		}
		
		System.out.println("优化后的临时数组 = " + Arrays.toString(tempArrs));
		
		//循环求索引
		int temp;
		while(low <= high) {
			System.out.println("查询次数 = "+ ++count);
			mid = low + fibArrs[k - 1] - 1; //
			temp = tempArrs[mid];
			if(temp > key) {
				//如果当前值比目标值要大，则需要向左寻找，左边即为斐波那契数组的前一个数的区域
				high = mid -1;
				k--;
			}else if(temp < key) {
				//如果当前值比目标值要小，则需要向右寻找，
				low = mid + 1;
				k -= 2;
			}else {
				if(mid > arrs.length-1) {
					return arrs.length-1;
				}else {
					return mid;
				}
			}
		}
		return -1;
	}

}
