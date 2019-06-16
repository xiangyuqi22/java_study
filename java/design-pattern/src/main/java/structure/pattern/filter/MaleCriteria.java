package structure.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * �����Ƿ�����
 * ���������˵�
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��27��
 * @author xiangning
 * @since JDK1.8
 */
public class MaleCriteria implements Criteria{

	@Override
	public List<Persion> meetCriteria(List<Persion> persionList) {
		List<Persion> list = new ArrayList<Persion>();
		for (Persion persion : persionList) {
			if("MALE".equalsIgnoreCase(persion.getGender())) {
				list.add(persion);
			}
		}
		return list;
	}

}
