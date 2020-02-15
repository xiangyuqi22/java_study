package com.study.algorithm.sort.merge;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * �����������鲢�����㷨
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��12��
 * @author xiangning
 * @since JDK1.8
 */
public class MergeSort {
	
	@Test
	public void mergeSortTest() {
		int[] arrs = new int[] {8,4,5,7,1,3,6,2};
		arrs = new int[] {8,4,5,7,1,3,6,2,32,432,234,234,22,4332543,6534,6,346,3463};
		arrs = new int[] {32,43,5,654,765,24,74,7654,23,8,4,5,7,1,3,6,2,32,432,234,234,22,4332543,6534,6,346,3463};
//		arrs = SortUtils.createArray(8000000);
		mergeSort(arrs, 0, arrs.length-1,new int[arrs.length]);
		System.out.println("���������� = " + Arrays.toString(arrs));
	}
	
	/**
	 * mergeSort:(�鲢���򣺷�)
	 * @author xiangning
	 *
	 * @param arrs	ԭʼ����
	 * @param left	���������
	 * @param right	���ұ�����
	 * @param tempArrs	��ʱ���飬��Ҫռ�ö���ռ�
	 */
	private void mergeSort(int[] arrs,int left,int right,int[] tempArrs) {
		if(left < right) {
			int mid = (right-left)/2 + left;
			//����ݹ�ֽ�
			mergeSort(arrs, left, mid,tempArrs);
			//���ҵݹ�ֽ�
			mergeSort(arrs, mid+1, right,tempArrs);
			//�ϲ�����
			mergeSort(arrs, left, right,mid,tempArrs);
		}
	}
	
	/**
	 * mergeSort:(�鲢���򣺺�)
	 * @author xiangning
	 *
	 * @param arrs	ԭʼ����	
	 * @param left	��������
	 * @param right	���ұ�����
	 * @param mid	�з�
	 * @param tempArrs	��ʱ����
	 */
	private void mergeSort(int[] arrs,int left,int right,int mid,int[] tempArrs) {
		int index = 0;
		int j = mid+1;
		for (int i = left; i <= mid; i++) {
			while(j <= right && arrs[j] < arrs[i]) {
				tempArrs[index++] = arrs[j++];
			}
			tempArrs[index++] = arrs[i];
		}
		
		if(j<=right) {
			for (int i = j; i <=right; i++) {
				tempArrs[index++] = arrs[i];
			}
		}
		
		for (int i = 0; i < index; i++) {
			arrs[left + i] = tempArrs[i];
		}
	}
	
	/**
	 * mergeSortEfficiencyTest:(���Թ鲢����Ч��)
	 * @author xiangning
	 *
	 */
	@Test
	public void mergeSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
//		System.out.println(arrs.length);
		mergeSort(arrs, 0, arrs.length-1,new int[arrs.length]);
//		System.out.println(arrs.length);
	}
	
	/**
	 * mergeSortEfficiency8000000Test:(���Թ鲢����8���������)
	 * @author xiangning
	 *
	 */
	@Test
	public void mergeSortEfficiency8000000Test() {
		int[] arrs = SortUtils.createArray(8000000);
		mergeSort(arrs, 0, arrs.length-1,new int[arrs.length]);
	}
	
	
	
	

}
