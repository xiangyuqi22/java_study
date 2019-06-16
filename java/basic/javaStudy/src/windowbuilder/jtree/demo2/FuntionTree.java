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
		// 添加监听事件
		this.addTreeExpansionListener(new TreeExpansionListener() {
			@Override
			public void treeExpanded(TreeExpansionEvent e) {
				// 节点展开事件
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
					// 双击鼠标事件
					// 得到当前节点

				}

				// 如果是点击了鼠标右键
				if (e.isMetaDown()) {
					System.out.println("点击了鼠标右键 ");
				}
			}
		});
	}
	
	/**
	 * expandEvent:(展开节点事件)
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
				// 首先判断当前节点的functionData的 list是否为null，如果不为空，表示还已查询过数据库并加载到树上
				List<FunctionData> listData = data.getListData();
				System.out.println(listData);
				if (listData != null) {
					return;
				}
				// 进入数据库查询当前节点的子节点
				// 将查询结果赋值给list 遍历list插入节点对象
				listData = new ArrayList<FunctionData>();
				data.setListData(listData);
				FunctionData data1 = new FunctionData(2000l, "图片测试1");
				FunctionData data2 = new FunctionData(2001l, "图片测试2");
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
		FunctionData d1 = new FunctionData(1001l, "测试项目1");
		FunctionData d2 = new FunctionData(1001l, "测试项目2");
		FunctionData d3 = new FunctionData(1001l, "测试项目3");

		DefaultMutableTreeNode parent1, parent2, parent3;
		parent1 = this.addObject(d1, null);
		parent2 = this.addObject(d2, null);
		parent3 = this.addObject(d3, null);

		this.addObject(new FunctionData(1002l, "搜索功能"), parent1);
		this.addObject(new FunctionData(1002l, "搜索功能222"), parent1);
		this.addObject(new FunctionData(1002l, "书签功能"), parent2);
		this.addObject(new FunctionData(1002l, "收藏功能"), parent3);

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
	 * expandAll:(展开所有节点)
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
