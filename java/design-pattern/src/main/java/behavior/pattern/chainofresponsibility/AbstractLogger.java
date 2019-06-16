package behavior.pattern.chainofresponsibility;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月6日
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
