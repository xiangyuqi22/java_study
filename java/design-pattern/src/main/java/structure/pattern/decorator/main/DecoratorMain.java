package structure.pattern.decorator.main;

import structure.pattern.decorator.Circle;
import structure.pattern.decorator.GreenShape;
import structure.pattern.decorator.Rectangle;
import structure.pattern.decorator.RedShape;
import structure.pattern.decorator.Shape;

/**
 * <PRE>

	���ģʽ
		���ģʽ��Facade Pattern������ϵͳ�ĸ����ԣ�����ͻ����ṩ��һ���ͻ��˿��Է���ϵͳ�Ľӿڡ�
		�������͵����ģʽ���ڽṹ��ģʽ���������е�ϵͳ���һ���ӿڣ�������ϵͳ�ĸ����ԡ�
		����ģʽ�漰��һ����һ���࣬�����ṩ�˿ͻ�������ļ򻯷����Ͷ�����ϵͳ�෽����ί�е��á�

	
	��ͼ��
		Ϊ��ϵͳ�е�һ��ӿ��ṩһ��һ�µĽ��棬���ģʽ������һ���߲�ӿڣ�����ӿ�ʹ����һ��ϵͳ��������ʹ�á�
		
	��Ҫ�����
		���ͷ��ʸ���ϵͳ���ڲ���ϵͳʱ�ĸ��Ӷȣ��򻯿ͻ�����֮�Ľӿڡ�
	
	��ʱʹ�ã� 
		1���ͻ��˲���Ҫ֪��ϵͳ�ڲ��ĸ�����ϵ������ϵͳֻ���ṩһ��"�Ӵ�Ա"���ɡ� 
		2������ϵͳ����ڡ�
		
	��ν����
		�ͻ��˲���ϵͳ��ϣ��������ϵͳ��ϡ�
		
	�ؼ����룺
		�ڿͻ��˺͸���ϵͳ֮���ټ�һ�㣬��һ�㽫����˳��������ϵ�ȴ���á�
		
	Ӧ��ʵ���� 
		1��ȥҽԺ����������Ҫȥ�Һš�������ۡ�ȡҩ���û��߻��߼������úܸ��ӣ�������ṩ�Ӵ���Ա��ֻ�ýӴ���Ա�������ͺܷ��㡣 
		2��JAVA �����㿪��ģʽ��
		
	�ŵ㣺 
		1������ϵͳ�໥������ 
		2���������ԡ� 
		3������˰�ȫ�ԡ�
		
	ȱ�㣺�����Ͽ���ԭ�����Ҫ�Ķ������鷳���̳���д�������ʡ�
	
	ʹ�ó����� 
		1��Ϊ���ӵ�ģ�����ϵͳ�ṩ�����ʵ�ģ�顣 
		2����ϵͳ��Զ�����
		3��Ԥ����ˮƽ��Ա�����ķ��ա�
		
	ע�����
		�ڲ�λ��ṹ�У�����ʹ�����ģʽ����ϵͳ��ÿһ�����ڡ�





 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��30��
 * @author xiangning
 * @since JDK1.8
 */
public class DecoratorMain {
	
	public static void main(String[] args) {
		Shape redCircle = new RedShape(new Circle());
		redCircle.draw();
		
		Shape greenCircle = new GreenShape(new Circle());
		greenCircle.draw();
		
		System.out.println("-----------------------------------");
		
		Shape redRectangle = new RedShape(new Rectangle());
		redRectangle.draw();
		
		Shape greenRectangle = new GreenShape(new Rectangle());
		greenRectangle.draw();
		
	}

}
