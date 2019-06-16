package windowbuilder.jtree;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeSelectionModel;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月20日
 * @author xiangning
 * @since JDK1.8
 */
public class JTreeFirstDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTreeFirstDemo window = new JTreeFirstDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JTreeFirstDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		DefaultMutableTreeNode top = new DefaultMutableTreeNode("top");
		createNodes(top);
		JTree tree = new JTree(top);
		scrollPane.setViewportView(tree);
			
		
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// Returns the last path element of the selection.
				// This method is useful only when the selection model allows a single
				// selection.
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if (node == null)
					// Nothing is selected.
					return;

				Object nodeInfo = node.getUserObject();
				if (node.isLeaf()) {
					BookInfo book = (BookInfo) nodeInfo;
					System.out.println("book info = " + book.info);
				} else {
					System.out.println("book info 这是根节点");

				}
			}
		});
		
		tree.addTreeExpansionListener(new TreeExpansionListener() {
			
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
		
		tree.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 
				 if(e.getClickCount() == 2) {
					 System.out.println("进行了双击事件");
					 tree.getSelectionModel().setSelectionMode(1);
				 }
				 
				 if(e.isMetaDown()) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if(node  == null) {
						return;
					}
					System.out.println(node.getUserObject());
					System.out.println("-----------------------------------------");
					//System.out.println(((BookInfo)node.getUserObject()).info);
					System.out.println("-----------------------------------------");
					
					System.out.println("点击了右键");
					System.out.println(" tree.getSelectionPath() = "  +  tree.getSelectionPath());
					System.out.println("tree.getSelectionModel() = "  + tree.getSelectionModel());
					DefaultTreeSelectionModel d = (DefaultTreeSelectionModel) tree.getSelectionModel();
					System.out.println(d.getRowMapper());
					System.out.println(d);
				 }
			 }
		});

	}

	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;

		category = new DefaultMutableTreeNode("Books for Java Programmers");
		top.add(category);

		// original Tutorial
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Tutorial: A Short Course on the Basics", "tutorial.html"));
		category.add(book);

		// Tutorial Continued
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Tutorial Continued: The Rest of the JDK", "tutorialcont.html"));
		category.add(book);

		// JFC Swing Tutorial
		book = new DefaultMutableTreeNode(
				new BookInfo("The JFC Swing Tutorial: A Guide to Constructing GUIs", "swingtutorial.html"));
		category.add(book);

		// ...add more books for programmers...

		category = new DefaultMutableTreeNode("Books for Java Implementers");
		top.add(category);

		// VM
		book = new DefaultMutableTreeNode(new BookInfo("The Java Virtual Machine Specification", "vm.html"));
		category.add(book);

		// Language Spec
		book = new DefaultMutableTreeNode(new BookInfo("The Java Language Specification", "jls.html"));
		category.add(book);
	}

}

class BookInfo {
	String info;
	String html;

	public BookInfo(String info, String html) {
		this.info = info;
		this.html = html;
	}

	@Override
	public String toString() {
		return info + html;
	}

}
