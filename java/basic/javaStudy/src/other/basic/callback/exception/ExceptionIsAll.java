package other.basic.callback.exception;
/**
 * <PRE>
 * java的异常是否可以达到线程级别
 * 答案 不可以
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月10日
 * @author xiangning
 * @since JDK1.8
 */
public class ExceptionIsAll {
	
	public static void main(String[] args) {
		try {
			new Thread(new TheThread()).start();
		} catch (Exception e) {
			System.out.println("异常发生了");
		}
	}
}


class TheThread implements Runnable{
	
	 @Override
	    public void run() {
		 System.out.println("接下来开始报异常");
	     Integer.valueOf("无可奈何花落去ds");
	    }
}