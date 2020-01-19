package com.study.algorithm.sort.selection;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * 选择排序
 * 核心思路：遍历所有数据，每次遍历后将最大或最小值放在首位，再遍历后面的数据
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月5日
 * @author xiangning
 * @since JDK1.8
 */
public class SelectionSort {
	
	
	/**
	 * test1:(选择排序)
	 * @author xiangning
	 *
	 */
	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("------------------------选择排序---开始--------------------------");
		int count = 0;
		for (int i = 0; i < arrs.length; i++) {
			int index = i;
			for (int j = i; j < arrs.length; j++) {
				if(arrs[j] < arrs[index]) {
					count++;
					index = j;
				}
			}
			int b = arrs[index];
			arrs[index] = arrs[i];
			arrs[i] = b;
		}
		System.out.println("计算次数：" + count + "次");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------选择排序---结束--------------------------");
	}

	
	

}
