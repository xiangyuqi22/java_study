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
public class IncomeCalculator {
	
	
	private Persion persion;
	
	private IcalcMethod method;
	
	public double calc() {
		if (persion == null) {
			throw new NullPersionException();
		} 
		if(method == null) {
			throw new NullCalcMechodException();
		}
		return method.calc(persion);
	}

	public void setPersion(Persion persion) {
		this.persion = persion;
	}

	public void setMethod(IcalcMethod method) {
		this.method = method;
	}
	
	
}
