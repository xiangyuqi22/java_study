package behavior.pattern.template;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��10��
 * @author xiangning
 * @since JDK1.8
 */
public abstract class Game {
	
	protected abstract void initialize();
	
	protected abstract void startPlay();
	
	protected abstract void stopPlay();
	
	public final void play() {
		
		initialize();
		
		startPlay();
		
		stopPlay();
	}
	

}
