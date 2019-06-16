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
public class ComputerPartDisplayVisitor extends ComputerPartVisitor {

	@Override
	public void visitor(Keyboard keyboard) {
		System.out.println("behavior.pattern.visitor.ComputerPartDisplayVisitor.visitor(Keyboard)");
	}

	@Override
	public void visitor(Motitor motitor) {
		System.out.println("behavior.pattern.visitor.ComputerPartDisplayVisitor.visitor(Motitor)");
	}

	@Override
	public void visitor(Mouse mouse) {
		System.out.println("behavior.pattern.visitor.ComputerPartDisplayVisitor.visitor(Mouse)");
	}

	@Override
	public void visitor(Computer computer) {
		System.out.println("behavior.pattern.visitor.ComputerPartDisplayVisitor.visitor(Computer)");
	}

}
