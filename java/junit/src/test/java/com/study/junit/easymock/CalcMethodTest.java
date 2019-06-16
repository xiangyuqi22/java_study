package com.study.junit.easymock;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：junit_study</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月3日
 * @author xiangning
 * @since JDK1.8
 */
public class CalcMethodTest {
	
	
	IcalcMethod calcMethod;
	IcalcMethod calcMethod2;
	IncomeCalculator ncomeCalculator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("测试开始 -->>");
		calcMethod = EasyMock.createMock(IcalcMethod.class);
		System.out.println(calcMethod.getClass().getName());
		ncomeCalculator = new IncomeCalculator();
		calcMethod2 = EasyMock.createControl().createMock(IcalcMethod.class);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("测试结束 -->>");
	}

	@Test
	public void testCalcPersion() {
	}

	@Test
	public void testCalc1() {
		
		EasyMock.expect(calcMethod.calc(Persion.BOSS)).andReturn(12000.00).times(5);
		
		EasyMock.expect(calcMethod.calc(Persion.MANAGER)).andReturn(9000.00);
		
		EasyMock.expect(calcMethod.calc(Persion.PROGRAMMER)).andReturn(8000.00);
		
		
		EasyMock.replay(calcMethod);
		
		ncomeCalculator.setMethod(calcMethod);
		
		try {
			ncomeCalculator.calc();
			fail(" Persion null exception");
		} catch (Exception e) {
			
		}
		
		ncomeCalculator.setPersion(Persion.BOSS);
		
		assertEquals( 12000.00,ncomeCalculator.calc(),0);
		assertEquals( 12000.00,ncomeCalculator.calc(),0);
		assertEquals( 12000.00,ncomeCalculator.calc(),0);
		assertEquals( 12000.00,ncomeCalculator.calc(),0);
		assertEquals( 12001.00,ncomeCalculator.calc(),1);
		
		ncomeCalculator.setPersion(Persion.MANAGER);
		assertEquals(9000.00, ncomeCalculator.calc(),0);
		
		ncomeCalculator.setPersion(Persion.PROGRAMMER);
		assertEquals(8000.00, ncomeCalculator.calc(),0);
		
		EasyMock.verify(calcMethod);
		
	}
	
	@Test
	public void testCalc2() {
		EasyMock.expect(calcMethod.calc(Persion.BOSS)).andReturn(10000.00).times(2);
		EasyMock.replay(calcMethod);
		ncomeCalculator.setPersion(Persion.BOSS);
		ncomeCalculator.setMethod(calcMethod);
		assertEquals(10000.00, ncomeCalculator.calc(),0);
		assertEquals(10000.00, ncomeCalculator.calc(),0);
	}
	
	

}
