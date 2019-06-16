package windowbuilder.jtree.demo1;

import java.util.Hashtable;

import javax.swing.JScrollPane;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月21日
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
