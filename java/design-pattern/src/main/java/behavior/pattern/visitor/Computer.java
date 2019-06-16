package behavior.pattern.visitor;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��11��
 * @author xiangning
 * @since JDK1.8
 */
public class Computer extends ComputerPart {
	
	public ComputerPart[] computerParts = new ComputerPart[] {
			new Keyboard() , new Motitor() , new Mouse()
	};

	@Override
	public void accept(ComputerPartVisitor computrerPartVisitor) {
		for (ComputerPart computerPart : computerParts) {
			computerPart.accept(computrerPartVisitor);
			computerPart.say();
		}
		computrerPartVisitor.visitor(this);
	}

	@Override
	public void say() {
		System.out.println("����");
	}

}
