package other.basic.jni;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��11��
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
