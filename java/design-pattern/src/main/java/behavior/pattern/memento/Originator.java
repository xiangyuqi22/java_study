package behavior.pattern.memento;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月8日
 * @author xiangning
 * @since JDK1.8
 */
public class Originator {
	
	private String status;
	
	public void setStatus(String status ) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public Memento saveMeneto() {
		return new Memento(status);
	}
	
	public void getMeneto(Memento memento) {
		this.status = memento.getStatus();
	}
	

}
