package windowbuilder.jtree.demo2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

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
public class FuntionTree extends JTree {

	private FuntionTree THIS = this;
	DefaultMutableTreeNode root = null;
	DefaultTreeModel rootModel = null;

	public FuntionTree() {
		root = new DefaultMutableTreeNode();
		rootModel = new DefaultTreeModel(root);
		this.addNode();
		this.setModel(rootModel);
		this.setRootVisible(false);
		this.setCellRenderer(new FunctionTreeCellRenderer());
		this.expandAll(new TreePath(root), true);
		// ��Ӽ����¼�
		this.addTreeExpansionListener(new TreeExpansionListener() {
			@Override
			public void treeExpanded(TreeExpansionEvent e) {
				// �ڵ�չ���¼�
				THIS.expandEvent(e);
			}

			@Override
			public void treeCollapsed(TreeExpansionEvent event) {
				// TODO Auto-generated method stub

			}
		});

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// ˫������¼�
					// �õ���ǰ�ڵ�

				}

				// ����ǵ��������Ҽ�
				if (e.isMetaDown()) {
					System.out.println("���������Ҽ� ");
				}
			}
		});
	}
	
	/**
	 * expandEvent:(չ���ڵ��¼�)
	 * @author xiangning
	 *
	 * @param e
	 */
	protected void expandEvent(TreeExpansionEvent e) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				TreePath path = e.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
				System.out.println(node.isLeaf());
				FunctionData data = (FunctionData) node.getUserObject();
				// �����жϵ�ǰ�ڵ��functionData�� list�Ƿ�Ϊnull�������Ϊ�գ���ʾ���Ѳ�ѯ�����ݿⲢ���ص�����
				List<FunctionData> listData = data.getListData();
				System.out.println(listData);
				if (listData != null) {
					return;
				}
				// �������ݿ��ѯ��ǰ�ڵ���ӽڵ�
				// ����ѯ�����ֵ��list ����list����ڵ����
				listData = new ArrayList<FunctionData>();
				data.setListData(listData);
				FunctionData data1 = new FunctionData(2000l, "ͼƬ����1");
				FunctionData data2 = new FunctionData(2001l, "ͼƬ����2");
				listData.add(data1);
				listData.add(data2);
				for (FunctionData functionData : listData) {
					THIS.addObject(functionData, node);
				}
				THIS.revalidate();
			}
		}).start();
	}

	private void addNode() {
		FunctionData d1 = new FunctionData(1001l, "������Ŀ1");
		FunctionData d2 = new FunctionData(1001l, "������Ŀ2");
		FunctionData d3 = new FunctionData(1001l, "������Ŀ3");

		DefaultMutableTreeNode parent1, parent2, parent3;
		parent1 = this.addObject(d1, null);
		parent2 = this.addObject(d2, null);
		parent3 = this.addObject(d3, null);

		this.addObject(new FunctionData(1002l, "��������"), parent1);
		this.addObject(new FunctionData(1002l, "��������222"), parent1);
		this.addObject(new FunctionData(1002l, "��ǩ����"), parent2);
		this.addObject(new FunctionData(1002l, "�ղع���"), parent3);

	}

	private DefaultMutableTreeNode addObject(FunctionData d1, DefaultMutableTreeNode parent1) {
		DefaultMutableTreeNode d = new DefaultMutableTreeNode(d1);
		if (parent1 == null) {
			parent1 = root;
		}
		rootModel.insertNodeInto(d, parent1, parent1.getChildCount());
		return d;
	}
	
	/**
	 * expandAll:(չ�����нڵ�)
	 * @author xiangning
	 *
	 * @param parent
	 * @param expand
	 */
	private void expandAll(TreePath parent, boolean expand) {
		// Traverse children
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(path, expand);
			}
		}
		if (expand) {
			THIS.expandPath(parent);
		} else {
			THIS.collapsePath(parent);
		}
	}

}
