package structure.pattern.filter;

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
 * @version 1.0 2019年4月27日
 * @author xiangning
 * @since JDK1.8
 */
public class OrCriteria implements Criteria {
	
	private Criteria first;
	
	private Criteria second;
	
	public OrCriteria( Criteria first , Criteria second ) {
		this.first = first;
		this.second = second;
	}

	@Override
	public List<Persion> meetCriteria(List<Persion> persionList) {
		List<Persion> meetCriteria = first.meetCriteria(persionList);
		List<Persion> meetCriteria2 = second.meetCriteria(persionList);
		for (Persion persion : meetCriteria2) {
			if(!meetCriteria.contains(persion)) {
				meetCriteria.add(persion);
			}
		}
		return meetCriteria;
	}

}
