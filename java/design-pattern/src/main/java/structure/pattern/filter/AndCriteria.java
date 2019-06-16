package structure.pattern.filter;

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
 * @version 1.0 2019��4��27��
 * @author xiangning
 * @since JDK1.8
 */
public class AndCriteria implements Criteria {
	
	private Criteria first;
	
	private Criteria second;
	
	public AndCriteria(Criteria first , Criteria second ) {
		this.first = first;
		this.second = second;
	}

	@Override
	public List<Persion> meetCriteria(List<Persion> persionList) {
		List<Persion> meetCriteria = first.meetCriteria(persionList);
		return second.meetCriteria(meetCriteria);
	}

}
