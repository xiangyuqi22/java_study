package j2ee.pattern.mvc;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��12��
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
