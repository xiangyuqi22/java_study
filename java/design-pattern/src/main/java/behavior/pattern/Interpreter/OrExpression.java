package behavior.pattern.Interpreter;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��7��
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
