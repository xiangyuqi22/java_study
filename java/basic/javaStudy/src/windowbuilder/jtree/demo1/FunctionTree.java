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
		// ����¼�
		
		
		
		model = new FunctionTreeModel(new FunctionData(10000l,"������Ŀ"));
		
		
		
		this.setModel(model);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ˫������¼�
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
					FunctionData newChild = new FunctionData(1900l, "��������");
					model.insertNodeInto(newChild, parent, index);
					THIS.revalidate();
					model.reload();
				}
				
				// ��ȡѡ�еĶ���
				/*FunctionData d = (FunctionData) THIS.getLastSelectedPathComponent();
				// �ڸö���������ӽڵ�
				FunctionData d1 = new FunctionData();
				d1.setId(2222l);
				d1.setName("��������");
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
				//tree��չ���¼�
				System.out.println("TreeExpansionListener");
				
				
			}
			
			@Override
			public void treeCollapsed(TreeExpansionEvent event) {
				//tree�Ĺر��¼�
				System.out.println("treeCollapsed");
			}
		});
	}

}
