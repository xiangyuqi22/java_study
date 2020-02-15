package com.study.algorithm.search;

import org.junit.Test;

/**
 * <PRE>
 * ������������������㷨 --> ���ֲ��ҷ���������
 * �������ݣ�mid=low+(key-a[low])/(a[high]-a[low])*(high-low)
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��13��
 * @author xiangning
 * @since JDK1.8
 */
public class InsertSearch {
	
	int count;

	@Test
	public void insertSearchTest() {
		int[] arrs = new int[] {2, 4, 6, 7, 9, 14, 14, 23, 31, 37, 41, 46, 52, 53, 67, 74, 78, 78, 80, 84, 88, 95, 117, 122, 122, 124, 124, 126, 128};
		int data = 2;
		int resultIndex = insertSearch(arrs,data,0,arrs.length-1);
		System.out.println("resultIndex = " + resultIndex);
		System.out.println("�������򣬲�ѯ���� = " + count);
	}

	private int insertSearch(int[] arrs, int data,int left,int right) {
		count++;
		int index = -1;
		if(left < right) {
			int mid = left + (data - arrs[left])/(arrs[right] - arrs[left])*(right - left);
			if(arrs[mid] > data) {
				//����ҵ���ֵ���ڲ��ҵ������������������
				return insertSearch(arrs, data, left, mid-1);
			}else if (arrs[mid] < data) {
				//����ҵ���ֵҪС��Ŀ��ֵ������Ҫ���Ҳ���
				return insertSearch(arrs, data, mid+1, right);
			}else {
				index = mid;
			}
		}
		return index;
	}
	
	

}
