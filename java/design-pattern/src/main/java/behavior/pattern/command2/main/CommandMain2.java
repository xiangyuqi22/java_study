package behavior.pattern.command2.main;

import behavior.pattern.command2.Delete;
import behavior.pattern.command2.Edit;
import behavior.pattern.command2.OrderList;

/**
 * <PRE>


	����ģʽ
		����ģʽ��Command Pattern����һ���������������ģʽ����������Ϊ��ģʽ��
		�������������ʽ�����ڶ����У����������ö��󡣵��ö���Ѱ�ҿ��Դ��������ĺ��ʵĶ��󣬲��Ѹ��������Ӧ�Ķ��󣬸ö���ִ�����

	��ͼ��
		��һ�������װ��һ�����󣬴Ӷ�ʹ�������ò�ͬ������Կͻ����в�������
	
	��Ҫ�����
		�����ϵͳ�У���Ϊ����������Ϊʵ����ͨ����һ�ֽ���ϵĹ�ϵ����ĳЩ���ϣ�������Ҫ����Ϊ���м�¼������������������ȴ���ʱ��
		�����޷������仯�Ľ���ϵ���ƾͲ�̫���ʡ�
	
	��ʱʹ�ã�
		��ĳЩ���ϣ�����Ҫ����Ϊ����"��¼������/����������"�ȴ��������޷������仯�Ľ�����ǲ����ʵġ�����������£�
		��ν�"��Ϊ������"��"��Ϊʵ����"�����һ����Ϊ����Ϊ���󣬿���ʵ�ֶ���֮�������ϡ�
	
	��ν����
		ͨ�������ߵ��ý�����ִ�����˳�򣺵����ߡ������ߡ����
	
	�ؼ����룺
		����������ɫ��
			1��received ����������ִ�ж��� 
			2��Command 
			3��invoker ʹ�������������
	
	Ӧ��ʵ����
		struts 1 �е� action ���Ŀ����� ActionServlet ֻ��һ�����൱�� Invoker����ģ�Ͳ��������Ų�ͬ��Ӧ���в�ͬ��ģ���࣬�൱�ھ���� Command��
	
	�ŵ㣺 
		1��������ϵͳ��϶ȡ� 
		2���µ�������Ժ�������ӵ�ϵͳ��ȥ��
	
	ȱ�㣺ʹ������ģʽ���ܻᵼ��ĳЩϵͳ�й���ľ��������ࡣ
	
	ʹ�ó�����
		��Ϊ������ĵط�������ʹ������ģʽ�����磺 
			1��GUI ��ÿһ����ť����һ����� 
			2��ģ�� CMD��
	
	ע�����
		ϵͳ��Ҫ֧������ĳ���(Undo)�����ͻָ�(Redo)������Ҳ���Կ���ʹ������ģʽ��������ģʽ����չ��
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��6��
 * @author xiangning
 * @since JDK1.8
 */
public class CommandMain2 {
	
	public static void main(String[] args) {
		OrderList orders = new OrderList();
		{
			Edit edit = new Edit();
			orders.execute(edit);
		}
		{
			Delete delete = new Delete();
			orders.execute(delete);
		}
		{
			Edit edit = new Edit();
			orders.execute(edit);
		}
		{
			Edit edit = new Edit();
			orders.execute(edit);
		}
		{
			Delete delete = new Delete();
			orders.execute(delete);
		}
		
		System.out.println("----------------------------");
		orders.cancel();
		orders.cancel();
		orders.cancel();
		orders.cancel();
		orders.cancel();
		orders.cancel();
		orders.cancel();
		System.out.println(orders.getStack().size());
		
		
	}

}
