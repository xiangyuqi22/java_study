package windowbuilder.jtree.demo2;

import java.util.List;

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
public class FunctionData {
	
	private Long id;
	private String name;
	private List<FunctionData> listData = null;
	
	
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


	public List<FunctionData> getListData() {
		return listData;
	}


	public void setListData(List<FunctionData> listData) {
		this.listData = listData;
	}
	
	

}
