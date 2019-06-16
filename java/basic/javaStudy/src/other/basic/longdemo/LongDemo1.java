package other.basic.longdemo;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月1日
 * @author xiangning
 * @since JDK1.8
 */
public class LongDemo1 {
	
	private Long aa;
	
	public static void main(String[] args) {
		long a= 0 ;
		Long b= null;
		b = a;
		System.out.println(b);
		Long c = 1l;
		c = new LongDemo1().getAa();
		System.out.println(c == 0 );
	}
	
	public Long getAa() {
		return aa;
	}
}
