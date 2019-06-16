package com.study.junit.demo1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
