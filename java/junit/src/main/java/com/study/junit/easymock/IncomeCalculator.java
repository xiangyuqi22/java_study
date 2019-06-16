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
