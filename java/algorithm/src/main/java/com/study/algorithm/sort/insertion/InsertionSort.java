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
			for (int j = i - 1; j >= 0 && a < arrs[j]; j--) {
				count++;
				arrs[j + 1] = arrs[j];
				arrs[j] = a;
			}
		}
		System.out.println("���������" + count + "��");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------��������---����--------------------------");
	}

	/**
	 * insertionSortTest1:(ѡ������Ļ���˼·)
	 * 
	 * ��nǰ�����������������б� n�������Ϊ�����б� �������б�����ĵ�һ�������β��뵽�����б���
	 * 
	 * 
	 * @author xiangning
	 *
	 */
	@Test
	public void insertionSortTest1() {
		int[] arrs = new int[] { -2, -10, 0, 9, 11, 23, 18, 38, 49, 60, 9 };
		arrs = new int[] { 101, 34, 119, 1 };
		System.out.println(Arrays.toString(arrs));
		int count = 0;
		// ��С��������
		// ��һ��
		int indexVal = arrs[1];// �ӵڶ�������ʼ����Ϊ��һ�����ݲ���Ҫ�ȣ�Ĭ�Ͼ�������
		int index = 1 - 1;// �ӵ�һ������ʼ���бȽ�
		while (index >= 0 && indexVal < arrs[index]) {
			arrs[index + 1] = arrs[index];
			index--;
		}
		// ��ʱ��ȡ��index��ֵ�ȵ�ǰindexValС
		arrs[index + 1] = indexVal;
		System.out.println("��һ�ֹ���");
		System.out.println(Arrays.toString(arrs));

		// �ڶ���
		indexVal = arrs[2];// �ӵڶ�������ʼ����Ϊ��һ�����ݲ���Ҫ�ȣ�Ĭ�Ͼ�������
		index = 2 - 1;// �ӵ�һ������ʼ���бȽ�
		while (index >= 0 && indexVal < arrs[index]) {
			arrs[index + 1] = arrs[index];
			index--;
		}
		// ��ʱ��ȡ��index��ֵ�ȵ�ǰindexValС
		arrs[index + 1] = indexVal;
		System.out.println("�ڶ��ֹ���");
		System.out.println(Arrays.toString(arrs));

		// ������
		indexVal = arrs[3];// �ӵڶ�������ʼ����Ϊ��һ�����ݲ���Ҫ�ȣ�Ĭ�Ͼ�������
		index = 3 - 1;// �ӵ�һ������ʼ���бȽ�
		while (index >= 0 && indexVal < arrs[index]) {
			arrs[index + 1] = arrs[index];
			index--;
		}
		// ��ʱ��ȡ��index��ֵ�ȵ�ǰindexValС
		arrs[index + 1] = indexVal;
		System.out.println("�����ֹ���");
		System.out.println(Arrays.toString(arrs));
		
		
		System.out.println("���������" + count + "��");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------ѡ������---����--------------------------");
	}
	
	
	@Test
	public void insertionSortTest2() {
		int[] arrs = new int[] { -2, -10, 0, 9, 11, 23, 18, 38, 49, 60, 9 };
		System.out.println(Arrays.toString(arrs));
		int count = 0;
		
		//���
		int indexVal = 0;
		int index = 0;
		for (int i = 1; i < arrs.length; i++) {
			indexVal = arrs[i];// �ӵڶ�������ʼ����Ϊ��һ�����ݲ���Ҫ�ȣ�Ĭ�Ͼ�������
			index = i - 1;// �ӵ�һ������ʼ���бȽ�
			while (index >= 0 && indexVal < arrs[index]) {
				count++;
				arrs[index + 1] = arrs[index];
				index--;
			}
			// ��ʱ��ȡ��index��ֵ�ȵ�ǰindexValС
			arrs[index + 1] = indexVal;
			System.out.println("��" + i + "�ֹ���");
			System.out.println(Arrays.toString(arrs));
		}
		
		System.out.println("���������" + count + "��");
		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------ѡ������---����--------------------------");
	}
	
	
	/**
	 * insertionSortEfficiencyTest:(����8����������õ�ʱ�䣬��ʱԼ3������)
	 * @author xiangning
	 *
	 */
	@Test
	public void insertionSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		int count = 0;
		//���
		int indexVal = 0;
		int index = 0;
		for (int i = 1; i < arrs.length; i++) {
			indexVal = arrs[i];// �ӵڶ�������ʼ����Ϊ��һ�����ݲ���Ҫ�ȣ�Ĭ�Ͼ�������
			index = i - 1;// �ӵ�һ������ʼ���бȽ�
			while (index >= 0 && indexVal < arrs[index]) {
				count++;
				arrs[index + 1] = arrs[index];
				index--;
			}
			arrs[index + 1] = indexVal;
		}
		
	}


}
