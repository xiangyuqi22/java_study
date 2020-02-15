package com.study.algorithm.sort.shell;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * ѧϰ��ַ<a href=
"https://www.cnblogs.com/guoyaohua/p/8600214.html"/>https://www.cnblogs.com/guoyaohua/p/8600214.html</a>
 * 
 * ϣ������
 * 
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��6��
 * @author xiangning
 * @since JDK1.8
 */
public class ShellSort {

	@Test
	public void test1() {
		int[] arrs = SortUtils.createArray(10000);
		System.out.println("------------------------��������---��ʼ--------------------------");

		arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		shell(arrs.length, arrs);

		System.out.println(Arrays.toString(arrs));
		System.out.println("------------------------��������---����--------------------------");
	}

	public void shell(int group, int[] arrs) {
		group = group / 2; // �ֳɼ���
		// ��������
		for (int i = 0; i < group; i++) {
			for (int j = i; j < arrs.length; j = j + group) {
				int a = arrs[j];
				for (int j2 = j - group; j2 >= 0 && a < arrs[j2]; j2 = j2 - group) {
					arrs[j2 + group] = arrs[j2];
					arrs[j2] = a;
				}
			}
		}
		if (group != 1) {
			shell(group, arrs);
		}

	}

	/**
	 * shellSortTest1:(��������)
	 * 
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest1() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		System.out.print("ԭʼ���飺");
		System.out.println(Arrays.toString(arrs));

		// ��һ��
		int count = 5;// �ֳ�count�� count=5
		int length = 2; // ÿ�鳤��length length = 2
		System.out.printf("count = %d,length = %d \n", count, length);
		for (int i = 0; i < 5; i++) {
			// ��arrs1 ���в�������
			int currentValue = 0;
			int index = 0;
			// ��һ��
			int j = 0;
			while (j < arrs.length - 5) {
				currentValue = arrs[j + 5];
				index = j;
				while (index >= 0 && currentValue < arrs[index]) {
					arrs[index + 5] = arrs[index];
					index -= 5;
				}
				arrs[index + 5] = currentValue;
				j++;
				System.out.println(Arrays.toString(arrs));
			}
			System.out.print("��һ�ֵ� " + (i + 1) + "�������");
			System.out.println(Arrays.toString(arrs));
		}

		// �ڶ���
		count = 2;// �ֳ�count�� count=5
		length = 5; // ÿ�鳤��length length = 2
		System.out.printf("count = %d,length = %d \n", count, length);
		for (int i = 0; i < 2; i++) {
			// ��arrs1 ���в�������
			int currentValue = 0;
			int index = 0;
			// ��һ��
			int j = 0;
			while (j < arrs.length - 2) {
				currentValue = arrs[j + 2];
				index = j;
				while (index >= 0 && currentValue < arrs[index]) {
					arrs[index + 2] = arrs[index];
					index -= 2;
				}
				arrs[index + 2] = currentValue;
				j++;
				System.out.println(Arrays.toString(arrs));
			}
			System.out.print("�ڶ��ֵ� " + (i + 1) + "�������");
			System.out.println(Arrays.toString(arrs));
		}

		// ������
		count = 1;// �ֳ�count�� count=5
		length = 10; // ÿ�鳤��length length = 2
		System.out.printf("count = %d,length = %d \n", count, length);
		for (int i = 0; i < 1; i++) {
			// ��arrs1 ���в�������
			int currentValue = 0;
			int index = 0;
			// ��һ��
			int j = 0;
			while (j < arrs.length - 1) {
				currentValue = arrs[j + 1];
				index = j;
				while (index >= 0 && currentValue < arrs[index]) {
					arrs[index + 1] = arrs[index];
					index -= 1;
				}
				arrs[index + 1] = currentValue;
				j++;
				System.out.println(Arrays.toString(arrs));
			}
			//System.out.print("�ڶ��ֵ� " + (i + 1) + "�������");
			//System.out.println(Arrays.toString(arrs));
		}
		System.out.println(Arrays.toString(arrs));
	}

	/**
	 * shellSortTest2:(���Ϲ���-ʹ�ò�������8������ݣ����7-8��)
	 * 
	 * ���⣺���븴�ӣ�����ʱ�䳤��
	 * 
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest2() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		arrs = SortUtils.createArray(80000);
//		System.out.print("ԭʼ���飺");
//		System.out.println(Arrays.toString(arrs));

		// ��һ��
		int length = arrs.length;// �ֳ�count�� count=5
		int currentValue = 0;
		int index = 0;
		while (length != 1) {
			length = length / 2;
			for (int i = 0; i < length; i++) {
				int j = 0;
				while (j < arrs.length - length) {
					currentValue = arrs[j + length];
					index = j;
					while (index >= 0 && currentValue < arrs[index]) {
						arrs[index + length] = arrs[index];
						index -= length;
					}
					arrs[index + length] = currentValue;
					j++;
//					System.out.println(Arrays.toString(arrs));
				}
//				System.out.print("��һ�ֵ� " + (i + 1) + "�������");
//				System.out.println(Arrays.toString(arrs));
			}
		}
//		System.out.println(Arrays.toString(arrs));
		
	}
	
	
	/**
	 * shellSortTest3:(ϣ������-�Ż���������8������ݣ���Լ����һ��)
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest3() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		arrs = SortUtils.createArray(80000);
//		System.out.print("ԭʼ���飺");
//		System.out.println(Arrays.toString(arrs));

		// ��һ��
		int length = arrs.length;// length = 5
		int currentValue = 0;
		int index = 0;
		while ((length /= 2) != 0) {
			for (int i = length; i < arrs.length; i++) {
				currentValue = arrs[i];//arrs[5] = 3
				index = i - length; //0
				while(index >= 0 && currentValue < arrs[index]) {
					arrs[index + length] = arrs[index];
					index -= length;
				}
				arrs[index + length] = currentValue;
			}
		}
		System.out.println(Arrays.toString(arrs));
		
	}

	
	/**
	 * shellSortTest3:(ϣ������-�ڲ�ʹ��ѡ������)
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortTest4() {
		int[] arrs = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		arrs = SortUtils.createArray(80000);
//		System.out.print("ԭʼ���飺");
//		System.out.println(Arrays.toString(arrs));

		// ��һ��
		int length = arrs.length;// length = 5
		int currentValue = 0;
		int index = 0;
		while ((length = length / 2) != 0) {
			for (int i = length; i < arrs.length; i++) {
				currentValue = arrs[i];//arrs[5] = 3
				index = i - length; //0
				while(index >= 0 && currentValue < arrs[index]) {
					arrs[index + length] = arrs[index];
					index -= length;
				}
				arrs[index + length] = currentValue;
			}
		}
		System.out.println(Arrays.toString(arrs));
		
	}

	
	
	/**
	 * shellSortTest3:(����ϣ�������Ч�ʣ�8������ݴ�Լ0.05��)
	 * @author xiangning
	 *
	 */
	@Test
	public void shellSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		int length = arrs.length;// length = 5
		int currentValue = 0;
		int index = 0;
		while ((length = length / 2) != 0) {
			for (int i = length; i < arrs.length; i++) {
				currentValue = arrs[i];//arrs[5] = 3
				index = i - length; //0
				while(index >= 0 && currentValue < arrs[index]) {
					arrs[index + length] = arrs[index];
					index -= length;
				}
				arrs[index + length] = currentValue;
			}
		}
	}


}
