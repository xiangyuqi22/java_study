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
 * ð������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��2��
 * @author xiangning
 * @since JDK1.8
 */
public class BubbleSort{
	
	
	
	
	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("��ͨð������");
		System.out.println("------------------------ð������---��ʼ--------------------------");
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
		System.out.println("���������" + count);
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------ð������---����--------------------------");
	}


}
