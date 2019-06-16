package other.basic.java.lambda;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月5日
 * @author xiangning
 * @since JDK1.8
 */
public class LambdaDemo1 {
	
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 20 ; i++) {
				try {
					Thread.sleep(1000L);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		
		new Thread(() -> {
			for (int i = 0; i < 20 ; i++) {
				try {
					Thread.sleep(1000L);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		
	}

}
