package j2ee.pattern.mvc.main;

import j2ee.pattern.mvc.Controller;
import j2ee.pattern.mvc.Student;
import j2ee.pattern.mvc.View;

/**
 * <PRE>

	MVC 模式
		MVC 模式代表 Model-View-Controller（模型-视图-控制器） 模式。这种模式用于应用程序的分层开发。
	Model（模型） - 模型代表一个存取数据的对象或 JAVA POJO。它也可以带有逻辑，在数据变化时更新控制器。
	View（视图） - 视图代表模型包含的数据的可视化。
	Controller（控制器） - 控制器作用于模型和视图上。它控制数据流向模型对象，并在数据变化时更新视图。它使视图与模型分离开。


 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月12日
 * @author xiangning
 * @since JDK1.8
 */
public class MVCMain {
	
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("宋江");
		student.setRollNo(111);
		View view = new View();
		Controller controller = new Controller(student,view);
		controller.updateView();
		student.setName("李白");
		student.setRollNo(222);
		controller.updateView();
		
	}

}
