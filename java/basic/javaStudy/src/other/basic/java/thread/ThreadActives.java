package other.basic.java.thread;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月6日
 * @author xiangning
 * @since JDK1.8
 */
public class ThreadActives {
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(
				() ->{
					try {
						for (int i = 0; i < 10; i++) {
							new Thread(
									() -> {
										try {
											new Thread(
													() -> {
														System.out.println("三级线程： " + Thread.activeCount());
														try {
															Thread.sleep(1000L);
														} catch (InterruptedException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
													}
													).start();
											Thread.sleep(200L);
											System.out.println("二级线程： " + Thread.activeCount());
											Thread.sleep(1000L);
//											System.out.println(Thread.currentThread().getName());
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									).start();
						}
						Thread.sleep(200L);
						System.out.println("一级线程： " + Thread.activeCount());
						Thread.sleep(1000L);
						System.out.println("t1 .....");
					} catch (InterruptedException e) {
					}
				}
				).start();
		
		Thread.sleep(100L);
		System.out.println("顶级线程： " + Thread.activeCount());
	}

}
