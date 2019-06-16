package com.study.junit.demo1;
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
public class TestCaseWithAnnotation {
		
	protected int num  ;
	
	public int add(int a , int b) {
		return a + b;
	}
	
	public double division(int a , int b) throws InterruptedException {
		Thread.sleep(500);
		return a / b;
	}
	

}
