package com.study.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��5��
 * @author xiangning
 * @since JDK1.8
 */
public class SortUtils {
	
	/**
	 * createArray:(����ָ�����ȵ�����)
	 * @author xiangning
	 *
	 * @param length
	 * @return
	 */
	public static int[] createArray(int length) {
//		length = 10000;
		int[] arrs = new int[length];
		int max = length * 5;
		Random rand = new Random();
		for (int i = 0; i < arrs.length; i++) {
			arrs[i] = rand.nextInt(max);
		}
//		System.out.println(Arrays.toString(arrs));
		
//		arrs = new int[] {428, 239, 46, 339, 354, 388, 249, 167, 214, 388, 62, 333, 69, 276, 429, 61, 30, 113, 375, 40, 100, 382, 96, 76, 386, 163, 232, 128, 76, 433, 316, 471, 118, 462, 96, 123, 216, 283, 214, 132, 237, 405, 14, 178, 352, 497, 481, 441, 254, 468, 461, 345, 287, 68, 295, 51, 292, 433, 44, 156, 382, 456, 490, 4, 440, 334, 178, 149, 291, 52, 132, 110, 402, 347, 291, 15, 310, 387, 171, 32, 108, 330, 429, 186, 483, 435, 124, 166, 349, 136, 435, 445, 369, 329, 24, 221, 363, 282, 293, 99};
		
		
		
		return arrs;
	}
	
	
	
	

}
