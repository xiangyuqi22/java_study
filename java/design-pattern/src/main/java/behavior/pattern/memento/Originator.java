package behavior.pattern.memento;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��8��
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
