package structure.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 *	判断是否单身
 *	如果否，则过滤掉
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月27日
 * @author xiangning
 * @since JDK1.8
 */
public class SingleCriteria implements Criteria {

	@Override
	public List<Persion> meetCriteria(List<Persion> persionList) {
		List<Persion> list = new ArrayList<Persion>();
		for (Persion persion : persionList) {
			if("SINGLE".equalsIgnoreCase(persion.getMaritalStatus())) {
				list.add(persion);
			}
		}
		return list;
	}

}
