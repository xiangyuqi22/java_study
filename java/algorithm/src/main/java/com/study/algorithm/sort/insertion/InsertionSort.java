package com.study.algorithm.sort.insertion;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * 插入排序
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月6日
 * @author xiangning
 * @since JDK1.8
 */
public class InsertionSort {

	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("------------------------插入排序---开始--------------------------");
		int count = 0;
		for (int i = 1; i < arrs.length; i++) {
			int a = arrs[i];
			for (int j = i - 1; j >= 0 && a < arrs[j]; j--) {
				count++;
				arrs[j + 1] = arrs[j];
				arrs[j] = a;
			}
		}
		System.out.println("计算次数：" + count + "次");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------插入排序---结束--------------------------");
	}

	/**
	 * insertionSortTest1:(选择排序的基本思路)
	 * 
	 * 将n前的数据排序成有序的列表 n后的数据为无序列表 将无序列表里面的第一个数依次插入到有序列表中
	 * 
	 * 
	 * @author xiangning
	 *
	 */
	@Test
	public void insertionSortTest1() {
		int[] arrs = new int[] { -2, -10, 0, 9, 11, 23, 18, 38, 49, 60, 9 };
		arrs = new int[] { 101, 34, 119, 1 };
		System.out.println(Arrays.toString(arrs));
		int count = 0;
		// 从小到大排序
		// 第一轮
		int indexVal = arrs[1];// 从第二个数开始，因为第一个数据不需要比，默认就是有序
		int index = 1 - 1;// 从第一个数开始进行比较
		while (index >= 0 && indexVal < arrs[index]) {
			arrs[index + 1] = arrs[index];
			index--;
		}
		// 此时获取的index的值比当前indexVal小
		arrs[index + 1] = indexVal;
		System.out.println("第一轮过后");
		System.out.println(Arrays.toString(arrs));

		// 第二轮
		indexVal = arrs[2];// 从第二个数开始，因为第一个数据不需要比，默认就是有序
		index = 2 - 1;// 从第一个数开始进行比较
		while (index >= 0 && indexVal < arrs[index]) {
			arrs[index + 1] = arrs[index];
			index--;
		}
		// 此时获取的index的值比当前indexVal小
		arrs[index + 1] = indexVal;
		System.out.println("第二轮过后");
		System.out.println(Arrays.toString(arrs));

		// 第三轮
		indexVal = arrs[3];// 从第二个数开始，因为第一个数据不需要比，默认就是有序
		index = 3 - 1;// 从第一个数开始进行比较
		while (index >= 0 && indexVal < arrs[index]) {
			arrs[index + 1] = arrs[index];
			index--;
		}
		// 此时获取的index的值比当前indexVal小
		arrs[index + 1] = indexVal;
		System.out.println("第三轮过后");
		System.out.println(Arrays.toString(arrs));
		
		
		System.out.println("计算次数：" + count + "次");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------选择排序---结束--------------------------");
	}
	
	
	@Test
	public void insertionSortTest2() {
		int[] arrs = new int[] { -2, -10, 0, 9, 11, 23, 18, 38, 49, 60, 9 };
		System.out.println(Arrays.toString(arrs));
		int count = 0;
		
		//组合
		int indexVal = 0;
		int index = 0;
		for (int i = 1; i < arrs.length; i++) {
			indexVal = arrs[i];// 从第二个数开始，因为第一个数据不需要比，默认就是有序
			index = i - 1;// 从第一个数开始进行比较
			while (index >= 0 && indexVal < arrs[index]) {
				count++;
				arrs[index + 1] = arrs[index];
				index--;
			}
			// 此时获取的index的值比当前indexVal小
			arrs[index + 1] = indexVal;
			System.out.println("第" + i + "轮过后");
			System.out.println(Arrays.toString(arrs));
		}
		
		System.out.println("计算次数：" + count + "次");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------选择排序---结束--------------------------");
	}
	
	
	/**
	 * insertionSortEfficiencyTest:(测试8万个数据所用的时间，耗时约3秒左右)
	 * @author xiangning
	 *
	 */
	@Test
	public void insertionSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		int count = 0;
		//组合
		int indexVal = 0;
		int index = 0;
		for (int i = 1; i < arrs.length; i++) {
			indexVal = arrs[i];// 从第二个数开始，因为第一个数据不需要比，默认就是有序
			index = i - 1;// 从第一个数开始进行比较
			while (index >= 0 && indexVal < arrs[index]) {
				count++;
				arrs[index + 1] = arrs[index];
				index--;
			}
			arrs[index + 1] = indexVal;
		}
		
	}


}
