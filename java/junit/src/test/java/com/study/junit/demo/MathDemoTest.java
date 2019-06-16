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
 * 项目名称：junit_study</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月2日
 * @author xiangning
 * @since JDK1.8
 */
public class MathDemoTest extends TestCase{

	public void testAdd() {
		MathDemo demo = new MathDemo();
		int expected = 3;
		int actual = demo.add(1, 2);
		assertEquals(expected, actual);
//		failNotEquals("加号方法有错", expected, actual);
	}

	@Test
	public void testReduce() {
		MathDemo demo = new MathDemo();
		int expected = -1;
		int actual = demo.reduce(1, 2);
		assertEquals(expected, actual);
	}

}
