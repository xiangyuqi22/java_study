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
				for(int j2 = j-group ; j2 >= 0 && a < arrs[j2];j2 = j2 - group) {
					arrs[j2+group] = arrs[j2];
					arrs[j2] = a;
				}
			}
		}
		if (group != 1) {
			shell(group, arrs);
		}

	}

}
