package com.study.algorithm.stack;
/**
 * <PRE>
 * 栈的接口
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月20日
 * @author xiangning
 * @since JDK1.8
 */
public interface StackInterface {
	
	public boolean isEmpty() ;
	
	/**
	 * isFull:(判断是否栈满)
	 * @author xiangning
	 *
	 * @return
	 */
	public boolean isFull();
	
	/**
	 * push:(添加数据入栈，并返回添加结果)
	 * @author xiangning
	 *
	 * @param data
	 * @return 出入栈是否成功
	 */
	public boolean push(int data);
	
	/**
	 * pop:(出栈)
	 * @author xiangning
	 *
	 * @return	当前出栈的数据，没有数据则抛异常
	 */
	public int pop() throws Exception;
	
	/**
	 * show:(遍历栈)
	 * @author xiangning
	 *
	 */
	public void show();
	
	/**
	 * peek:(查看栈顶数据，但并不删除)
	 * @author xiangning
	 *
	 * @return
	 */
	public int peek() throws Exception;
	
	

}
