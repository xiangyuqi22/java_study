package j2ee.pattern.mvc;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月12日
 * @author xiangning
 * @since JDK1.8
 */
public class View {
	
	public void show(Student student) {
		System.out.println(student.getName() + " -->  " + student.getRollNo());
	}

}
