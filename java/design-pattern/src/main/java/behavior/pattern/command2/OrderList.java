package behavior.pattern.command2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��6��
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
			System.out.println("û�пɳ��ص�������");
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
