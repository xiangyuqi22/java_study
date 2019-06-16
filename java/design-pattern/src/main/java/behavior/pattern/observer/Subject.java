package behavior.pattern.observer;

import java.util.ArrayList;
import java.util.List;

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
public class Subject {
	
	private List<AbsObserver> list = new ArrayList<AbsObserver>();
	
	private int status ;
	
	public void setStatus(int status) {
		System.out.println("�����������״̬:" + status);
		this.status = status;
		changeStatus();
	}
	
	public void attach(AbsObserver absObserver) {
		list.add(absObserver);
	}
	
	public void changeStatus() {
		for (AbsObserver absObserver : list) {
			absObserver.update();
		}
	}
	
	public int getStatus() {
		return status;
	}

}
