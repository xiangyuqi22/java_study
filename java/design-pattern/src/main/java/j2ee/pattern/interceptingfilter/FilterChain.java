package j2ee.pattern.interceptingfilter;

import java.util.ArrayList;
import java.util.List;

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
public class FilterChain {
	
	private List<Filter> filters = new ArrayList<>();
	
	private Target target;
	
	public void addFilter(Filter filter) {
		filters.add(filter);
	}
	
	public void execute(String request) {
		for (Filter filter : filters) {
			boolean execute = filter.execute(request);
			if(!execute) {
				System.out.println("�����ѱ����أ����ټ���ִ��");
				return;
			}
		}
		target.execute(request);
	}
	
	public void setTarget(Target target) {
		this.target = target;
	}
	

}
