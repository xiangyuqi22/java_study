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
public class CalcMethod3 implements IcalcMethod {


	public double calc(Persion persion) {
		System.out.println("CalcMethod3  -->  calc");
		double salary  = 0 ;
		switch (persion) {
		case BOSS:
			salary = 12000.00;
			break;
		case PROGRAMMER:
			salary = 8000.00;
			break;
		case MANAGER:
			salary = 9000.00;
			break;
		}
		return salary;
	}

	
}
