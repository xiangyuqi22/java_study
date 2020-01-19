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
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("普通冒泡排序");
		System.out.println("------------------------冒泡排序---开始--------------------------");
		int count = 0;
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i; j < arrs.length; j++) {
				if(arrs[i] > arrs[j]) {
					count++;
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


}
