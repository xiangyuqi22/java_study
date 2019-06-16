package j2ee.pattern.businessdelegate.main;

import j2ee.pattern.businessdelegate.BusinessDelegate;
import j2ee.pattern.businessdelegate.Client;

/**
 * <PRE>


	业务代表模式（Business Delegate Pattern）用于对表示层和业务层解耦。
	它基本上是用来减少通信或对表示层代码中的业务层代码的远程查询功能。在业务层中我们有以下实体。
	
	客户端（Client） - 表示层代码可以是 JSP、servlet 或 UI java 代码。
	业务代表（Business Delegate） - 一个为客户端实体提供的入口类，它提供了对业务服务方法的访问。
	查询服务（LookUp Service） - 查找服务对象负责获取相关的业务实现，并提供业务对象对业务代表对象的访问。
	业务服务（Business Service） - 业务服务接口。实现了该业务服务的实体类，提供了实际的业务实现逻辑。


 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月13日
 * @author xiangning
 * @since JDK1.8
 */
public class BusinessDelegateMain {
	
	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();
		Client client = new Client(businessDelegate);
		
		businessDelegate.setType("EJB");
		client.doTask();
		
		businessDelegate.setType("");
		client.doTask();
		
		
		
		
	}

}
