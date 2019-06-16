package structure.pattern.flyweight.main;

import structure.pattern.flyweight.Circle;
import structure.pattern.flyweight.Rectangle;
import structure.pattern.flyweight.ShapeFactory;

/**
 * <PRE>

	��Ԫģʽ
		��Ԫģʽ��Flyweight Pattern����Ҫ���ڼ��ٴ���������������Լ����ڴ�ռ�ú�������ܡ�
		�������͵����ģʽ���ڽṹ��ģʽ�����ṩ�˼��ٶ��������Ӷ�����Ӧ������Ķ���ṹ�ķ�ʽ��
		��Ԫģʽ�����������е�ͬ��������δ�ҵ�ƥ��Ķ����򴴽��¶���
		���ǽ�ͨ������ 5 ������������ 20 ���ֲ��ڲ�ͬλ�õ�Բ����ʾ����ģʽ������ֻ�� 5 �ֿ��õ���ɫ������ color ���Ա�����������е� Circle ����
	
	��ͼ��
		���ù�������Ч��֧�ִ���ϸ���ȵĶ���
	
	��Ҫ�����
		���д�������ʱ���п��ܻ�����ڴ���������ǰ����й�ͬ�Ĳ��ֳ���������������ͬ��ҵ������ֱ�ӷ������ڴ������еĶ��󣬱������´�����
	
	��ʱʹ�ã� 
		1��ϵͳ���д������� 
		2����Щ�������Ĵ����ڴ档 
		3����Щ�����״̬�󲿷ֿ����ⲿ���� 
		4����Щ������԰�������״̬��Ϊ�ܶ��飬�������̶���Ӷ������޳�����ʱ��ÿһ����󶼿�����һ�����������档 
		5��ϵͳ����������Щ������ݣ���Щ�����ǲ��ɷֱ�ġ�
		
	��ν����
		��Ψһ��ʶ���жϣ�������ڴ����У��򷵻����Ψһ��ʶ������ʶ�Ķ���
	
	�ؼ����룺
		�� HashMap �洢��Щ����
	
	Ӧ��ʵ���� 
		1��JAVA �е� String��������򷵻أ����û���򴴽�һ���ַ����������ַ�����������档 
		2�����ݿ�����ݳء�
	
	�ŵ㣺
		�����ٶ���Ĵ���������ϵͳ���ڴ棬ʹЧ����ߡ�
	
	ȱ�㣺
		�����ϵͳ�ĸ��Ӷȣ���Ҫ������ⲿ״̬���ڲ�״̬�������ⲿ״̬���й��л������ʣ���Ӧ�������ڲ�״̬�ı仯���仯����������ϵͳ�Ļ��ҡ�
	
	ʹ�ó����� 
		1��ϵͳ�д������ƶ��� 
		2����Ҫ����صĳ�����
	
	ע����� 
		1��ע�⻮���ⲿ״̬���ڲ�״̬��������ܻ������̰߳�ȫ���⡣ 
		2����Щ�������һ������������Կ��ơ�


	�Լ�����⣺
		��ͬ�Ķ�������Ҫ�ٴ��������Ǵӻ�������ֱ��ȡ��
		���⣺
			���ȡ�Ķ���ͬһ�������������һ����������Խ������޸ģ����иö��������Ҳ�����޸ġ�

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��2��
 * @author xiangning
 * @since JDK1.8
 */
public class FlyweightMain {
	
	public static void main(String[] args) {
		Circle circle = (Circle)ShapeFactory.getShape("��ɫ", "circle");
		circle.draw();
		System.out.println(circle);
		Circle circle1 = (Circle)ShapeFactory.getShape("��ɫ", "circle");
		System.out.println(circle1);
		
		{
			System.out.println("-----------------------------------------------");
			Rectangle rectangle = (Rectangle)ShapeFactory.getShape("��ɫ", "rectangle");
			rectangle.draw();
		}
		{
			System.out.println("-----------------------------------------------");
			Rectangle rectangle = (Rectangle)ShapeFactory.getShape("��ɫ", "rectangle");
			rectangle.draw();
		}
		
	}

}
