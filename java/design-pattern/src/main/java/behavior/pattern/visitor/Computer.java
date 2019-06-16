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
		System.out.println("电脑");
	}

}
