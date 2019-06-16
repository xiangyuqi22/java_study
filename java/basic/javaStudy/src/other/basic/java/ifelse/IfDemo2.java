package other.basic.java.ifelse;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月3日
 * @author xiangning
 * @since JDK1.8
 */
public class IfDemo2 {
	
	public static void main(String[] args) {
		long time = 3000l;
		//当前时间 减去 锚点时间 小于 判断时间  为 true
		System.out.println(test(100l,true,false));
		System.out.println(test(100000l,true,false));
		
		
		System.out.println(test(100l,false,true));
		System.out.println(test(100000l,false,true));
	}
	
	public static boolean test(long time , boolean gerater ,boolean less) {
		long currentTimeMillis = System.currentTimeMillis();
		long startTime = System.currentTimeMillis() - 3000L;
		long dealTime = currentTimeMillis - startTime;
		boolean re = (currentTimeMillis - startTime) < time ? true : false;
		
		if( (gerater && re) || (less && !re)) {
			return true;
		}		
		return false;
		
	}

}
