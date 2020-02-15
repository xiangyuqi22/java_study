package com.study.algorithm.search;

import java.util.Arrays;

import org.junit.Test;

/**
 * <PRE>
 * ����������쳲����� �����㷨
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��13��
 * @author xiangning
 * @since JDK1.8
 */
public class FibonacciSearch {
	
	int count;

	@Test
	public void fibonacciSearchTest() {
//		int[] arrs = new int[] {122, 122, 124, 124, 126, 128};
		int[] arrs = new int[] {2, 4, 6, 7, 9, 14, 14, 23, 31, 37, 41, 46, 52, 53, 67, 74, 78, 78, 80, 84, 88, 95, 117, 122, 122, 124, 124, 126, 128};
		int key = 68;
		int resultIndex = fibonacciSearch1(arrs,key);
		System.out.println("resultIndex = " + resultIndex);
		System.out.println("�������򣬲�ѯ���� = " + count);
	}

	
	
	private int fibonacciSearch1(int[] arrs, int key) {
		//1������һ��쳲��������У������߼��磺{1,1,2,3,5,8,13,21,34}
		int[] fibArrs = new int[20];
		fibArrs[0] = 1;
		fibArrs[1] = 1;
		for (int i = 2; i < fibArrs.length; i++) {
			fibArrs[i] = fibArrs[i-1] + fibArrs[i-2];
		}
		System.out.println("��ȡ����쳲���������  = " + Arrays.toString(fibArrs));
		
		int low = 0;
		int high = arrs.length - 1;
		int mid = 0;
		int k = 0;
		while(arrs.length >= fibArrs[k]) {
			k++;
		}
		System.out.println("���鳤�� = " + fibArrs[k]);
		
		//����һ���ʺ�쳲��������ȵ�����
		int[] tempArrs = Arrays.copyOf(arrs, fibArrs[k]);
		
		//�����������������������ԭʼ���ݵ����һ�����ݽ������
		for (int i = arrs.length; i < tempArrs.length; i++) {
			tempArrs[i] = arrs[high];
		}
		
		System.out.println("�Ż������ʱ���� = " + Arrays.toString(tempArrs));
		
		//ѭ��������
		int temp;
		while(low <= high) {
			System.out.println("��ѯ���� = "+ ++count);
			mid = low + fibArrs[k - 1] - 1; //
			temp = tempArrs[mid];
			if(temp > key) {
				//�����ǰֵ��Ŀ��ֵҪ������Ҫ����Ѱ�ң���߼�Ϊ쳲����������ǰһ����������
				high = mid -1;
				k--;
			}else if(temp < key) {
				//�����ǰֵ��Ŀ��ֵҪС������Ҫ����Ѱ�ң�
				low = mid + 1;
				k -= 2;
			}else {
				if(mid > arrs.length-1) {
					return arrs.length-1;
				}else {
					return mid;
				}
			}
		}
		return -1;
	}

}
