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
		int[] arrs = SortUtils.createArray(20);
		System.out.println("��ͨð������");
		System.out.println("------------------------ð������---��ʼ--------------------------");
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
		System.out.println("���������" + count);
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------ð������---����--------------------------");
	}
	
	
	
	@Test
	public void test2() {
		//����һ������
		int[] arrs = SortUtils.createArray(50);
		System.out.println("��ͨð������");
		System.out.println("------------------------ð������---��ʼ--------------------------");
		
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
		System.out.println("------------------------ð������---����--------------------------");
		
	}
	
	

	@Test
	public void test3() {
		int[] arrs = SortUtils.createArray(20);
		arrs = new int[] {-2,-10,0,9,11,23,18,38,49,60,9};
		System.out.println(Arrays.toString(arrs));
		System.out.println("��ͨð������");
		System.out.println("------------------------ð������---��ʼ--------------------------");
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
				//���ѭ��֮��û��һ����ֵ�滻����ôֱ���ж�ð��
				break;
			}
		}
		System.out.println("���������" + count);
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------ð������---����--------------------------");
	}

	
	/**
	 * bubbleSortEfficiencyTest:(����ð��������ٶȣ�8������ݣ���Լ11��)
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
