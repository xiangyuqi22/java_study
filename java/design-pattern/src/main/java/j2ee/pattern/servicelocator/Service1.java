package j2ee.pattern.servicelocator;
/**
 * <PRE>
 * ����������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��18��
 * @author xiangning
 * @since JDK1.8
 */
public class Service1 implements Service {

	@Override
	public String getName() {
		return "service1";
	}

	@Override
	public void execute() {
		System.out.println("j2ee.pattern.servicelocator.Service1.execute()");
	}

}