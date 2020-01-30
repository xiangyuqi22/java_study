package com.study.algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��20��
 * @author xiangning
 * @since JDK1.8
 */
public class CalculatorExpressionDemo {

	/**
	 * test1:(���������ֵ) ʹ��ջ���������ļ��� ˼· 1. ͨ��һ�� index ֵ�������������������ǵ������ 2.
	 * ������Ƿ�����һ������, ��ֱ������ջ 3. �������ɨ�赽��һ������, �ͷ�������� 3.1 ������ֵ�ǰ�ķ���ջΪ �գ���ֱ����ջ 3.2
	 * �������ջ�в��������ͽ��бȽ�,�����ǰ�Ĳ����������ȼ�С�ڻ��ߵ���ջ�еĲ�������
	 * ����Ҫ����ջ��pop��������,�ڴӷ���ջ��pop��һ�����ţ��������㣬���õ����������ջ�� Ȼ�󽫵�ǰ�Ĳ����������ջ��
	 * �����ǰ�Ĳ����������ȼ�����ջ�еĲ������� ��ֱ�������ջ. 4. �������ɨ����ϣ���˳��Ĵ� ��ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������. 5.
	 * �������ջֻ��һ�����֣�����������Ľ��
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

		// ����ջ
		CalculatorExpression numCalc = new CalculatorExpression(10);
		// �����ջ
		CalculatorExpression expCalc = new CalculatorExpression(10);
		int index = 0;
		String expression = "100+200-300+10/10+1*1+300/2";
		
		String numStr = "";
		while (index < expression.length()) {
			String currentStr = expression.substring(index, index + 1);
			char current = currentStr.charAt(0);
//			System.out.print("��ǰ�ַ� -> " + current);
			boolean isExpression = isExpression(current);
//			System.out.println("\t �Ƿ�Ϊ�ַ� -> " + isExpression);

			if (isExpression) {
				// ����������
				if (expCalc.isEmpty()) {
					// ��������Ϊ�գ�ֱ����ջ
					expCalc.push(current);
				} else {
					/**
					 * ����������Ϊ�� 1�����жϵ�ǰ������������ջջ��������������ȼ� �����ǰ���ȼ�����ջ������ֱ����ջ �����ǰ���ȼ�С�ڻ����ջ��
					 * 1��������ջ��pop���������� 2���������ջ��pop��һ���ַ� 3����pop�������ֺ��ַ����м��� 4����������push������ջ��
					 * 5������ǰ������ַ�push������ջ��
					 */
					//�ӷ���ջ��ȡ��һ��ȡ��ջ�����ݣ���������ջ��ɾ��
					int peek = expCalc.peek();
					if(!isFirst(current, peek)) {
						//�����ǰ�����С�ڻ����ջ��
						//1��������ջ��pop����������
						int num1 = numCalc.pop();
						int num2 = numCalc.pop();
						//2���ӷ���ջ��pop��һ������
						int exp = expCalc.pop();
						//3�����м���
						int result = calculation(num2, num1, exp);
						//��������ѹ������ջ��
						numCalc.push(result);
						//����ǰ����ѹ��ջ��
					}
					//�����ǰ���������ջ������ֱ����ջ
					expCalc.push(current);
				}
			} else {
				// ��������֣�ֱ��������ջ
				numStr += currentStr;
				//�����һ���ַ�û���ˣ�������һ���ַ��������
				if(index >= expression.length()-1 
							|| isExpression(expression.substring(index+1, index + 2).charAt(0)) ) {
					numCalc.push(Integer.parseInt(numStr));
					numStr = "";
				}
			}
			index++;
		}
		
		//�����е��ַ�������������˳�������ջ��ȡ�����ݲ����м���
		while(!expCalc.isEmpty()) {
			int num1 = numCalc.pop();
			int num2 = numCalc.pop();
			int exp = expCalc.pop();
			int result = calculation(num2, num1, exp);
			numCalc.push(result);
		}
		System.out.printf("�õ������� --> %s = %d",expression,numCalc.pop());

	}
	
	

	
	/**
	 * subfixExpression:(�沨���������ֵ/��׺�������ֵ)
	 * 
	 * ��������ɨ�����������������ʱ��������ѹ���ջ�����������ʱ������ջ�����������������������������Ӧ�ļ��㣨�ζ�Ԫ�� �� ջ��Ԫ�أ���
	 * ���������ջ���ظ���������ֱ����������Ҷˣ��������ó���ֵ��Ϊ������Ľ��

		����: (3+4)��5-6 ��Ӧ�ĺ�׺��������� 3 4 + 5 �� 6 - , ��Ժ�׺�������ֵ��������:
		
			��������ɨ�裬��3��4ѹ���ջ��
			����+���������˵���4��3��4Ϊջ��Ԫ�أ�3Ϊ�ζ�Ԫ�أ��������3+4��ֵ����7���ٽ�7��ջ��
			��5��ջ��
			�������ǡ����������˵���5��7�������7��5=35����35��ջ��
			��6��ջ��
			�����-������������35-6��ֵ����29���ɴ˵ó����ս��	

	 * @author xiangning
	 * @throws Exception 
	 *
	 */
	@Test
	public void subfixExpression() throws Exception {
		
		/**
		 * ����һ����׺���ʽ
		 */
//		String subfixExpression = "3 4 + 5 * 6 -";
		
		//�������ת���һ��list
		
//		List<String> list = stringToList(subfixExpression," ");
//		System.out.println("list = " + list);
		
		//����һ��������ʽ����׺���ʽ��
		String expression = "1 + ( ( 2 + 3 ) * 4 ) - 15 + 20 * 12 + ( 2 + 5 ) * 3";
		//����׺���ʽת���ɺ�׺���ʽ
		List<String> list = middleToSubfix(expression);
		
		
		//����һ��ջ
		
		CalculatorExpression calculator = new CalculatorExpression(10);
		for (String str : list) {
			//1����������ʱ��ֱ����ջ
			//2�������ַ�ʱ����ջ��ȡ������������������ַ����м��㣬������������ջ
			
			if(isExpression(str.charAt(0))) {
				//������ַ�����ջ��ȡ����������Ȼ����м��㣬�ٽ���������ջ
				int num1 = calculator.pop();
				int num2 = calculator.pop();
				int result = calculation(num2, num1, str.charAt(0));
				calculator.push(result);
			}else {
				//��������������ֱ����ջ
				calculator.push(Integer.parseInt(str));
			}
		}
		//ջ�����һ�����־������Ľ��
		System.out.println("������ = " +calculator.pop());
	}
	
	
	/**
	 * middleToSubfix:(��׺���ʽת��׺���ʽ)
	 * 
	 * 	1) ��ʼ������ջ�������ջs1�ʹ����м�����ջs2��
		2) ��������ɨ����׺���ʽ��
		3) ����������ʱ������ѹs2��
		4) ���������ʱ���Ƚ�����s1ջ������������ȼ���
			1.���s1Ϊ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ��
			2.���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1��
			3.���򣬽�s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚϣ�
		5) ��������ʱ��(1) ����������š�(������ֱ��ѹ��s1(2) ����������š�)���������ε���s1ջ�����������
			��ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
		6) �ظ�����2��5��ֱ�����ʽ�����ұ�
		7) ��s1��ʣ�����������ε�����ѹ��s2
		8)  ���ε���s2�е�Ԫ�ز���������������Ϊ��׺���ʽ��Ӧ�ĺ�׺���ʽ

		����ֵ-��׺���ʽ��[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
		���ֵ-��׺���ʽ�� [1, 2, 3, +, 4, *, +, 5, -]
	 * @author xiangning
	 * @throws Exception 
	 *
	 */
	public List<String>  middleToSubfix(String expression) throws Exception {
//		String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
		//�ַ���תlist
		List<String> list = stringToList(expression," ");
		System.out.println(list);
		//����һ�������ջ
		CalculatorExpression calculator = new CalculatorExpression(20);
		//����һ��list�����洢���ʽ���
		List<String> result = new ArrayList<>(20);
		//�������ʽ
		for (String str : list) {
			char cha = str.charAt(0);
//			System.out.println("char = " + cha + ";isExpression(cha) = " + isExpression(cha));
			
			if(isExpression(cha)) {
				//����Ǳ��ʽ
				if(cha == '(' || calculator.isEmpty()) {
					//����������ţ���ջΪ�գ���ֱ����ջ
					calculator.push(cha);
				}else if (cha == ')') {
					//����������ţ�������ȡ��ջ�����ݣ�ֱ������������Ϊֹ
					while(true) {
						char temp = (char)calculator.pop();
						if(temp == '(') {
							break;
						}
						result.add(Character.toString(temp));
					}
					
				}else {
					/*
					4) ���������ʱ���Ƚ�����s1ջ������������ȼ���
						1.���s1Ϊ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ��
						2.���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1��
						3.���򣬽�s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚϣ�
					 */
					while(true){
						if(calculator.isEmpty()) {
							//���ջΪ�գ���ֱ�ӽ����������ջ
							calculator.push(cha);
							break;
						}
						int peek = calculator.peek();
						if(peek == '(' || isFirst(cha, peek)) {
							//�����ǰջ�������Ϊ�����ţ����ߵ�ǰ��������ȼ�����ջ������ֱ�ӽ����������ջ
							calculator.push(cha);
							break;
						}
						//���򣬽�s1ջ���������������ѹ�뵽�б���
						char pop = (char)calculator.pop();
						String st = Character.toString(pop);
						System.out.println(st);
						result.add(st);
					}
				}
			}else {
				//��������֣���ֱ�����б�
				result.add(str);
			}
		}
//		calculator.show();
		//�������������δ�ջ��ȡ�����ݵ��������
		while(!calculator.isEmpty()) {
			int pop = calculator.pop();
			result.add(Character.toString((char)pop));
		}
		
		System.out.println("��׺���ʽ��� = " + result);
		return result;
	}
	
	
	
	

	/**
	 * isExpression:(�ж��Ƿ�Ϊ�����)
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
	 * calculation:(��ִ�м���)
	 * 
	 * @author xiangning
	 *
	 * @param num1
	 *            ��һ����
	 * @param num2
	 *            �ڶ�����
	 * @param exp
	 *            �����
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
	 * isFirst:(�ж�c1�����ȼ��Ƿ����c2)
	 * @author xiangning
	 *
	 * @param c1
	 * @param c2
	 * @return true��c1���ȼ�����c2 false��c1���ȼ�С�ڻ����c2
	 */
	public boolean isFirst(int c1,int c2) {
		return ( c1 == '*' || c1 == '/' ) && ( c2=='+' || c2 == '-');
	}
	
	
	
	

	
	/**
	 * stringToList:(��һ���ַ���ת����list�б�)
	 * @author xiangning
	 *
	 * @param str		������ַ���
	 * @param splitStr	�ָ��ַ������ַ�
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
