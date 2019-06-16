package com.study.junit.demo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.study.junit.demo1.TestCaseWithAnnotation;

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
public class TestCaseWithAnnotationTest {

	private static TestCaseWithAnnotation test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new TestCaseWithAnnotation();
		System.out.println("@BeforeClass --> �ǻ�����ģ�ִֻ��һ�Σ��ұ�����static���ڵ�Ԫ���������ഴ��ʱִ��");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass --> �ǻ�����ģ�ֻ��ʾһ�Σ��ұ�����static���ڵ�Ԫ��������������ʱִ��");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before --> �ǻ��ڷ����ģ�ÿ��ִ�е�Ԫ���������ķ���ʱ�����ִ��һ��");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After --> �ǻ��ڷ����ģ�ÿ��ִ�е�Ԫ���������ķ���֮�󣬱��ִ��һ��");
	}

	@Test
	public void testAdd() {
		assertEquals(2, test.add(1, 1));
	}

	@Test(timeout = 1000,expected = ArithmeticException.class)
	public void testDivision() throws InterruptedException {
		double division = test.division(100, 0);
//		System.out.println("division = " + division);
//		assertEquals(1, division);
		assertEquals(1, division, 0);
	}

}
