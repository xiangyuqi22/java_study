package other.basic.java.datastructure;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <PRE>
	java数据结构 
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月30日
 * @author xiangning
 * @since JDK1.8
 */
public class EnumerationDemo {
	
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>(10);
		vector.add("Monday");
		vector.add("Tuesday");
		vector.add("Wednesday");
		vector.add("Thursday");
		vector.add("Friday");
		vector.add("Saturday");
		vector.add("sunday");
		Enumeration<String> elements = vector.elements();
		while (elements.hasMoreElements()) {
			String string = elements.nextElement();
			System.out.println(string);
		}
		
		
	}

}
