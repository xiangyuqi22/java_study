package com.study.junit.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.study.junit.demo1.MathDemo;

import junit.framework.TestCase;

/**
 * <PRE>
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�junit_study</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��2��
 * @author xiangning
 * @since JDK1.8
 */
public class MathDemoTest extends TestCase{

	public void testAdd() {
		MathDemo demo = new MathDemo();
		int expected = 3;
		int actual = demo.add(1, 2);
		assertEquals(expected, actual);
//		failNotEquals("�Ӻŷ����д�", expected, actual);
	}

	@Test
	public void testReduce() {
		MathDemo demo = new MathDemo();
		int expected = -1;
		int actual = demo.reduce(1, 2);
		assertEquals(expected, actual);
	}

}
