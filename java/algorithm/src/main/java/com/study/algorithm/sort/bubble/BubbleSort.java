package com.study.algorithm.sort.bubble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * 冒泡排序
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月2日
 * @author xiangning
 * @since JDK1.8
 */
public class BubbleSort{
	
	
	
	
	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(20);
		System.out.println("普通冒泡排序");
		System.out.println("------------------------冒泡排序---开始--------------------------");
		int count = 0;
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i; j < arrs.length; j++) {
				count++;
				if(arrs[i] > arrs[j]) {
					int c = arrs[i];
					arrs[i] = arrs[j];
					arrs[j] = c;
				}
			}
		}
		System.out.println("计算次数：" + count);
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------冒泡排序---结束--------------------------");
	}
	
	
	
	@Test
	public void test2() {
		//创建一个数组
		int[] arrs = SortUtils.createArray(50);
		System.out.println("普通冒泡排序");
		System.out.println("------------------------冒泡排序---开始--------------------------");
		
		int temp = 0;
		for (int i = 0; i < arrs.length; i++) {
			int m = arrs[i];
			for (int j = i; j < arrs.length; j++) {
				if(arrs[j] < m ) {
					arrs[i] = arrs[j];
					arrs[j] = m;
					m = arrs[i];
				}
			}
		}
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------冒泡排序---结束--------------------------");
		
	}
	
	

	@Test
	public void test3() {
		int[] arrs = SortUtils.createArray(20);
		arrs = new int[] {-2,-10,0,9,11,23,18,38,49,60,9};
		System.out.println(Arrays.toString(arrs));
		System.out.println("普通冒泡排序");
		System.out.println("------------------------冒泡排序---开始--------------------------");
		int count = 0;
		boolean flag = true;//
		for (int i = 1; i < arrs.length - 1; i++) {
			flag = true;
			for (int j = 0; j < arrs.length - i; j++) {
				count++;
				if(arrs[j] > arrs[j+1]) {
					int c = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = c;
					flag = false;
				}
			}
			if(flag) {
				//如果循环之后，没有一次数值替换，那么直接中断冒泡
				break;
			}
		}
		System.out.println("计算次数：" + count);
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------冒泡排序---结束--------------------------");
	}

	
	/**
	 * bubbleSortEfficiencyTest:(测试冒泡排序的速度，8万个数据，大约11秒)
	 * @author xiangning
	 *
	 */
	@Test
	public void bubbleSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		int count = 0;
		boolean flag = true;//
		for (int i = 1; i < arrs.length - 1; i++) {
			flag = true;
			for (int j = 0; j < arrs.length - i; j++) {
				count++;
				if(arrs[j] > arrs[j+1]) {
					int c = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = c;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	


}
