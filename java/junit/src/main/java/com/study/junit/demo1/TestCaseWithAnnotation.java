package com.study.junit.demo1;
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
