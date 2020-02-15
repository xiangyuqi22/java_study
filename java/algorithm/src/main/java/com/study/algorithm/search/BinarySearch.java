package com.study.algorithm.search;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * <PRE>
 * �������������ֲ��ҷ�
 * 	Ҫ���б�����������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��12��
 * @author xiangning
 * @since JDK1.8
 */
public class BinarySearch {
	
	int count;
	
	
	@Test
	public void binarySearchTest() {
		int[] arrs = new int[] {2, 4, 6, 7, 9, 14, 14, 23, 31, 37, 41, 46, 52, 53, 67, 74, 78, 78, 80, 84, 88, 95, 117, 122, 122, 124, 124, 126, 128};
//		arrs = new int[] {1,2,3,4,5,6,7,8,9,10,11};
		int data = 88;
		int resultIndex = binarySearch1(arrs,data,0,arrs.length-1);
		System.out.println("resultIndex = " + resultIndex);
		System.out.println("���ֲ��ң���ѯ���� = " + count);
	}

	private int binarySearch1(int[] arrs, int data,int left,int right) {
		count++;
		int index = -1;
		if(left < right) {
			int mid = (right + 1 + left)/2;
			if(arrs[mid] > data) {
				//����ҵ���ֵ���ڲ��ҵ������������������
				return binarySearch1(arrs, data, left, mid-1);
			}else if (arrs[mid] < data) {
				//����ҵ���ֵҪС��Ŀ��ֵ������Ҫ���Ҳ���
				return binarySearch1(arrs, data, mid+1, right);
			}else {
				index = mid;
			}
		}
		return index;
	}
	
	
	@Test
	public void binarySearchTest2() {
		int[] arrs = new int[] {2, 4, 6, 7, 9, 14, 14, 23, 31, 37, 41,41,41,41,41,41,41, 46, 52, 53, 67, 74, 78, 78, 80, 84, 88, 95, 117, 122, 122, 124, 124, 126, 128};
//		arrs = new int[] {1,2,3,4,5,6,7,8,9,10,11};
		int data = 78;
		List<Integer> binarySearch2 = binarySearch2(arrs,data,0,arrs.length-1);
		System.out.println("binarySearch2 = " + binarySearch2);
	}

	
	
	private List<Integer> binarySearch2(int[] arrs, int data,int left,int right) {
		if(left < right) {
			int mid = (right + 1 + left)/2;
			if(arrs[mid] > data) {
				//����ҵ���ֵ���ڲ��ҵ������������������
				return binarySearch2(arrs, data, left, mid-1);
			}else if (arrs[mid] < data) {
				//����ҵ���ֵҪС��Ŀ��ֵ������Ҫ���Ҳ���
				return binarySearch2(arrs, data, mid+1, right);
			}else {
				ArrayList<Integer> resIndexList = new ArrayList<Integer>();
				int res = mid;
				while(res>=0 && arrs[res] == data) {
					resIndexList.add(res--);
				}
				res = ++mid;
				while(res<arrs.length && arrs[res] == data) {
					resIndexList.add(res++);
				}
				return resIndexList;
			}
		}
		return new ArrayList<Integer>();
	}
	
	
	
	@Test
	public void binarySearchTest3() {
		int[] arrs = new int[] {2, 4, 6, 7, 9, 14, 14, 23, 31, 37, 41,41,41,41,41,41,41, 46, 52, 53, 67, 74, 78, 78, 80, 84, 88, 95, 117, 122, 122, 124, 124, 126, 128};
		int data = 78;
		int resIndex = binarySearch3(arrs,data);
		System.out.println("resIndex = " + resIndex);
	}
	
	public int binarySearch3(int[] arrs,int key) {
		int count = 0;
		int left = 0;
		int right = arrs.length -1;
		int mid = -1;
		while(left <= right) {
			System.out.println("��ѯ���� = " + ++count);
			mid = (right + left)/2;
			if(arrs[mid] > key) {
				right = mid - 1;
			}else if(arrs[mid] < key) {
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	

}
