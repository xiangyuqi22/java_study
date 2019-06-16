package behavior.pattern.Interpreter.main;

import behavior.pattern.Interpreter.AndExpression;
import behavior.pattern.Interpreter.Expression;
import behavior.pattern.Interpreter.OrExpression;
import behavior.pattern.Interpreter.TerminalExpression;

/**
 * <PRE>

	解释器模式
		解释器模式（Interpreter Pattern）提供了评估语言的语法或表达式的方式，它属于行为型模式。这种模式实现了一个表达式接口，该接口解释一个特定的上下文。这种模式被用在 SQL 解析、符号处理引擎等。
	
	意图：
		给定一个语言，定义它的文法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子。
	
	主要解决：
		对于一些固定文法构建一个解释句子的解释器。
	
	何时使用：
		如果一种特定类型的问题发生的频率足够高，那么可能就值得将该问题的各个实例表述为一个简单语言中的句子。这样就可以构建一个解释器，该解释器通过解释这些句子来解决该问题。
	
	如何解决：
		构建语法树，定义终结符与非终结符。
	
	关键代码：
		构建环境类，包含解释器之外的一些全局信息，一般是 HashMap。
	
	应用实例：
		编译器、运算表达式计算。
	
	优点： 
		1、可扩展性比较好，灵活。 
		2、增加了新的解释表达式的方式。 
		3、易于实现简单文法。
		
	缺点： 
		1、可利用场景比较少。 
		2、对于复杂的文法比较难维护。 
		3、解释器模式会引起类膨胀。 
		4、解释器模式采用递归调用方法。
	
	使用场景： 
		1、可以将一出现的问题可以用一种简单的语言来进行表达。 
		3、一个简单语个需要解释执行的语言中的句子表示为一个抽象语法树。 
		2、一些重复法需要解释的场景。
	
	注意事项：
		可利用场景比较少，JAVA 中如果碰到可以用 expression4J 代替。




 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月7日
 * @author xiangning
 * @since JDK1.8
 */
public class InterpretMain {
	
	public static void main(String[] args) {
		
		Expression orExpression = getOrExpression();
		
		System.out.println("宋江是英雄好汉 ： " + orExpression.interpret("宋江是英雄好汉"));
		
		System.out.println("宋江就是及时雨 ： " + orExpression.interpret("宋江就是及时雨"));
		
		Expression andExpression = getAndExpression();
		System.out.println("有36位天昰星 ： " + andExpression.interpret("有36位天昰星"));
		
	}
	
	
	public static Expression getOrExpression() {
		Expression e1 = new TerminalExpression("宋江");
		Expression e2 = new TerminalExpression("及时雨");
		return new AndExpression(e1, e2);
	}
	
	public static Expression getAndExpression() {
		Expression e1 = new TerminalExpression("宋江");
		Expression e2 = new TerminalExpression("天昰星");
		return new OrExpression(e1, e2);
	}
	
	
	

}
