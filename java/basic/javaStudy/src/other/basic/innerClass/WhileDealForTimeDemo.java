package other.basic.innerClass;

import other.basic.innerClass.WhileDealForTime.Deal;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��1��
 * @author xiangning
 * @since JDK1.8
 */
public class WhileDealForTimeDemo {
	
	public static void main(String[] args) {
		System.out.println("��ʼ");
		
		
		new WhileDealForTime(5000,500,new Deal() {
			int time = 0;
			@Override
			public boolean whileDeal() {
				System.out.println("ѭ��ִ��ʱ����");
				if(++time == 3) {
					//���ѭ��5�ξ��ж�ִ��
					return false;
				}
				return true;
			}
			@Override
			public void before() {
				System.out.println("ѭ��ִ��ǰ");
			}
			@Override
			public void after() {
				System.out.println("ѭ��ִ�к�");
			}
			
		});//ÿ500����ִ��һ��
		System.out.println("����");
		
		
		
		System.out.println("�ֲ��ڲ���-------------------------------------");
		
		/**
		 * <PRE>
		 * �ֲ��ڲ���
		 * </PRE>
		 *
		 * ��Ŀ���ƣ�javaStudy</BR>
		 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
		 * 
		 * @version 1.0 2019��6��1��
		 * @author xiangning
		 * @since JDK1.8
		 */
		class InnerDealClass implements Deal{

			@Override
			public boolean whileDeal() {
				System.out.println("ѭ��ִ�оֲ��ڲ���");
				return true;
			}
			
		}
		
		new WhileDealForTime(1000,300,new InnerDealClass());
		
		
	}

}
