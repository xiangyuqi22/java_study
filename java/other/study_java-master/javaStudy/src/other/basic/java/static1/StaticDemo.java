package other.basic.java.static1;
/**
 * <PRE>
 * 内部类   
 * 
 * 		内部类写静态方法,当前内部类也必须是静态类
 * 
 * 静态内部类在外部类拥有所有权限,如在静态方法中使用等
 * 但是
 * 		非静态内部类里面不能写静态方法
 * 		非静态内部类,不允许在外部类的静态方法里面使用,创建对象都不行
 * 
 * 
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月5日
 * @author xiangning
 * @since JDK1.8
 */
public class StaticDemo {
	
	
	public static void main(String[] args) {
		System.out.println(A.b);
	}
	

}


class A{
	
	public static B b = B.getB();
	
	public static class B{
			private static B getB() {
				return new B();
			}
		}
}