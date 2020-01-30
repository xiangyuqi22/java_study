package com.study.algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * <PRE>
 * 计算运算符
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月20日
 * @author xiangning
 * @since JDK1.8
 */
public class CalculatorExpressionDemo {

	/**
	 * test1:(计算运算符值) 使用栈完成运算符的计算 思路 1. 通过一个 index 值（索引），来遍历我们的运算符 2.
	 * 如果我们发现是一个数字, 就直接入数栈 3. 如果发现扫描到是一个符号, 就分如下情况 3.1 如果发现当前的符号栈为 空，就直接入栈 3.2
	 * 如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符，
	 * 就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈， 然后将当前的操作符入符号栈，
	 * 如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈. 4. 当运算符扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行. 5.
	 * 最后在数栈只有一个数字，就是运算符的结果
	 * 
	 * @author xiangning
	 * @throws Exception 
	 *
	 */
	@Test
	public void test1() throws Exception {

		// System.out.println((int)'*');
		// System.out.println((int)'/');
		// System.out.println((int)'+');
		// System.out.println((int)'-');
//		System.out.println('3' + '4');

		// 数字栈
		CalculatorExpression numCalc = new CalculatorExpression(10);
		// 运算符栈
		CalculatorExpression expCalc = new CalculatorExpression(10);
		int index = 0;
		String expression = "100+200-300+10/10+1*1+300/2";
		
		String numStr = "";
		while (index < expression.length()) {
			String currentStr = expression.substring(index, index + 1);
			char current = currentStr.charAt(0);
//			System.out.print("当前字符 -> " + current);
			boolean isExpression = isExpression(current);
//			System.out.println("\t 是否为字符 -> " + isExpression);

			if (isExpression) {
				// 如果是运算符
				if (expCalc.isEmpty()) {
					// 如果运算符为空，直接入栈
					expCalc.push(current);
				} else {
					/**
					 * 如果运算符不为空 1、先判断当前运算符与运算符栈栈顶的运算符的优先级 如果当前优先级大于栈顶，则直接入栈 如果当前优先级小于或等于栈顶
					 * 1、从数字栈出pop出两个数字 2、从运算符栈出pop出一个字符 3、将pop出的数字和字符进行计算 4、将计算结果push到数字栈中
					 * 5、将当前运算符字符push到符号栈中
					 */
					//从符号栈中取出一个取出栈顶数据，但并不在栈中删除
					int peek = expCalc.peek();
					if(!isFirst(current, peek)) {
						//如果当前运算符小于或等于栈顶
						//1、从数字栈中pop出两个数字
						int num1 = numCalc.pop();
						int num2 = numCalc.pop();
						//2、从符号栈中pop出一个符号
						int exp = expCalc.pop();
						//3、进行计算
						int result = calculation(num2, num1, exp);
						//将计算结果压入数字栈中
						numCalc.push(result);
						//将当前符号压入栈顶
					}
					//如果当前运算符大于栈顶，则直接入栈
					expCalc.push(current);
				}
			} else {
				// 如果是数字，直接入数字栈
				numStr += currentStr;
				//如果下一个字符没有了，或者下一个字符是运算符
				if(index >= expression.length()-1 
							|| isExpression(expression.substring(index+1, index + 2).charAt(0)) ) {
					numCalc.push(Integer.parseInt(numStr));
					numStr = "";
				}
			}
			index++;
		}
		
		//当所有的字符都遍历结束后按顺序从两个栈中取出数据并进行计算
		while(!expCalc.isEmpty()) {
			int num1 = numCalc.pop();
			int num2 = numCalc.pop();
			int exp = expCalc.pop();
			int result = calculation(num2, num1, exp);
			numCalc.push(result);
		}
		System.out.printf("得到计算结果 --> %s = %d",expression,numCalc.pop());

	}
	
	

	
	/**
	 * subfixExpression:(逆波兰运算符求值/后缀运算符求值)
	 * 
	 * 从左至右扫描运算符，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），
	 * 并将结果入栈；重复上述过程直到运算符最右端，最后运算得出的值即为运算符的结果

		例如: (3+4)×5-6 对应的后缀运算符就是 3 4 + 5 × 6 - , 针对后缀运算符求值步骤如下:
		
			从左至右扫描，将3和4压入堆栈；
			遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
			将5入栈；
			接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
			将6入栈；
			最后是-运算符，计算出35-6的值，即29，由此得出最终结果	

	 * @author xiangning
	 * @throws Exception 
	 *
	 */
	@Test
	public void subfixExpression() throws Exception {
		
		/**
		 * 定义一个后缀表达式
		 */
//		String subfixExpression = "3 4 + 5 * 6 -";
		
		//将运算符转变成一个list
		
//		List<String> list = stringToList(subfixExpression," ");
//		System.out.println("list = " + list);
		
		//定义一个计算表达式（中缀表达式）
		String expression = "1 + ( ( 2 + 3 ) * 4 ) - 15 + 20 * 12 + ( 2 + 5 ) * 3";
		//将中缀表达式转换成后缀表达式
		List<String> list = middleToSubfix(expression);
		
		
		//定义一个栈
		
		CalculatorExpression calculator = new CalculatorExpression(10);
		for (String str : list) {
			//1：遇到数字时，直接入栈
			//2：遇到字符时，从栈中取出两个数，将结果与字符进行计算，将计算结果再入栈
			
			if(isExpression(str.charAt(0))) {
				//如果是字符，从栈中取出两个数，然后进行计算，再将计算结果入栈
				int num1 = calculator.pop();
				int num2 = calculator.pop();
				int result = calculation(num2, num1, str.charAt(0));
				calculator.push(result);
			}else {
				//如果不是运算符，直接入栈
				calculator.push(Integer.parseInt(str));
			}
		}
		//栈里最后一个数字就是最后的结果
		System.out.println("运算结果 = " +calculator.pop());
	}
	
	
	/**
	 * middleToSubfix:(中缀表达式转后缀表达式)
	 * 
	 * 	1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
		2) 从左至右扫描中缀表达式；
		3) 遇到操作数时，将其压s2；
		4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
			1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
			2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
			3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
		5) 遇到括号时：(1) 如果是左括号“(”，则直接压入s1(2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，
			并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
		6) 重复步骤2至5，直到表达式的最右边
		7) 将s1中剩余的运算符依次弹出并压入s2
		8)  依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式

		输入值-中缀表达式：[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
		输出值-后缀表达式： [1, 2, 3, +, 4, *, +, 5, -]
	 * @author xiangning
	 * @throws Exception 
	 *
	 */
	public List<String>  middleToSubfix(String expression) throws Exception {
//		String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
		//字符串转list
		List<String> list = stringToList(expression," ");
		System.out.println(list);
		//创建一个运算符栈
		CalculatorExpression calculator = new CalculatorExpression(20);
		//创建一个list用来存储表达式结果
		List<String> result = new ArrayList<>(20);
		//遍历表达式
		for (String str : list) {
			char cha = str.charAt(0);
//			System.out.println("char = " + cha + ";isExpression(cha) = " + isExpression(cha));
			
			if(isExpression(cha)) {
				//如果是表达式
				if(cha == '(' || calculator.isEmpty()) {
					//如果是左括号，或栈为空，则直接入栈
					calculator.push(cha);
				}else if (cha == ')') {
					//如果是右括号，则依次取出栈中数据，直到遇到左括号为止
					while(true) {
						char temp = (char)calculator.pop();
						if(temp == '(') {
							break;
						}
						result.add(Character.toString(temp));
					}
					
				}else {
					/*
					4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
						1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
						2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
						3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
					 */
					while(true){
						if(calculator.isEmpty()) {
							//如果栈为空，则直接将此运算符入栈
							calculator.push(cha);
							break;
						}
						int peek = calculator.peek();
						if(peek == '(' || isFirst(cha, peek)) {
							//如果当前栈顶运算符为左括号，或者当前运算符优先级大于栈顶，则直接将此运算符入栈
							calculator.push(cha);
							break;
						}
						//否则，将s1栈顶的运算符弹出并压入到列表中
						char pop = (char)calculator.pop();
						String st = Character.toString(pop);
						System.out.println(st);
						result.add(st);
					}
				}
			}else {
				//如果是数字，则直接入列表
				result.add(str);
			}
		}
//		calculator.show();
		//遍历结束后，依次从栈中取出数据到结果集中
		while(!calculator.isEmpty()) {
			int pop = calculator.pop();
			result.add(Character.toString((char)pop));
		}
		
		System.out.println("后缀表达式结果 = " + result);
		return result;
	}
	
	
	
	

