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
				for(int j2 = j-group ; j2 >= 0 && a < arrs[j2];j2 = j2 - group) {
					arrs[j2+group] = arrs[j2];
					arrs[j2] = a;
				}
			}
		}
		if (group != 1) {
			shell(group, arrs);
		}

	}

}
