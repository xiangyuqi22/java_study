package other.basic.java.datastructure;

import java.util.Stack;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��30��
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
