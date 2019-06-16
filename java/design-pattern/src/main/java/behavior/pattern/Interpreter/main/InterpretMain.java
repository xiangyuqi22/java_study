package behavior.pattern.Interpreter.main;

import behavior.pattern.Interpreter.AndExpression;
import behavior.pattern.Interpreter.Expression;
import behavior.pattern.Interpreter.OrExpression;
import behavior.pattern.Interpreter.TerminalExpression;

/**
 * <PRE>

	������ģʽ
		������ģʽ��Interpreter Pattern���ṩ���������Ե��﷨����ʽ�ķ�ʽ����������Ϊ��ģʽ������ģʽʵ����һ�����ʽ�ӿڣ��ýӿڽ���һ���ض��������ġ�����ģʽ������ SQL ���������Ŵ�������ȡ�
	
	��ͼ��
		����һ�����ԣ����������ķ���ʾ��������һ�������������������ʹ�øñ�ʶ�����������еľ��ӡ�
	
	��Ҫ�����
		����һЩ�̶��ķ�����һ�����;��ӵĽ�������
	
	��ʱʹ�ã�
		���һ���ض����͵����ⷢ����Ƶ���㹻�ߣ���ô���ܾ�ֵ�ý�������ĸ���ʵ������Ϊһ���������еľ��ӡ������Ϳ��Թ���һ�����������ý�����ͨ��������Щ��������������⡣
	
	��ν����
		�����﷨���������ս������ս����
	
	�ؼ����룺
		���������࣬����������֮���һЩȫ����Ϣ��һ���� HashMap��
	
	Ӧ��ʵ����
		��������������ʽ���㡣
	
	�ŵ㣺 
		1������չ�ԱȽϺã��� 
		2���������µĽ��ͱ��ʽ�ķ�ʽ�� 
		3������ʵ�ּ��ķ���
		
	ȱ�㣺 
		1�������ó����Ƚ��١� 
		2�����ڸ��ӵ��ķ��Ƚ���ά���� 
		3��������ģʽ�����������͡� 
		4��������ģʽ���õݹ���÷�����
	
	ʹ�ó����� 
		1�����Խ�һ���ֵ����������һ�ּ򵥵����������б� 
		3��һ���������Ҫ����ִ�е������еľ��ӱ�ʾΪһ�������﷨���� 
		2��һЩ�ظ�����Ҫ���͵ĳ�����
	
	ע�����
		�����ó����Ƚ��٣�JAVA ��������������� expression4J ���档




 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��7��
 * @author xiangning
 * @since JDK1.8
 */
public class InterpretMain {
	
	public static void main(String[] args) {
		
		Expression orExpression = getOrExpression();
		
		System.out.println("�ν���Ӣ�ۺú� �� " + orExpression.interpret("�ν���Ӣ�ۺú�"));
		
		System.out.println("�ν����Ǽ�ʱ�� �� " + orExpression.interpret("�ν����Ǽ�ʱ��"));
		
		Expression andExpression = getAndExpression();
		System.out.println("��36λ��g�� �� " + andExpression.interpret("��36λ��g��"));
		
	}
	
	
	public static Expression getOrExpression() {
		Expression e1 = new TerminalExpression("�ν�");
		Expression e2 = new TerminalExpression("��ʱ��");
		return new AndExpression(e1, e2);
	}
	
	public static Expression getAndExpression() {
		Expression e1 = new TerminalExpression("�ν�");
		Expression e2 = new TerminalExpression("��g��");
		return new OrExpression(e1, e2);
	}
	
	
	

}
