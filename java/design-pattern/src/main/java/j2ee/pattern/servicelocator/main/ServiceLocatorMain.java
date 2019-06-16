package j2ee.pattern.servicelocator.main;

import j2ee.pattern.servicelocator.Service;
import j2ee.pattern.servicelocator.ServiceLocator;

/**
 * <PRE>
	
	����λ��ģʽ
	����λ��ģʽ��Service Locator Pattern��
	����������ʹ�� JNDI ��ѯ��λ���ַ����ʱ�򡣿��ǵ�Ϊĳ��������� JNDI �Ĵ��ۺܸߣ�����λ��ģʽ��������˻��漼����
	���״�����ĳ������ʱ������λ���� JNDI �в��ҷ��񣬲�����÷�����󡣵��ٴ�������ͬ�ķ���ʱ��
	����λ���������Ļ����в��ң����������ںܴ�̶������Ӧ�ó�������ܡ��������������ģʽ��ʵ�塣
	
	����Service�� - ʵ�ʴ�������ķ��񡣶����ַ�������ÿ����� JNDI �������в��ҵ���	
	
	Context / ��ʼ�� Context 
		- JNDI Context ���ж�Ҫ���ҵķ�������á�
	
	����λ����Service Locator�� 
		- ����λ����ͨ�� JNDI ���Һͻ����������ȡ����ĵ���Ӵ���
	
	���棨Cache�� 
		- ����洢��������ã��Ա㸴�����ǡ�
	
	�ͻ��ˣ�Client�� 
		- Client ��ͨ�� ServiceLocator ���÷���Ķ���
	

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��18��
 * @author xiangning
 * @since JDK1.8
 */
public class ServiceLocatorMain {
	
	public static void main(String[] args) {
		{
			Service service = ServiceLocator.getService("service1");
			service.execute();
		}
		{
			Service service = ServiceLocator.getService("service2");
			service.execute();
		}
		
		
		
	}

}
