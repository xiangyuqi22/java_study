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
public class Memento {
	
	private String status;
	
	public Memento(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}

}
