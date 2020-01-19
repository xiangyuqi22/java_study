package com.study.algorithm.other;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

/**
 * <PRE>
 * 随机生成10000个不重复的数字 
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月2日
 * @author xiangning
 * @since JDK1.8
 */
public class BuildTest01 {
	
	private int length = 50;
	
	/**
	 * test1:(随随机生成10000个不重复的数字 )
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
		
		System.out.println("循环次数：" + count);
		System.out.println(set.toString());
		
	}

}
