package windowbuilder.jtree.demo1;

import java.util.Vector;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import windowbuilder.jtree.GenealogyExampleProject.Person;

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
public class FunctionTreeModel extends DefaultTreeModel {
	
	private FunctionData functionData;


	public FunctionTreeModel(TreeNode root) {
		super(root);
	}


	/** 
	 * (��һ�仰�������������ʾʲô) 
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô) 
	 */ 
	private static final long serialVersionUID = 1L;
	private boolean showAncestors;
    private Vector<TreeModelListener> treeModelListeners =
        new Vector<TreeModelListener>();
    private FunctionData rootPerson;
	

	@Override
	public FunctionData getRoot() {
		System.out.println("�õ����ڵ�");
		FunctionData f1 = new FunctionData();
		f1.setName("������Ŀ");
		f1.setId(1111l);
		return f1;
	}

	@Override
	public FunctionData getChild(Object parent, int index) {
		System.out.println("getChild = " + index);
		FunctionData function = (FunctionData)parent;
		if(function.getChildren() == null && function.getChildren().isEmpty()) {
			return null;
		}
		return function.getChildren().get(index);
	}

	@Override
	public int getChildCount(Object parent) {
		System.out.println("getChildCount");
		FunctionData function = (FunctionData)parent;
		System.out.println(function.getChildren().size());
		return function.getChildren().size();
	}

	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		System.out.println("isLeaf");
		return false;
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		System.out.println("valueForPathChanged");
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		//��Ӽ���
		System.out.println("addTreeModelListener");
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		System.out.println("removeTreeModelListener");
	}
	
	
	protected void fireTreeStructureChanged(Person oldRoot) {
		System.out.println("fireTreeStructureChanged");
        int len = treeModelListeners.size();
        TreeModelEvent e = new TreeModelEvent(this, 
                                              new Object[] {oldRoot});
        for (TreeModelListener tml : treeModelListeners) {
            tml.treeStructureChanged(e);
        }
    }
	
}
