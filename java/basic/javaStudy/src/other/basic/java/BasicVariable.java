package other.basic.java;
/**
 * <PRE>
 * 基本数据类型并不存在引用的问题
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月25日
 * @author xiangning
 * @since JDK1.8
 */
public class BasicVariable {
	
	public static void main(String[] args) {
		boolean b = false;
		changeBoolean(b);
		System.out.println(b);
		
		Boolean c = false;
		changeBoolean(c);
		System.out.println(c);
	}
	
	
	public static void changeBoolean(Boolean  bool) {
		bool = true;
	}
}

