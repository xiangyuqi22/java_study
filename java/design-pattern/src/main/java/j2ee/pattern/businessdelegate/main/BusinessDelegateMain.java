package j2ee.pattern.businessdelegate.main;

import j2ee.pattern.businessdelegate.BusinessDelegate;
import j2ee.pattern.businessdelegate.Client;

/**
 * <PRE>


	ҵ�����ģʽ��Business Delegate Pattern�����ڶԱ�ʾ���ҵ�����
	������������������ͨ�Ż�Ա�ʾ������е�ҵ�������Զ�̲�ѯ���ܡ���ҵ���������������ʵ�塣
	
	�ͻ��ˣ�Client�� - ��ʾ���������� JSP��servlet �� UI java ���롣
	ҵ�����Business Delegate�� - һ��Ϊ�ͻ���ʵ���ṩ������࣬���ṩ�˶�ҵ����񷽷��ķ��ʡ�
	��ѯ����LookUp Service�� - ���ҷ���������ȡ��ص�ҵ��ʵ�֣����ṩҵ������ҵ��������ķ��ʡ�
	ҵ�����Business Service�� - ҵ�����ӿڡ�ʵ���˸�ҵ������ʵ���࣬�ṩ��ʵ�ʵ�ҵ��ʵ���߼���


 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��13��
 * @author xiangning
 * @since JDK1.8
 */
public class BusinessDelegateMain {
	
	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();
		Client client = new Client(businessDelegate);
		
		businessDelegate.setType("EJB");
		client.doTask();
		
		businessDelegate.setType("");
		client.doTask();
		
		
		
		
	}

}
