package com.study.algorithm.other;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

/**
 * <PRE>
 * �������10000�����ظ������� 
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��2��
 * @author xiangning
 * @since JDK1.8
 */
public class BuildTest01 {
	
	private int length = 50;
	
	/**
	 * test1:(���������10000�����ظ������� )
	 * @author xiangning
	 *
	 */
	@Test
	public void test1() {
		
		Set<Integer> set = new HashSet<>(length);
		
		Random rand = new Random();
		int count = 0;
		do {
			set.add(rand.nextInt(length));
			count++;
		}while(set.size() != length);
		
		System.out.println("ѭ��������" + count);
		System.out.println(set.toString());
		
	}

}
