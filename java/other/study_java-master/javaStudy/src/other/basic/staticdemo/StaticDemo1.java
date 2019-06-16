package other.basic.staticdemo;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月2日
 * @author xiangning
 * @since JDK1.8
 */

import windowbuilder.checkboxlist.main;

public class StaticDemo1 {
	
	private static String name ;
	
	public static void main(String[] args) {
		StaticDemo1 staticDemo1 = new StaticDemo1();
		staticDemo1.set1();
		String an = "cat";
		staticDemo1.set2("cat");
	}
	
	public void set1() {
		name = "dog";
	}
	
	public void set2(String an) {
		name  = an;
	}
	
}

class Persion {
	
}
