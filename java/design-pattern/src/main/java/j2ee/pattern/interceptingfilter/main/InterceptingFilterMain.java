package j2ee.pattern.interceptingfilter.main;

import j2ee.pattern.interceptingfilter.Client;
import j2ee.pattern.interceptingfilter.Target;

/**
 * <PRE>

	���ع�����ģʽ
		���ع�����ģʽ��Intercepting Filter Pattern�����ڶ�Ӧ�ó�����������Ӧ��һЩԤ����/����
		��������������ڰ����󴫸�ʵ��Ŀ��Ӧ�ó���֮ǰӦ���������ϡ���������������֤/��Ȩ/��¼��־�����߸�������
		Ȼ������󴫸���Ӧ�Ĵ�������������������ģʽ��ʵ�塣
		
	��������Filter�� 
		- �����������������ִ������֮ǰ��֮��ִ��ĳЩ����
	����������Filter Chain��
	
	 - �����������ж�������������� Target �ϰ��ն����˳��ִ����Щ��������
	Target - Target ���������������
	
	���˹�������Filter Manager�� 
		- ���˹���������������͹���������
		
	�ͻ��ˣ�Client�� 
		- Client ���� Target ����������Ķ���


 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��17��
 * @author xiangning
 * @since JDK1.8
 */
public class InterceptingFilterMain {
	
	public static void main(String[] args) {
		Client client = new Client(new Target());
		client.sendRequest("��֪���Ǹ��˲������������һ����ڵȣ������ſ�����������ҹ����������ڲ��ϵı仯���Ҳŷ��֣�����������ô�ã�ȴ����û�п������Ƭ���");
	}

}
