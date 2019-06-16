package behavior.pattern.nullobject.main;

import behavior.pattern.nullobject.CustomerFactory;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月9日
 * @author xiangning
 * @since JDK1.8
 */
public class NullObjectMain {
	
	public static void main(String[] args) {
		
		System.out.println(CustomerFactory.getCustomer("宋江").getName());
		
		System.out.println(CustomerFactory.getCustomer("杜甫").getName());
		
		System.out.println(CustomerFactory.getCustomer("武松").getName());
		
	}

}
