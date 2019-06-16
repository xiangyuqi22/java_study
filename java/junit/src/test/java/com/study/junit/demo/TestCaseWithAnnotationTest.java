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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：junit_study</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月2日
 * @author xiangning
 * @since JDK1.8
 */
public class TestCaseWithAnnotationTest {

	private static TestCaseWithAnnotation test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new TestCaseWithAnnotation();
		System.out.println("@BeforeClass --> 是基于类的，只执行一次，且必须是static，在单元测试用例类创建时执行");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass --> 是基于类的，只显示一次，且必须是static，在单元测试用例类销毁时执行");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before --> 是基于方法的，每次执行单元测试用例的方法时，便会执行一次");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After --> 是基于方法的，每次执行单元测试用例的方法之后，便会执行一次");
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
