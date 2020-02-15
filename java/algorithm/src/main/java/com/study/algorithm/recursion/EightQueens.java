package com.study.algorithm.recursion;

import java.util.Arrays;

import org.junit.Test;

/**
 * <PRE>
 * �ݹ�-�˻ʺ�����(�����㷨)
	�˻ʺ������㷨˼·����
	
	��һ���ʺ��ȷŵ�һ�е�һ��
	�ڶ����ʺ���ڵڶ��е�һ�С�Ȼ���ж��Ƿ�OK�� �����OK���������ڵڶ��С������С����ΰ������ж����꣬�ҵ�һ������
	�����������ʺ󣬻��ǵ�һ�С��ڶ��С���ֱ����8���ʺ�Ҳ�ܷ���һ������ͻ��λ�ã������ҵ���һ����ȷ��
	���õ�һ����ȷ��ʱ����ջ���˵���һ��ջʱ���ͻῪʼ���ݣ�������һ���ʺ󣬷ŵ���һ�е�������ȷ�⣬ȫ���õ�.
	Ȼ���ͷ������һ���ʺ�ŵڶ��У��������ѭ��ִ�� 1,2,3,4�Ĳ��� ��ʾ��ͼ��
	
	˵����������Ӧ�ô���һ����ά��������ʾ���̣�����ʵ���Ͽ���ͨ���㷨��
	��һ��һά���鼴�ɽ������. arr[8] = {0 , 4, 7, 5, 2, 6, 1, 3} 
	//��Ӧarr �±� ��ʾ�ڼ��У����ڼ����ʺ�arr[i] = val , val ��ʾ��i+1���ʺ󣬷��ڵ�i+1�еĵ�val+1��



 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��2��3��
 * @author xiangning
 * @since JDK1.8
 */
public class EightQueens {
	
	@Test
	public void test1() {
		check(0);
		System.out.printf("һ����%d�ֽⷨ\n",count);
		System.out.printf("һ��������%d���ж�����",maxGudge);
		
		
	}
	
	
	//�����ж��ٸ��ʺ�
	private int max = 8;
	
	//����һ������������ʾ�ʺ�ڷŵ�λ��
	//ʹ��һά�����ʾ���±��ʾ�ڼ��У�ֵ��ʾ�ڼ��� 
	private int[] arrs = new int[max];
	
	//�����ж����ַ��÷�ʽ
	private int count;
	
	//���嵱ǰ�㷨���ж��ٴ��ж�
	private int maxGudge;
	
	
	//��ӡ����
	private void print() {
		count++;
		System.out.println(Arrays.toString(arrs));;
	}
	
	
	/**
	 * gudge:(�жϵ�n���ʺ���ǰ��ʺ����ŵ�λ���Ƿ��г�ͻ)
	 * @author xiangning
	 *
	 * @param n ��n+1���ʺ�n��0��ʼ��0����һ���ʺ�
	 * @return
	 */
	private boolean gudge(int n) {
		
		for (int i = 0; i < n; i++) {
			maxGudge++;
			if(arrs[i] == arrs[n] || Math.abs(n-i) == Math.abs(arrs[n] - arrs[i])) {
				//arrs[i] == arrs[n] �������������ͬһ�У����ʾ�г�ͻ
				// Math.abs(n-i) == Math.abs(arrs[n] - arrs[i]) ����������ζԽ��ߣ����ʾ�г�ͻ
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * check:(��鲢���ûʺ�)
	 * @author xiangning
	 *
	 * @param n ���õ�n���ʺ�
	 */
	private void check(int n) {
		if(n >= max) {
			//���������Ļʺ���ֱ�ӷ���
			print();
			return;
		}
		for (int i = 0; i < max ;i++) {
			arrs[n] = i;//�Ȱѵ�n���ʺ���ڵ�һ��
			if(gudge(n)) {
				//�����n���ʺ��ǰ���û�г�ͻ����ô�ٷ���һ���ʺ�
				check(n+1);
			}
		}
	}
	
	

}
