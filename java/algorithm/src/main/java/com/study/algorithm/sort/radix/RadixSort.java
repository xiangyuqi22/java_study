package com.study.algorithm.sort.radix;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * ����������Ͱ���� ->���������������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��12��
 * @author xiangning
 * @since JDK1.8
 */
public class RadixSort {
	
	@Test
	public void radixSortTest() {
		int[] arrs = new int[] {53, 3, 542, 748, 14, 214};
		System.out.println("ԭʼ���� = " + Arrays.toString(arrs));
		int k = 10;//10��Ͱ
		//����10��Ͱ����װ����
		int[][] bucket = new int[k][arrs.length];
		//����һ����������¼ÿ��Ͱ������
		int[] bucketLengthCounts = new int[bucket.length];
		
		//�������飬��ȡÿ������ĸ�λ��Ȼ��ŵ���Ӧ��Ͱ��
		int temp;
		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i]%10;
			bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
		}
		//Ȼ��Ӹ���Ͱ�а�˳��ȡ�����ݷŻ�ԭ����
		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucketLengthCounts[i]; j++) {
				arrs[index++] = bucket[i][j];
			}
			bucketLengthCounts[i] = 0;
		}
		System.out.println("��һ�����������飺" + Arrays.toString(arrs));
		
		
		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i] / 10 % 10 ;
			bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
		}
		//Ȼ��Ӹ���Ͱ�а�˳��ȡ�����ݷŻ�ԭ����
		index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucketLengthCounts[i]; j++) {
				arrs[index++] = bucket[i][j];
			}
			bucketLengthCounts[i] = 0;
		}
		System.out.println("�ڶ������������飺" + Arrays.toString(arrs));
		
		
		

		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i] / 100 % 10 ;
			bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
		}
		//Ȼ��Ӹ���Ͱ�а�˳��ȡ�����ݷŻ�ԭ����
		index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucketLengthCounts[i]; j++) {
				arrs[index++] = bucket[i][j];
			}
			bucketLengthCounts[i] = 0;
		}
		System.out.println("���������������飺" + Arrays.toString(arrs));
		
	}
	
	@Test
	public void radixSortTest2() {
		int[] arrs = SortUtils.createArray(80000);
		arrs = new int[] {53, 3, 542, 748, 14, 214};
		radixSort(arrs);
	}
	
	private void radixSort(int[] arrs) {
		int k = 10;//10��Ͱ
		//����10��Ͱ����װ����
		int[][] bucket = new int[k][arrs.length];
		//����һ����������¼ÿ��Ͱ������
		int[] bucketLengthCounts = new int[bucket.length];
		
		//�������飬��ȡÿ������ĸ�λ��Ȼ��ŵ���Ӧ��Ͱ��
		int temp;
		int index;
		int max = 0;
		for (int i = 0; i < arrs.length; i++) {
			max = max > arrs[i] ? max : arrs[i];
		}
		int maxLength = (max + "").length();
		for (int l = 0,n=1; l < maxLength; l++,n=n*10) {
			for (int i = 0; i < arrs.length; i++) {
				temp = arrs[i]/n % 10   ;
				bucket[temp][bucketLengthCounts[temp]++] = arrs[i];
			}
			//Ȼ��Ӹ���Ͱ�а�˳��ȡ�����ݷŻ�ԭ����
			index = 0;
			for (int i = 0; i < bucket.length; i++) {
				for (int j = 0; j < bucketLengthCounts[i]; j++) {
					arrs[index++] = bucket[i][j];
				}
				bucketLengthCounts[i] = 0;
			}
//			System.out.println("��" + l + "�����������飺" + Arrays.toString(arrs));
		}
	}
	
	
	@Test
	public void radixSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		radixSort(arrs);
	}
	
	/**��
	 * mergeSortEfficiency8000000Test:(������һ�仰�����������������)
	 * @author xiangning
	 *
	 */
	@Test
	public void radixSortEfficiency8000000Test() {
		int[] arrs = SortUtils.createArray(8000000);
		radixSort(arrs);
	}
	
}
