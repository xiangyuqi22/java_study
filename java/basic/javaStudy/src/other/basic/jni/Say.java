package other.basic.jni;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月11日
 * @author xiangning
 * @since JDK1.8
 */ 
public class Say {
	
	static {
		//System.out.println(System.getProperty("java.library.path"));
		System.loadLibrary("Project1");
	}
	
	
	public native void sayHello() ;
	
	public static void main(String[] args) {
		new Say().sayHello();
	}

}
