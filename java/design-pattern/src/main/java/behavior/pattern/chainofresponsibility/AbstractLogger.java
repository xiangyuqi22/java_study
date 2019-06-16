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
public abstract class AbstractLogger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	protected int level;
	
	protected AbstractLogger nextAbstractLogger;
	
	public AbstractLogger(AbstractLogger nextAbstractLogger , int level) {
		this.level = level;
		this.nextAbstractLogger = nextAbstractLogger;
	}
	
	
	public void showMessage(int level , String message) {
		if(this.level >= level) {
			write(message);
		}
		if( nextAbstractLogger != null ) {
			nextAbstractLogger.showMessage(level, message);
		}
	}
	
	protected abstract void write(String message);
	

}
