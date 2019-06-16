package structure.pattern.filter;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月27日
 * @author xiangning
 * @since JDK1.8
 */
public class Persion {
	
	private String name;
	
	private String gender;
	
	private String maritalStatus;

	public Persion(String name, String gender, String maritalStatus) {
		super();
		this.name = name;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	@Override
	public String toString() {
		return "Persion [name=" + name + ", gender=" + gender + ", maritalStatus=" + maritalStatus + "]";
	}
	
	

}
