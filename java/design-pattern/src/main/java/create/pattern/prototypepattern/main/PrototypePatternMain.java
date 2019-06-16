package create.pattern.prototypepattern.main;

import create.pattern.prototypepattern.Shape;
import create.pattern.prototypepattern.ShapeCache;

/**
 * <PRE>
  	
  	学习地址：http://www.runoob.com/design-pattern/prototype-pattern.html
  	原型模式
		原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
		这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。
		例如，一个对象需要在一个高代价的数据库操作之后被创建。
		我们可以缓存该对象，在下一个请求时返回它的克隆，在需要的时候更新数据库，以此来减少数据库调用。
	
	
	意图：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
	
	主要解决：在运行期建立和删除原型。
	
	何时使用： 
		1、当一个系统应该独立于它的产品创建，构成和表示时。 
		2、当要实例化的类是在运行时刻指定时，例如，通过动态装载。
		3、为了避免创建一个与产品类层次平行的工厂类层次时。
		4、当一个类的实例只能有几个不同状态组合中的一种时。建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些。
	
	如何解决：利用已有的一个原型对象，快速地生成和原型对象一样的实例。
	
	关键代码：
		1、实现克隆操作，在 JAVA 继承 Cloneable，重写 clone()
		2、原型模式同样用于隔离类对象的使用者和具体类型（易变类）之间的耦合关系，它同样要求这些"易变类"拥有稳定的接口。
	
	应用实例： 
		1、细胞分裂。
		2、JAVA 中的 Object clone() 方法。
	
	优点： 
		1、性能提高。 
		2、逃避构造函数的约束。
	
	缺点：
	 	1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，
	 		特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。 
	 	2、必须实现 Cloneable 接口。
	
	使用场景： 
		1、资源优化场景。 
		2、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。 
		3、性能和安全要求的场景。 
		4、通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。 
		5、一个对象多个修改者的场景。 
		6、一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。 
		7、在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过 clone 的方法创建一个对象，然后由工厂方法提供给调用者。
			原型模式已经与 Java 融为浑然一体，大家可以随手拿来使用。
	
	注意事项：
		与通过对一个类进行实例化来构造新对象不同的是，原型模式是通过拷贝一个现有对象生成新对象的。
		浅拷贝实现 Cloneable，重写，深拷贝是通过实现 Serializable 读取二进制流。
	
	
	
	自己的理解 ：
		1：主要通过克隆来获取一个具有相相同属性的实例对象
			为什么要使用克隆，而不是直接赋值？
				因为直接赋值只是为这个对象增加了一个引用而已，实际使用的还是堆里面的一个对象。如果其中一个引用对对象进行了修改，那么其他的引用也是拿到修改后的对象
		2：克隆中浅克隆跟深克隆有什么区别？
			浅克隆和深克隆都会生成一个与原型对象一模一样，但是引用跟堆内的对象却不一样的对象。
			但是如果对象中有非基础数据，即有对象的引用，那么克隆出来的也是对象的引用。既然是对象的引用，那么该实例还是共享的。
			如果是深克隆，克隆出的将是一个完完全全的新对象，内部的引用都是全新的。
			浅克隆所消耗的资源少，速度快。实现简单
			深克隆所消耗的资源多，速度慢。实现复杂 
		3：浅克隆与深克隆的实现方式
			浅克隆 ：
				1：实现cloneable接口
					调用clone()方法；
					参考：create.pattern.prototypepattern.Shape.clone()
					
			
			深克隆：
				1：实现Serializable 接口 （当前对象的引用属性 也需要实现Serializable接口）
				2：具体实现参考 create.pattern.prototypepattern.Shape.deepClone()
				3：如果需要忽略某些属性的克隆，可以在属性前加关键字：transient
		4：克隆不会再次执行构造方法
				
	
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月24日
 * @author xiangning
 * @since JDK1.8
 */
public class PrototypePatternMain {
	
	public static void main(String[] args) {
		Shape shape1 = ShapeCache.getShape("circle");
		shape1.draw();
		shape1.setId(1001L);
		shape1.draw();
		Shape shape2 = ShapeCache.getShape("circle");
		shape2.draw();
		System.out.println("shape1 == shape2  -> " + (shape1 == shape2));
		System.out.println("shape1.getSize() == shape2.getSize() -> " + (shape1.getSize() == shape2.getSize()));
	}

}
