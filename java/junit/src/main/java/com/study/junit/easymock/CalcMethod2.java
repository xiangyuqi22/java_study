package com.study.junit.easymock;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�junit_study</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��3��
 * @author xiangning
 * @since JDK1.8
 */
public class CalcMethod2 implements IcalcMethod {


	public double calc(Persion persion) {
		System.out.println("CalcMethod2  -->  calc");
		double salary  = 0 ;
		switch (persion) {
		case BOSS:
			salary = 11000.00;
			break;
		case PROGRAMMER:
			salary = 8100.00;
			break;
		case MANAGER:
			salary = 9100.00;
			break;
		}
		return salary;
	}

	
}
