package create.pattern.abstractfactorypattern.main;

import create.pattern.abstractfactorypattern.AbstractorFactory;
import create.pattern.abstractfactorypattern.FactoryProducer;
import create.pattern.abstractfactorypattern.IColor;
import create.pattern.abstractfactorypattern.IShape;

/**
 * <PRE>
 * 抽象工厂模式
 * 	学习地址：http://www.runoob.com/design-pattern/abstract-factory-pattern.html
 	抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。
 	这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 	在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象
 	
 	意图：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
	主要解决：主要解决接口选择的问题。
	何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。
	如何解决：在一个产品族里面，定义多个产品。
	关键代码：在一个工厂里聚合多个同类产品。
	
	优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
	缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。
	使用场景： 
		1、QQ 换皮肤，一整套一起换。
	 	2、生成不同操作系统的程序。
	注意事项：产品族难扩展，产品等级易扩展。

 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月17日
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
