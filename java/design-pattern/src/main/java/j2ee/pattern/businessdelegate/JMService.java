package j2ee.pattern.businessdelegate;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��13��
 * @author xiangning
 * @since JDK1.8
 */
public class JMService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("j2ee.pattern.businessdelegate.JMService");
	}

	@Override
	public void doSomething() {
		BusinessService.super.doSomething();
		System.out.println("j2ee.pattern.businessdelegate.JMService.doSomething()");
	}

}
