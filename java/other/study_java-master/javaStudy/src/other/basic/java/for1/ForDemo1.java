package other.basic.java.for1;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月1日
 * @author xiangning
 * @since JDK1.8
 */
public class ForDemo1 {
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			if(i == 5) {
				i = -30;
			}
		}
	}

}
