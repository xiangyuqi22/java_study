package other.basic.innerClass;
/**
 * <PRE>
在某个时间段时，循环执行某个方法，如果超出该时间段，将退出循环，可自定义循环前后进行哪些处理。也可以扩展定义循环次数
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月1日
 * @author xiangning
 * @since JDK1.8
 */
public class WhileDealForTime {
	
	/**
	 * 循环执行总耗时，单位：毫秒
	 */
	protected final int dealTime;
	
	/**
	 * 记录开始时间
	 */
	private long startTime;
	
	/**
	 * Creates a new instance of WhileDealForTime. 
	 * @param dealTime			总循环时间
	 * @param sleepTime			每次循环休眠时间
	 * @param deal				处理方法
	 */
	public WhileDealForTime(int dealTime,int sleepTime,Deal deal) {
		this.dealTime = dealTime;
		this.action(deal, sleepTime);
	}
	
	/**
	 * ready:(如果为true，继续执行，如果为false表示 超出时间，中断执行)
	 * @author xiangning
	 *
	 * @return
	 */
	public boolean ready() {
		return System.currentTimeMillis() <= (startTime + dealTime);
	}
	
	public void action(Deal deal , int sleepTime) {
		startTime = System.currentTimeMillis();
		deal.before();
		while(ready()) {
			if(!deal.whileDeal()) {
				break;
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
			}
		}
		deal.after();
	}
	
	
	public interface Deal{
		/**
		 * before:(循环执行前)
		 * @author xiangning
		 *
		 */
		default void before() {
			
		};
		/**
		 * whileDeal:(循环执行)
		 * @author xiangning
		 *
		 */
		public boolean whileDeal();
		/**
		 * after:(循环执行结束后)
		 * @author xiangning
		 *
		 */
		default void after() {
			
		};
	}
	
	

}
