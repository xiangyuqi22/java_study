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
public class DebugFilter implements Filter {

	@Override
	public boolean execute(String request) {
		System.out.println("j2ee.pattern.interceptingfilter.DebugFilter.execute(String) --> " + request);
		if(request.contains("��")) {
			return true;
		}
		return false;
	}

}
