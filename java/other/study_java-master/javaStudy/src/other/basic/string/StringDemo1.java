package other.basic.string;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月4日
 * @author xiangning
 * @since JDK1.8
 */
public class StringDemo1 {
	
	public static void main(String[] args) {
		String originName = "mystudy.jpg";
		String suffix = originName.substring(originName.lastIndexOf("."),originName.length());
		System.out.println(suffix);
	}

}
