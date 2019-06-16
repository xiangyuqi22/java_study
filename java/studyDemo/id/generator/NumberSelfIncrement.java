package id.generator;
/**
 * <PRE>
 * 数值自增长
 * </PRE>
 *
 * 项目名称：demo</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月4日
 * @author xiangning
 * @since JDK1.8
 */
public class NumberSelfIncrement {
	public static int num = 2;
	
	public static void main(String[] args) {
		NumberSelfIncrement n = new NumberSelfIncrement();
		Object o = n;
		System.out.println(n.getClass().getName());
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			System.out.println(n.getId());
		}
		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
		public synchronized Long getId() {
			Long currentTime = System.currentTimeMillis();
			Long maxTime = this.getNumber() * 1000000000000l;
			Long id = currentTime + maxTime;
			return id;
	}
	
	private int getNumber() {
		if(num>995) {
			num = 2;
		}
		return num++;
	}
	
}
