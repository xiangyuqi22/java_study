package behavior.pattern.memento;

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
 * @version 1.0 2019年5月8日
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
