package com.study.algorithm.sort.shell;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * 学习地址<a href=
"https://www.cnblogs.com/guoyaohua/p/8600214.html"/>https://www.cnblogs.com/guoyaohua/p/8600214.html</a>
 * 
 * 希尔排序
 * 
 * 
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月6日
 * @author xiangning
 * @since JDK1.8
 */
public class ShellSort {

	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("------------------------插入排序---开始--------------------------");

		arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		shell(arrs.length, arrs);

		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------插入排序---结束--------------------------");
	}

	public void shell(int group, int[] arrs) {
		group = group / 2; // 分成几组
		// 遍历数组
		for (int i = 0; i < group; i++) {
			for (int j = i; j < arrs.length; j = j + group) {
				int a = arrs[j];
				for (int j2 = j - group; j2 >= 0 && a < arrs[j2]; j2 = j2 - group) {
					arrs[j2 + group] = arrs[j2];
					arrs[j2] = a;
				}
			}
		}
		if (group != 1) {
			shell(group, arrs);
		}

	}

	/**
	 * shellSortTest1:(分析规律)
	 * 
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest1() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		System.out.print("原始数组：");
		System.out.println(Arrays.toString(arrs));

		// 第一轮
		int count = 5;// 分成count组 count=5
		int length = 2; // 每组长度length length = 2
		System.out.printf("count = %d,length = %d \n", count, length);
		for (int i = 0; i < 5; i++) {
			// 对arrs1 进行插入排序
			int currentValue = 0;
			int index = 0;
			// 第一组
			int j = 0;
			while (j < arrs.length - 5) {
				currentValue = arrs[j + 5];
				index = j;
				while (index >= 0 && currentValue < arrs[index]) {
					arrs[index + 5] = arrs[index];
					index -= 5;
				}
				arrs[index + 5] = currentValue;
				j++;
				System.out.println(Arrays.toString(arrs));
			}
			System.out.print("第一轮第 " + (i + 1) + "组排序后：");
			System.out.println(Arrays.toString(arrs));
		}

		// 第二轮
		count = 2;// 分成count组 count=5
		length = 5; // 每组长度length length = 2
		System.out.printf("count = %d,length = %d \n", count, length);
		for (int i = 0; i < 2; i++) {
			// 对arrs1 进行插入排序
			int currentValue = 0;
			int index = 0;
			// 第一组
			int j = 0;
			while (j < arrs.length - 2) {
				currentValue = arrs[j + 2];
				index = j;
				while (index >= 0 && currentValue < arrs[index]) {
					arrs[index + 2] = arrs[index];
					index -= 2;
				}
				arrs[index + 2] = currentValue;
				j++;
				System.out.println(Arrays.toString(arrs));
			}
			System.out.print("第二轮第 " + (i + 1) + "组排序后：");
			System.out.println(Arrays.toString(arrs));
		}

		// 第三轮
		count = 1;// 分成count组 count=5
		length = 10; // 每组长度length length = 2
		System.out.printf("count = %d,length = %d \n", count, length);
		for (int i = 0; i < 1; i++) {
			// 对arrs1 进行插入排序
			int currentValue = 0;
			int index = 0;
			// 第一组
			int j = 0;
			while (j < arrs.length - 1) {
				currentValue = arrs[j + 1];
				index = j;
				while (index >= 0 && currentValue < arrs[index]) {
					arrs[index + 1] = arrs[index];
					index -= 1;
				}
				arrs[index + 1] = currentValue;
				j++;
				System.out.println(Arrays.toString(arrs));
			}
			//System.out.print("第二轮第 " + (i + 1) + "组排序后：");
			//System.out.println(Arrays.toString(arrs));
		}
		System.out.println(Arrays.toString(arrs));
	}

	/**
	 * shellSortTest2:(整合规律-使用插入排序，8万个数据，大概7-8秒)
	 * 
	 * 问题：代码复杂，运行时间长，
	 * 
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest2() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		arrs = SortUtils.createArray(80000);
//		System.out.print("原始数组：");
//		System.out.println(Arrays.toString(arrs));

		// 第一轮
		int length = arrs.length;// 分成count组 count=5
		int currentValue = 0;
		int index = 0;
		while (length != 1) {
			length = length / 2;
			for (int i = 0; i < length; i++) {
				int j = 0;
				while (j < arrs.length - length) {
					currentValue = arrs[j + length];
					index = j;
					while (index >= 0 && currentValue < arrs[index]) {
						arrs[index + length] = arrs[index];
						index -= length;
					}
					arrs[index + length] = currentValue;
					j++;
//					System.out.println(Arrays.toString(arrs));
				}
//				System.out.print("第一轮第 " + (i + 1) + "组排序后：");
//				System.out.println(Arrays.toString(arrs));
			}
		}
//		System.out.println(Arrays.toString(arrs));
		
	}
	
	
	/**
	 * shellSortTest3:(希尔排序-优化插入排序，8万个数据，大约不到一秒)
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest3() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		arrs = SortUtils.createArray(80000);
//		System.out.print("原始数组：");
//		System.out.println(Arrays.toString(arrs));

		// 第一轮
		int length = arrs.length;// length = 5
		int currentValue = 0;
		int index = 0;
		while ((length /= 2) != 0) {
			for (int i = length; i < arrs.length; i++) {
				currentValue = arrs[i];//arrs[5] = 3
				index = i - length; //0
				while(index >= 0 && currentValue < arrs[index]) {
					arrs[index + length] = arrs[index];
					index -= length;
				}
				arrs[index + length] = currentValue;
			}
		}
		System.out.println(Arrays.toString(arrs));
		
	}

	
	/**
	 * shellSortTest3:(希尔排序-内部使用选择排序)
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest4() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		arrs = SortUtils.createArray(80000);
//		System.out.print("原始数组：");
//		System.out.println(Arrays.toString(arrs));

		// 第一轮
		int length = arrs.length;// length = 5
		int currentValue = 0;
		int index = 0;
		while ((length = length / 2) != 0) {
			for (int i = length; i < arrs.length; i++) {
				currentValue = arrs[i];//arrs[5] = 3
				index = i - length; //0
				while(index >= 0 && currentValue < arrs[index]) {
					arrs[index + length] = arrs[index];
					index -= length;
				}
				arrs[index + length] = currentValue;
			}
		}
		System.out.println(Arrays.toString(arrs));
		
	}

	
	
	/**
	 * shellSortTest3:(测试希尔排序的效率，8万个数据大约0.05秒)
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		int length = arrs.length;// length = 5
		int currentValue = 0;
		int index = 0;
		while ((length = length / 2) != 0) {
			for (int i = length; i < arrs.length; i++) {
				currentValue = arrs[i];//arrs[5] = 3
				index = i - length; //0
				while(index >= 0 && currentValue < arrs[index]) {
					arrs[index + length] = arrs[index];
					index -= length;
				}
				arrs[index + length] = currentValue;
			}
		}
	}


}
