package other.basic.java;
/**
 * <PRE>
 * 知识点：
 * 	Long / Integer  的判断  ==  仅限在-128 ~ 127 有效  超过这个值 ，需要使用 equals
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月26日
 * @author xiangning
 * @since JDK1.8
 */
public class LongDemo {
	public static void main(String[] args) {
		Long a = 127L;
		Long b = 127L;
		System.out.println( a ==  b );
		System.out.println(a.equals(b));
		
		
		Integer aa = 128;
		Integer bb = 128;
		System.out.println(aa == bb);
		System.out.println(aa.equals(bb));
		
		
		
	}
}
