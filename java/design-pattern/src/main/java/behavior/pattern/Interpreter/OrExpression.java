package behavior.pattern.Interpreter;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月7日
 * @author xiangning
 * @since JDK1.8
 */
public class OrExpression implements Expression {
	
	private Expression exception1;
	private Expression exception2;
	
	public OrExpression( Expression exception1 , Expression exception2 ) {
		this.exception1 = exception1;
		this.exception2 = exception2;
	}
	

	@Override
	public boolean interpret(String context) {
		return exception1.interpret(context) || exception2.interpret(context);
	}

}
