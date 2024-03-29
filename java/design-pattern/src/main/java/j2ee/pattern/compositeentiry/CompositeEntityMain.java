package j2ee.pattern.compositeentiry;
/**
 * <PRE>
 * 
 * 
	组合实体模式
	组合实体模式（Composite Entity Pattern）用在 EJB 持久化机制中。
	一个组合实体是一个 EJB 实体 bean，代表了对象的图解。当更新一个组合实体时，内部依赖对象 beans 会自动更新，
	因为它们是由 EJB 实体 bean 管理的。以下是组合实体 bean 的参与者。
	
	组合实体（Composite Entity） - 它是主要的实体 bean。它可以是粗粒的，或者可以包含一个粗粒度对象，用于持续生命周期。
	粗粒度对象（Coarse-Grained Object） - 该对象包含依赖对象。它有自己的生命周期，也能管理依赖对象的生命周期。
	依赖对象（Dependent Object） - 依赖对象是一个持续生命周期依赖于粗粒度对象的对象。
	策略（Strategies） - 策略表示如何实现组合实体。


* </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月14日
 * @author xiangning
 * @since JDK1.8
 */
public class CompositeEntityMain {
	
	public static void main(String[] args) {
		Client client = new Client();
		client.setData("First data1", "First data2");
		client.print();
		client.setData("Second data1", "Second data2");
		client.print();
	}

}
