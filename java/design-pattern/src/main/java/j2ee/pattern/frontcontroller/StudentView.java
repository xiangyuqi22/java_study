package j2ee.pattern.frontcontroller;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��16��
 * @author xiangning
 * @since JDK1.8
 */
public class StudentView implements View{

	@Override
	public void show() {
		System.out.println("j2ee.pattern.frontcontroller.StudentView.show()");
	}

}
