package structure.pattern.filter;

import java.util.List;

/**
 * <PRE>
 * 过滤器接口
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月27日
 * @author xiangning
 * @since JDK1.8
 */
public interface Criteria {
	
	public List<Persion> meetCriteria(List<Persion> persionList);

}
