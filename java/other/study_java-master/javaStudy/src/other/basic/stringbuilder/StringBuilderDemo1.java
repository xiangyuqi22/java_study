package other.basic.stringbuilder;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月31日
 * @author xiangning
 * @since JDK1.8
 */
public class StringBuilderDemo1 {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		sb.append("d");
		sb.append("e");
		sb.append("f");
		sb.append("g");
		sb.append("h");
		sb.append("i");
		System.out.println(sb.toString());
		sb.setLength(0);
		System.out.println(sb.toString());
	}

}
