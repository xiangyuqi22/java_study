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
public class Controller {
	
	private Student model;
	
	private View view;

	public Controller(Student model, View view) {
		this.model = model;
		this.view = view;
	}

	public void setModel(Student model) {
		this.model = model;
	}


	public void setView(View view) {
		this.view = view;
	}
	
	public void updateView() {
		view.show(model);
	}

}
