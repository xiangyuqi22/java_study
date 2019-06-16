package other.basic.java.datastructure;

import java.util.Stack;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月30日
 * @author xiangning
 * @since JDK1.8
 */
public class StackDemo {
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("Monday");
		stack.push("Tuesday");
		stack.push("Wednesday");
		stack.push("Thursday");
		stack.push("Friday");
		stack.push("Saturday");
		stack.push("Sunday");
		{
			Stack<String> s = new Stack<>();
			s.addAll(stack);
			for (String string : s) {
				System.out.println(string);
			}
			System.out.println(s.size());
			System.out.println("-------------------------");
			while( s.size() > 0 ) {
				System.out.print(s.pop() + "\t");
			}
			
			s.addAll(stack);
			s.peek();
			System.out.println(s.size());
			s.pop();
			System.out.println(s.size());
			s.add("eight");
			System.out.println(s);
			s.push("nine");
			System.out.println(s);
			
			
		}
		
		
	}

}
