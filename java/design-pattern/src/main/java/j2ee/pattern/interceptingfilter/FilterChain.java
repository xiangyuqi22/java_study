package j2ee.pattern.interceptingfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月17日
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
				System.out.println("请求已被拦截，不再继续执行");
				return;
			}
		}
		target.execute(request);
	}
	
	public void setTarget(Target target) {
		this.target = target;
	}
	

}
