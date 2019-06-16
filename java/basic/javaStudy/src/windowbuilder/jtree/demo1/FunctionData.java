package windowbuilder.jtree.demo1;

import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

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
public class FunctionData extends DefaultMutableTreeNode{
	
	private Long id;
	private String name;
	
	private Vector<FunctionData> children = new Vector<FunctionData>();
	
	
	
	public FunctionData() {
		super();
	}
	public FunctionData(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	public Vector<FunctionData> getChildren() {
		return children;
	}
	public void setChildren(Vector<FunctionData> children) {
		this.children = children;
	}
	
	

}
