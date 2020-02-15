package com.study.algorithm.sort.quick;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * ���������㷨 - ð������������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��2��7��
 * @author xiangning
 * @since JDK1.8
 */
public class QuickSort {

	
	
	@Test
	public void quickSortTest() {
		int[] arrs = new int[] { -9, 78, 99, 23,0, 23,23,23,23 -567, -70, -22, 18,23};
//		 arrs = new int[] {-9,78,0,23,-567,70};
		 arrs = new int[] {-9,78,23,0,23,-567,70,23};
		// arrs = SortUtils.createArray(80000);
//		 arrs = SortUtils.createArray(100);
//		arrs = new int[] {-567, -70};
//		arrs = new int[] {-70, -567};
		int left = 0;
		int right = arrs.length - 1;
		System.out.println("ԭʼ���� = " + Arrays.toString(arrs));
		quickSort(arrs, left, right);
//		quickSort(left,right,arrs);
	}

	private void quickSort(int[] arrs, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arrs[(left+right)/2];
		System.out.println("��׼�� = " + pivot);
		int temp;
		while(l < r) {
			//����߿�ʼ�ҵ����ڻ���ڻ�׼ֵ����
			while(arrs[l] < pivot) {
				l++;
			}
			//���ұ߿�ʼ���ҵ�С�ڻ���ڻ�׼ֵ����
			while(arrs[r] > pivot ) {
				r--;
			}
			if(l >= r) {
				//�����ߵ�ָ�볬�����ұߵ�ָ�룬��ʾ�������ݶ��Һ��ˣ����Խ���ѭ��
				break;
			}
			//�ҵ��˿��滻�����ݣ����Խ��н�����
			temp = arrs[l];
			arrs[l] = arrs[r];
			arrs[r] = temp;
			
			//����ո��ұ��ҵ������ݸ���׼ֵ��һ���ģ�Ϊ�˷�ֹ��ѭ������ô�ұߵ�ָ����Ҫ�����ƶ�һ��
			if(arrs[r] == pivot) {
				//�������ݽ���ʱ���Ѿ����ұߵ������滻�������
				l++;
			}
			if(arrs[l] == pivot) {
				r--;
			}
		}
		
		if(l == r) {
			l++;
			r--;
		}
		if( r > left) {
			quickSort(arrs, left, r);
		}
		if(l < right) {
			quickSort(arrs, l, right);
		}
		System.out.println("���������� = " + Arrays.toString(arrs));
	}
	
	
	/**
	 * quickSortEfficiencyTest:(��������Ч�ʲ���)
	 * @author xiangning
	 *
	 */
	@Test
	public void quickSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		quickSort1(arrs, 0, arrs.length-1);
	}
	
	/**
	 * quickSortEfficiency8000000Test:(�����������8���������)
	 * @author xiangning
	 *
	 */
	@Test
	public void quickSortEfficiency8000000Test() {
		int[] arrs = SortUtils.createArray(8000000);
		quickSort1(arrs, 0, arrs.length-1);
	}
	
	
	private void quickSort1(int[] arrs, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arrs[(left+right)/2];
		int temp;
		while(l < r) {
			//����߿�ʼ�ҵ����ڻ���ڻ�׼ֵ����
			while(arrs[l] < pivot) {
				l++;
			}
			//���ұ߿�ʼ���ҵ�С�ڻ���ڻ�׼ֵ����
			while(arrs[r] > pivot ) {
				r--;
			}
			if(l >= r) {
				//�����ߵ�ָ�볬�����ұߵ�ָ�룬��ʾ�������ݶ��Һ��ˣ����Խ���ѭ��
				break;
			}
			//�ҵ��˿��滻�����ݣ����Խ��н�����
			temp = arrs[l];
			arrs[l] = arrs[r];
			arrs[r] = temp;
			
			//����ո��ұ��ҵ������ݸ���׼ֵ��һ���ģ�Ϊ�˷�ֹ��ѭ������ô�ұߵ�ָ����Ҫ�����ƶ�һ��
			if(arrs[r] == pivot) {
				//�������ݽ���ʱ���Ѿ����ұߵ������滻�������
				l++;
			}
			if(arrs[l] == pivot) {
				r--;
			}
		}
		
		if(l == r) {
			l++;
			r--;
		}
		if( r > left) {
			quickSort1(arrs, left, r);
		}
		if(l < right) {
			quickSort1(arrs, l, right);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
