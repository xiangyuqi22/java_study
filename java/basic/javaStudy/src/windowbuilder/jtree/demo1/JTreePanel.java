package windowbuilder.jtree.demo1;

import java.util.Hashtable;

import javax.swing.JScrollPane;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��21��
 * @author xiangning
 * @since JDK1.8
 */
public class JTreePanel extends JScrollPane{
	
	public JTreePanel() {
		Hashtable<String, String[]> h1 = new Hashtable<>();
		h1.put("animal", new String[] {"dog","cat","pig"});
		h1.put("persion", new String[] {"chinese","jpanexe","usa"});
		FunctionTree tree = new FunctionTree();
		this.setViewportView(tree);
	}
}
