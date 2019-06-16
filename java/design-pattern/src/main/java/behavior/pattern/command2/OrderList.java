package behavior.pattern.command2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月6日
 * @author xiangning
 * @since JDK1.8
 */
public class OrderList {
	
	private Stack<AbstractOrder> stack = new Stack<>();
	
	public void execute(AbstractOrder order) {
		stack.push(order).execute();
	}
	
	public void cancel() {
		if(stack.isEmpty()) {
			System.out.println("没有可撤回的内容了");
			return;
		}
		stack.pop().cancle();
	}

	public Stack<AbstractOrder> getStack() {
		return stack;
	}

	public void setStack(Stack<AbstractOrder> stack) {
		this.stack = stack;
	}
	
	

}
