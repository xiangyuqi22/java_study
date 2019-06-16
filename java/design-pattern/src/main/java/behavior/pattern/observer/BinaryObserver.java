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
public class BinaryObserver  extends AbsObserver{

	public BinaryObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("������ -> behavior.pattern.observer.BinaryAbsObserver   -->   " 
				+  Integer.toBinaryString( subject.getStatus() ) );
	}

}
