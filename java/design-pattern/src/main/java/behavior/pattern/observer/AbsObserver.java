package behavior.pattern.observer;
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
public abstract class AbsObserver {
	
	protected Subject subject;
	
	public AbsObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	public abstract void update();

}
