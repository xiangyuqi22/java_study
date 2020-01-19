package com.study.algorithm.sort.insertion;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * ��������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��6��
 * @author xiangning
 * @since JDK1.8
 */
public class InsertionSort {
	
	
	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("------------------------��������---��ʼ--------------------------");
		int count = 0;
		for (int i = 1; i < arrs.length; i++) {
			int a = arrs[i];
			for (int j = i-1; j >= 0 && a < arrs[j]; j--) {
				count++;
				arrs[j+1] = arrs[j];
				arrs[j] = a;
			}
		}
		System.out.println("���������" + count + "��");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------��������---����--------------------------");
	}
}
