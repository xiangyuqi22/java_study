package com.study.algorithm.sort.radix;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * 功能描述：桶排序 ->基数排序的升级版
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月12日
 * @author xiangning
 * @since JDK1.8
 */
public class RadixSort {
	
	@Test
	public void radixSortTest() {
		int[] arrs = new int[] {53, 3, 542, 748, 14, 214};
		System.out.println("原始数组 = " + Arrays.toString(arrs));
		int k = 10;//10个桶
		//创建10个桶用来装数据
		int[][] bucket = new int[k][arrs.length];
		//创建一个数组来记录每个桶的数据
		int[] bucketLengthCounts = new int[bucket.length];
		
		//遍历数组，获取每个数组的个位，然后放到相应的桶中
		int temp;
		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i]%10;
			bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
		}
		//然后从各个桶中按顺序取出数据放回原数组
		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucketLengthCounts[i]; j++) {
				arrs[index++] = bucket[i][j];
			}
			bucketLengthCounts[i] = 0;
		}
		System.out.println("第一轮排序后的数组：" + Arrays.toString(arrs));
		
		
		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i] / 10 % 10 ;
			bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
		}
		//然后从各个桶中按顺序取出数据放回原数组
		index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucketLengthCounts[i]; j++) {
				arrs[index++] = bucket[i][j];
			}
			bucketLengthCounts[i] = 0;
		}
		System.out.println("第二轮排序后的数组：" + Arrays.toString(arrs));
		
		
		

		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i] / 100 % 10 ;
			bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
		}
		//然后从各个桶中按顺序取出数据放回原数组
		index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucketLengthCounts[i]; j++) {
				arrs[index++] = bucket[i][j];
			}
			bucketLengthCounts[i] = 0;
		}
		System.out.println("第三轮排序后的数组：" + Arrays.toString(arrs));
		
	}
	
	@Test
	public void radixSortTest2() {
		int[] arrs = SortUtils.createArray(80000);
		arrs = new int[] {53, 3, 542, 748, 14, 214};
		radixSort(arrs);
	}
	
	private void radixSort(int[] arrs) {
		int k = 10;//10个桶
		//创建10个桶用来装数据
		int[][] bucket = new int[k][arrs.length];
		//创建一个数组来记录每个桶的数据
		int[] bucketLengthCounts = new int[bucket.length];
		
		//遍历数组，获取每个数组的个位，然后放到相应的桶中
		int temp;
		int index;
		int max = 0;
		for (int i = 0; i < arrs.length; i++) {
			max = max > arrs[i] ? max : arrs[i];
		}
		int maxLength = (max + "").length();
		for (int l = 0,n=1; l < maxLength; l++,n=n*10) {
			for (int i = 0; i < arrs.length; i++) {
				temp = arrs[i]/n % 10   ;
				bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
			}
			//然后从各个桶中按顺序取出数据放回原数组
			index = 0;
			for (int i = 0; i < bucket.length; i++) {
				for (int j = 0; j < bucketLengthCounts[i]; j++) {
					arrs[index++] = bucket[i][j];
				}
				bucketLengthCounts[i] = 0;
			}
//			System.out.println("第" + l + "轮排序后的数组：" + Arrays.toString(arrs));
		}
	}
	
	
	@Test
	public void radixSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		radixSort(arrs);
	}
	
	/**、
	 * mergeSortEfficiency8000000Test:(这里用一句话描述这个方法的作用)
	 * @author xiangning
	 *
	 */
	@Test
	public void radixSortEfficiency8000000Test() {
		int[] arrs = SortUtils.createArray(8000000);
		radixSort(arrs);
	}
	
}
