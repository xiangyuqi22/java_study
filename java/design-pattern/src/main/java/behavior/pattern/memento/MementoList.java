package behavior.pattern.memento;

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
 * @version 1.0 2019��5��8��
 * @author xiangning
 * @since JDK1.8
 */
public class MementoList {
	
	private List<Memento> list = new ArrayList<Memento>();
	
	public void add(Memento memento) {
		list.add(memento);
	}
	
	public Memento getMemento(int index) {
		if(index >= list.size()) {
			return null;
		}
		return list.get(index);
	}

 }
