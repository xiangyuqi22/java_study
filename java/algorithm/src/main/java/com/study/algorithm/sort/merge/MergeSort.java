package com.study.algorithm.sort.merge;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * 功能描述：归并排序算法
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月12日
 * @author xiangning
 * @since JDK1.8
 */
public class MergeSort {
	
	@Test
	public void mergeSortTest() {
		int[] arrs = new int[] {8,4,5,7,1,3,6,2};
		arrs = new int[] {8,4,5,7,1,3,6,2,32,432,234,234,22,4332543,6534,6,346,3463};
		arrs = new int[] {32,43,5,654,765,24,74,7654,23,8,4,5,7,1,3,6,2,32,432,234,234,22,4332543,6534,6,346,3463};
//		arrs = SortUtils.createArray(8000000);
		mergeSort(arrs, 0, arrs.length-1,new int[arrs.length]);
		System.out.println("排序后的数组 = " + Arrays.toString(arrs));
	}
	
	/**
	 * mergeSort:(归并排序：分)
	 * @author xiangning
	 *
	 * @param arrs	原始数据
	 * @param left	最左边索引
	 * @param right	最右边索引
	 * @param tempArrs	临时数组，需要占用额外空间
	 */
	private void mergeSort(int[] arrs,int left,int right,int[] tempArrs) {
		if(left < right) {
			int mid = (right-left)/2 + left;
			//向左递归分解
			mergeSort(arrs, left, mid,tempArrs);
			//向右递归分解
			mergeSort(arrs, mid+1, right,tempArrs);
			//合并排序
			mergeSort(arrs, left, right,mid,tempArrs);
		}
	}
	
	/**
	 * mergeSort:(归并排序：合)
	 * @author xiangning
	 *
	 * @param arrs	原始数据	
	 * @param left	左起索引
	 * @param right	最右边索引
	 * @param mid	中分
	 * @param tempArrs	临时数组
	 */
	private void mergeSort(int[] arrs,int left,int right,int mid,int[] tempArrs) {
		int index = 0;
		int j = mid+1;
		for (int i = left; i <= mid; i++) {
			while(j <= right && arrs[j] < arrs[i]) {
				tempArrs[index++] = arrs[j++];
			}
			tempArrs[index++] = arrs[i];
		}
		
		if(j<=right) {
			for (int i = j; i <=right; i++) {
				tempArrs[index++] = arrs[i];
			}
		}
		
		for (int i = 0; i < index; i++) {
			arrs[left + i] = tempArrs[i];
		}
	}
	
	/**
	 * mergeSortEfficiencyTest:(测试归并排序效率)
	 * @author xiangning
	 *
	 */
	@Test
	public void mergeSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
//		System.out.println(arrs.length);
		mergeSort(arrs, 0, arrs.length-1,new int[arrs.length]);
//		System.out.println(arrs.length);
	}
	
	/**
	 * mergeSortEfficiency8000000Test:(测试归并排序8百万个数据)
	 * @author xiangning
	 *
	 */
	@Test
	public void mergeSortEfficiency8000000Test() {
		int[] arrs = SortUtils.createArray(8000000);
		mergeSort(arrs, 0, arrs.length-1,new int[arrs.length]);
	}
	
	
	
	

}
