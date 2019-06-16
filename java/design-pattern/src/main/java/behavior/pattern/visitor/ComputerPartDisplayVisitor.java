package behavior.pattern.visitor;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月11日
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
