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
public class IfDemo1 {
	
	public static void main(String[] args) {
		
		System.out.println("跳转到" + demo1("-10", true));
		System.out.println("不跳转到" + demo1("-10", false));
		System.out.println("跳转到" + demo1("10", false));
		System.out.println("不跳转到" + demo1("10", true));
		
	}

	protected static int demo1(String line , boolean hasDefect) {
		boolean type = line.startsWith("-");
		boolean jump = (type && hasDefect) || (!type && !hasDefect) ? true : false;
		if( jump ) {
			if(line.startsWith("-")){
				line = line.substring(0 ,  line.length());
			}
			//如果第四个对象存在的话，那么出现缺陷了就需要跳转到指定行号执行
			int row = Integer.valueOf(line);
			if(row > 0) {
				return row;
			}
		}
		return -1000;
	}

}
