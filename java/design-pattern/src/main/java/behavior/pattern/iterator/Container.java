package behavior.pattern.iterator;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��7��
 * @author xiangning
 * @since JDK1.8
 */
public interface Container<T> {
	
	public Iterator<T> getIterator();

}
