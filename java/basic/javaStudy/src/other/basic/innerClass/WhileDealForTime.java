package other.basic.innerClass;
/**
 * <PRE>
��ĳ��ʱ���ʱ��ѭ��ִ��ĳ�����������������ʱ��Σ����˳�ѭ�������Զ���ѭ��ǰ�������Щ����Ҳ������չ����ѭ������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��1��
 * @author xiangning
 * @since JDK1.8
 */
public class WhileDealForTime {
	
	/**
	 * ѭ��ִ���ܺ�ʱ����λ������
	 */
	protected final int dealTime;
	
	/**
	 * ��¼��ʼʱ��
	 */
	private long startTime;
	
	/**
	 * Creates a new instance of WhileDealForTime. 
	 * @param dealTime			��ѭ��ʱ��
	 * @param sleepTime			ÿ��ѭ������ʱ��
	 * @param deal				������
	 */
	public WhileDealForTime(int dealTime,int sleepTime,Deal deal) {
		this.dealTime = dealTime;
		this.action(deal, sleepTime);
	}
	
	/**
	 * ready:(���Ϊtrue������ִ�У����Ϊfalse��ʾ ����ʱ�䣬�ж�ִ��)
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
		 * before:(ѭ��ִ��ǰ)
		 * @author xiangning
		 *
		 */
		default void before() {
			
		};
		/**
		 * whileDeal:(ѭ��ִ��)
		 * @author xiangning
		 *
		 */
		public boolean whileDeal();
		/**
		 * after:(ѭ��ִ�н�����)
		 * @author xiangning
		 *
		 */
		default void after() {
			
		};
	}
	
	

}
