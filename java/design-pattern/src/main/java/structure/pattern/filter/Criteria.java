package structure.pattern.filter;

import java.util.List;

/**
 * <PRE>
 * �������ӿ�
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��27��
 * @author xiangning
 * @since JDK1.8
 */
public interface Criteria {
	
	public List<Persion> meetCriteria(List<Persion> persionList);

}
