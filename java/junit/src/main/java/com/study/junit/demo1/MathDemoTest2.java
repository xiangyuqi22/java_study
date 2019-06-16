package com.study.junit.demo1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�junit_study</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��2��
 * @author xiangning
 * @since JDK1.8
 */
public class MathDemoTest2 extends MathDemo {
	
	@Before
	public void start() {
		System.out.println("startup");
	}
	
	@After
	public void done() {
		System.out.println("done");
	}

	@Test
	public void testAdd() {
		assertEquals(2, this.add(1, 1));
	}

	@Test
	public void testReduce() {
		assertEquals(1, this.reduce(3, 2));
	}

}
