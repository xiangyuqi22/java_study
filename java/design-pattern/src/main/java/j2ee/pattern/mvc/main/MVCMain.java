package j2ee.pattern.mvc.main;

import j2ee.pattern.mvc.Controller;
import j2ee.pattern.mvc.Student;
import j2ee.pattern.mvc.View;

/**
 * <PRE>

	MVC ģʽ
		MVC ģʽ���� Model-View-Controller��ģ��-��ͼ-�������� ģʽ������ģʽ����Ӧ�ó���ķֲ㿪����
	Model��ģ�ͣ� - ģ�ʹ���һ����ȡ���ݵĶ���� JAVA POJO����Ҳ���Դ����߼��������ݱ仯ʱ���¿�������
	View����ͼ�� - ��ͼ����ģ�Ͱ��������ݵĿ��ӻ���
	Controller���������� - ������������ģ�ͺ���ͼ�ϡ���������������ģ�Ͷ��󣬲������ݱ仯ʱ������ͼ����ʹ��ͼ��ģ�ͷ��뿪��


 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��12��
 * @author xiangning
 * @since JDK1.8
 */
public class MVCMain {
	
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("�ν�");
		student.setRollNo(111);
		View view = new View();
		Controller controller = new Controller(student,view);
		controller.updateView();
		student.setName("���");
		student.setRollNo(222);
		controller.updateView();
		
	}

}
