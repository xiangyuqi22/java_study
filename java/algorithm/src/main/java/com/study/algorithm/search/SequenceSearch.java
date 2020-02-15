package com.study.algorithm.search;

import org.junit.Test;

/**
 * <PRE>
 * 功能描述：顺序查找
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月13日
 * @author xiangning
 * @since JDK1.8
 */
public class SequenceSearch {
	
	@Test
	public void sequenceSearchTest() {
		int[] arrs = new int[] {2, 4, 6, 7, 9, 14, 14, 23, 31, 37, 41, 46, 52, 53, 67, 74, 78, 78, 80, 84, 88, 95, 117, 122, 122, 124, 124, 126, 128};
		
		System.out.println("index = " + sequenceSearch1(arrs, 41));
		
	}
	
	public int sequenceSearch1(int[] arrs,int key) {
		for (int i = 0; i < arrs.length; i++) {
			if(arrs[i] == key) {
				return i;
			}
		}
		return -1;
	}

}
