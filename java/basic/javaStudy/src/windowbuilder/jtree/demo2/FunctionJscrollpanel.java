package windowbuilder.jtree.demo2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月22日
 * @author xiangning
 * @since JDK1.8
 */
public class FunctionJscrollpanel extends JScrollPane {
	
	public FunctionJscrollpanel() {
		FuntionTree tree = new FuntionTree();
		this.setViewportView(tree);
	}

}
