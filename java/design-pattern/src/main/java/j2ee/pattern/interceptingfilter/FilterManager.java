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
public class FilterManager {
	
	public FilterChain filterChain;
	
	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}
	
	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}
	
	public void filterRequest(String request) {
		filterChain.execute(request);
	}

}
