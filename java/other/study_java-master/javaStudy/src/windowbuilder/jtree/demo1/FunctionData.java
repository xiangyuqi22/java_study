package windowbuilder.jtree.demo1;

import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

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
