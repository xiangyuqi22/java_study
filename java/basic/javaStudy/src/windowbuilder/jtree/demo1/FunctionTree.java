package windowbuilder.jtree.demo1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

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
public class FunctionTree extends JTree {

	FunctionTreeModel model = null;

	private FunctionTree THIS = this;
	
	 public FunctionTree(Hashtable<?,?> value) {
		 super(value);
		 THIS.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 TreeSelectionModel selectionModel2 = THIS.getSelectionModel();
					TreePath path = selectionModel2.getSelectionPath();
					MutableTreeNode parent,node = (MutableTreeNode) path.getLastPathComponent();
					if(path.getPathCount() > 1) {
						parent = (MutableTreeNode)node.getParent();
					}else {
						parent =  (MutableTreeNode)node;
					}
				System.out.println(parent);
				System.out.println(THIS.getModel().getChild(new DefaultMutableTreeNode("persion"), 0));
			 }
		 });
		 
		 
		 
	    }
	

	public FunctionTree() {
		// 鼠标事件
		
		
		
		model = new FunctionTreeModel(new FunctionData(10000l,"测试项目"));
		
		
		
		this.setModel(model);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 双击鼠标事件
				if(e.getClickCount() == 2) {
					TreeSelectionModel selectionModel2 = THIS.getSelectionModel();
					TreePath path = selectionModel2.getSelectionPath();
					MutableTreeNode parent,node = (MutableTreeNode) path.getLastPathComponent();
					if(path.getPathCount() > 1) {
						parent = (MutableTreeNode)node.getParent();
					}else {
						parent =  (MutableTreeNode)node;
					}
					int index = parent.getIndex(node) + 1;
					FunctionData newChild = new FunctionData(1900l, "搜索功能");
					model.insertNodeInto(newChild, parent, index);
					THIS.revalidate();
					model.reload();
				}
				
				// 获取选中的对象
				/*FunctionData d = (FunctionData) THIS.getLastSelectedPathComponent();
				// 在该对象上添加子节点
				FunctionData d1 = new FunctionData();
				d1.setId(2222l);
				d1.setName("搜索功能");
				Vector<FunctionData> vector = new Vector<FunctionData>();
				vector.add(d1);
				d.setChildren(vector);

				System.out.println(d.getName() + d.getId());
				*/
			}
		});
		
		this.addTreeExpansionListener(new TreeExpansionListener() {
			
			@Override
			public void treeExpanded(TreeExpansionEvent event) {
				//tree的展开事件
				System.out.println("TreeExpansionListener");
				
				
			}
			
			@Override
			public void treeCollapsed(TreeExpansionEvent event) {
				//tree的关闭事件
				System.out.println("treeCollapsed");
			}
		});
	}

}
