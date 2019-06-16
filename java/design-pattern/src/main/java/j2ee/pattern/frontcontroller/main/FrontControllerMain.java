package j2ee.pattern.frontcontroller.main;

import j2ee.pattern.frontcontroller.FrontController;

/**
 * <PRE>

	ǰ�˿�����ģʽ
		ǰ�˿�����ģʽ��Front Controller Pattern���������ṩһ�����е���������ƣ����е����󶼽���һ����һ�Ĵ��������
		�ô�������������֤/��Ȩ/��¼��־�����߸�������Ȼ������󴫸���Ӧ�Ĵ�������������������ģʽ��ʵ�塣
	ǰ�˿�������Front Controller�� 
		- ����Ӧ�ó���������������ĵ����������Ӧ�ó�������ǻ��� web ��Ӧ�ó���Ҳ�����ǻ��������Ӧ�ó���
	��������Dispatcher�� 
		- ǰ�˿���������ʹ��һ������������������������Ӧ�ľ��崦�����
	��ͼ��View�� 
		- ��ͼ��Ϊ����������Ķ���
	

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��16��
 * @author xiangning
 * @since JDK1.8
 */
public class FrontControllerMain {
	
	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		frontController.dispatchRequest("HOME");
		frontController.dispatchRequest("STUDENT");
		
	}

}
