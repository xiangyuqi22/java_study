package windowbuilder.jtree.demo2;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��22��
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
		
		//�������Ŀģ��ڵ㣬��ôͼ��ȫ�����ļ������͵�
		if(leaf && node.getUserObject() instanceof FunctionData) {
			//�����Ҷ�ӽڵ�
			super.setIcon(super.getClosedIcon());
			super.setLeafIcon(super.getClosedIcon());
		}
		return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
	}

}
