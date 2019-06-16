package j2ee.pattern.interceptingfilter;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��17��
 * @author xiangning
 * @since JDK1.8
 */
public class AuthenticationFilter implements Filter {

	@Override
	public boolean execute(String request) {
		System.out.println("j2ee.pattern.interceptingfilter.AuthenticationFilter -- >" + request);
		if(request.length() > 20) {
			System.out.println("�������ݲ��ܳ���20���ַ�");
			return false;
		}
		return true;
	}

}
