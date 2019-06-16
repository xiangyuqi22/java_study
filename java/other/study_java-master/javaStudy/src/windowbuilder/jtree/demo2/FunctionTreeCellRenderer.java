package windowbuilder.jtree.demo2;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

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
public class FunctionTreeCellRenderer extends DefaultTreeCellRenderer {
	
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel,
            boolean expanded,
            boolean leaf, int row,
            boolean hasFocus) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		
		//如果是项目模块节点，那么图标全部是文件夹类型的
		if(leaf && node.getUserObject() instanceof FunctionData) {
			//如果是叶子节点
			super.setIcon(super.getClosedIcon());
			super.setLeafIcon(super.getClosedIcon());
		}
		return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
	}

}