	/**
	 * isExpression:(判断是否为运算符)
	 * 
	 * @author xiangning
	 *
	 * @param exp
	 * @return
	 */
	public boolean isExpression(char ch) {
		return ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '(' || ch == ')';
	}

	/**
	 * calculation:(这执行计算)
	 * 
	 * @author xiangning
	 *
	 * @param num1
	 *            第一个数
	 * @param num2
	 *            第二个数
	 * @param exp
	 *            运算符
	 * @return
	 */
	public int calculation(int num1, int num2, int exp) {
		switch (exp) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		}
		return 0;
	}

	/**
	 * isFirst:(判断c1的优先级是否大于c2)
	 * @author xiangning
	 *
	 * @param c1
	 * @param c2
	 * @return true：c1优先级大于c2 false：c1优先级小于或等于c2
	 */
	public boolean isFirst(int c1,int c2) {
		return ( c1 == '*' || c1 == '/' ) && ( c2=='+' || c2 == '-');
	}
	
	
	
	

	
	/**
	 * stringToList:(将一个字符串转换成list列表)
	 * @author xiangning
	 *
	 * @param str		运算符字符串
	 * @param splitStr	分隔字符串的字符
	 * @return
	 */
	private List<String> stringToList(String str,String splitStr) {
		List<String> list = new ArrayList<>( Arrays.asList(str.split(splitStr)));
		return Arrays.asList(str.split(splitStr));		
	}
	

}

class CalculatorExpression extends LinkedStack {

	public CalculatorExpression(int maxSize) {
		super(maxSize);
	}

}
