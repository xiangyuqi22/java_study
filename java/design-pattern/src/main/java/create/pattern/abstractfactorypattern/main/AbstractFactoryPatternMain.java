package create.pattern.abstractfactorypattern.main;

import create.pattern.abstractfactorypattern.AbstractorFactory;
import create.pattern.abstractfactorypattern.FactoryProducer;
import create.pattern.abstractfactorypattern.IColor;
import create.pattern.abstractfactorypattern.IShape;

/**
 * <PRE>
 * ���󹤳�ģʽ
 * 	ѧϰ��ַ��http://www.runoob.com/design-pattern/abstract-factory-pattern.html
 	���󹤳�ģʽ��Abstract Factory Pattern����Χ��һ�������������������������ó��������ֳ�Ϊ���������Ĺ�����
 	�������͵����ģʽ���ڴ�����ģʽ�����ṩ��һ�ִ����������ѷ�ʽ��
 	�ڳ��󹤳�ģʽ�У��ӿ��Ǹ��𴴽�һ����ض���Ĺ���������Ҫ��ʽָ�����ǵ��ࡣÿ�����ɵĹ������ܰ��չ���ģʽ�ṩ����
 	
 	��ͼ���ṩһ������һϵ����ػ��໥��������Ľӿڣ�������ָ�����Ǿ�����ࡣ
	��Ҫ�������Ҫ����ӿ�ѡ������⡣
	��ʱʹ�ã�ϵͳ�Ĳ�Ʒ�ж���һ���Ĳ�Ʒ�壬��ϵͳֻ��������ĳһ��Ĳ�Ʒ��
	��ν������һ����Ʒ�����棬��������Ʒ��
	�ؼ����룺��һ��������ۺ϶��ͬ���Ʒ��
	
	�ŵ㣺��һ����Ʒ���еĶ��������Ƴ�һ����ʱ�����ܱ�֤�ͻ���ʼ��ֻʹ��ͬһ����Ʒ���еĶ���
	ȱ�㣺��Ʒ����չ�ǳ����ѣ�Ҫ����һ��ϵ�е�ĳһ��Ʒ����Ҫ�ڳ���� Creator ��Ӵ��룬��Ҫ�ھ��������Ӵ��롣
	ʹ�ó����� 
		1��QQ ��Ƥ����һ����һ�𻻡�
	 	2�����ɲ�ͬ����ϵͳ�ĳ���
	ע�������Ʒ������չ����Ʒ�ȼ�����չ��

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��17��
 * @author xiangning
 * @since JDK1.8
 */
public class AbstractFactoryPatternMain {
	
	public static void main(String[] args) {
		AbstractorFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
//		IColor color = factory.getColor("BLACK");
//		color.fill();
		IShape shape = shapeFactory.getShape("CIRCLE");
		shape.draw();
		
		AbstractorFactory colorFactory = FactoryProducer.getFactory("COLOR");
		IColor color = colorFactory.getColor("BLACK");
		color.fill();
		
	}

}
