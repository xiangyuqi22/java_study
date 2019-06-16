package windowbuilder.jlist;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月5日
 * @author xiangning
 * @since JDK1.8
 */
public class MyJList<E> extends JList<E> {
	
	private ListSelectionListener addEvent = null; 
	
	public MyJList() {
		this.initList();
	}
	
	public MyJList(ListSelectionListener addEvent) {
		this.addEvent = addEvent;
		this.initList();
	}

	@SuppressWarnings("serial")
	private void initList() {
		this.addListSelectionListener(addEvent);
		
		super.setModel((ListModel<E>) new AbstractListModel<Object>() {
			String[] values = new String[] {"java", "javascript", "html", "css", "python", "robot"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				
				return values[index];
			}
		});
		
		this.setSelectedIndex(2);
	}
	
	
		
}
