package behavior.pattern.chainofresponsibility;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��6��
 * @author xiangning
 * @since JDK1.8
 */
public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(AbstractLogger nextAbstractLogger, int level) {
		super(nextAbstractLogger, level);
	}

	@Override
	protected void write(String message) {
		System.out.println("structure.pattern.chainofresponsibility.ErrorLogger" + message);
	}

}
