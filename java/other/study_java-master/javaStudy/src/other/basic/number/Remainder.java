package other.basic.number;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月24日
 * @author xiangning
 * @since JDK1.8
 */
public class Remainder {
	
	public static void main(String[] args) {
		//取余
		int count = 9;
		int rows = 10;
		
		int size = count/rows;
		
		int a  = count%rows;
//		
//		System.out.println(size);
//		
//		System.out.println(a);
//		
		
		if(a > 0) {
			System.out.println(++size);
		}else {
			System.out.println(size);
		}
		
		
		System.out.println(6/5);
		
		
	}

}
