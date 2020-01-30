package com.study.algorithm.stack;
/**
 * <PRE>
 * ջ�Ľӿ�
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��20��
 * @author xiangning
 * @since JDK1.8
 */
public interface StackInterface {
	
	public boolean isEmpty() ;
	
	/**
	 * isFull:(�ж��Ƿ�ջ��)
	 * @author xiangning
	 *
	 * @return
	 */
	public boolean isFull();
	
	/**
	 * push:(���������ջ����������ӽ��)
	 * @author xiangning
	 *
	 * @param data
	 * @return ����ջ�Ƿ�ɹ�
	 */
	public boolean push(int data);
	
	/**
	 * pop:(��ջ)
	 * @author xiangning
	 *
	 * @return	��ǰ��ջ�����ݣ�û�����������쳣
	 */
	public int pop() throws Exception;
	
	/**
	 * show:(����ջ)
	 * @author xiangning
	 *
	 */
	public void show();
	
	/**
	 * peek:(�鿴ջ�����ݣ�������ɾ��)
	 * @author xiangning
	 *
	 * @return
	 */
	public int peek() throws Exception;
	
	

}
