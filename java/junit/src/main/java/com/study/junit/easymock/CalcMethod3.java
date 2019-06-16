package com.study.junit.easymock;
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
