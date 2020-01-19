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
			for (int j = i-1; j >= 0 && a < arrs[j]; j--) {
				count++;
				arrs[j+1] = arrs[j];
				arrs[j] = a;
			}
		}
		System.out.println("计算次数：" + count + "次");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------插入排序---结束--------------------------");
	}
}
