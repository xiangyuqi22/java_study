package other.basic.stringbuffer;


/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月31日
 * @author xiangning
 * @since JDK1.8
 */


public class StringBufferDemo {
	
	public static void main(String[] args) {
//		StringBuffer s = new StringBuffer(".....");
//		System.out.println(s.length());
//		
		StringBuffer strs = new StringBuffer(".");
		System.out.println(strs.toString());
		strs.delete(0, strs.length());
		System.out.println(strs.toString());
//		w : while (true) {
//			if(strs.toString().length() > 3) {
//				strs = new StringBuffer(".");
//			}
//			System.out.println(strs);
//		} 
	}
}
