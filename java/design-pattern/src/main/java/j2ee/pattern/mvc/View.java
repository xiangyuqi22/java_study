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
public class View {
	
	public void show(Student student) {
		System.out.println(student.getName() + " -->  " + student.getRollNo());
	}

}
