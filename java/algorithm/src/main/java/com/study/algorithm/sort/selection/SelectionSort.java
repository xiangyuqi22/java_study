package com.study.algorithm.sort.selection;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * ѡ������
 * ����˼·�������������ݣ�ÿ�α�����������Сֵ������λ���ٱ������������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��5��
 * @author xiangning
 * @since JDK1.8
 */
public class SelectionSort {
	
	
	/**
	 * test1:(ѡ������)
	 * @author xiangning
	 *
	 */
	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("------------------------ѡ������---��ʼ--------------------------");
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
		System.out.println("���������" + count + "��");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------ѡ������---����--------------------------");
	}
	
	
	
	
	
	@Test
	public void test2() {
		System.out.println("------------------------ѡ������---��ʼ--------------------------");
		int[] arrs = new int[] {-2,-10,0,9,11,23,18,38,49,60,9};
		System.out.println(Arrays.toString(arrs));
		int index = 0;
		int count = 0;
		for (int i = 0; i < arrs.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < arrs.length ; j++) {
				count++;
				if(arrs[index] > arrs[j]) {
					index  = j;
				}
			}
			if(index != i) {
				int temp = arrs[index];
				arrs[index] = arrs[i];
				arrs[i] = temp;
			}
		}
		System.out.println("���������" + count + "��");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------ѡ������---����--------------------------");
		
	}
	
	
	/**
	 * selectionSortEfficiencyTest:(����ѡ��������ٶȣ�8������ݣ���Լ0.5��)
	 * @author xiangning
	 *
	 */
	@Test
	public void selectionSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		int index = 0;
		int count = 0;
		for (int i = 0; i < arrs.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < arrs.length ; j++) {
				count++;
				if(arrs[index] > arrs[j]) {
					index  = j;
				}
			}
			if(index != i) {
				int temp = arrs[index];
				arrs[index] = arrs[i];
				arrs[i] = temp;
			}
		}
	}
	
	
	
	

	
	

}
