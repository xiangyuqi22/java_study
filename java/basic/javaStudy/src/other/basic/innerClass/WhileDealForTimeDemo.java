package other.basic.innerClass;

import other.basic.innerClass.WhileDealForTime.Deal;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月1日
 * @author xiangning
 * @since JDK1.8
 */
public class WhileDealForTimeDemo {
	
	public static void main(String[] args) {
		System.out.println("开始");
		
		
		new WhileDealForTime(5000,500,new Deal() {
			int time = 0;
			@Override
			public boolean whileDeal() {
				System.out.println("循环执行时处理");
				if(++time == 3) {
					//最多循环5次就中断执行
					return false;
				}
				return true;
			}
			@Override
			public void before() {
				System.out.println("循环执行前");
			}
			@Override
			public void after() {
				System.out.println("循环执行后");
			}
			
		});//每500毫秒执行一次
		System.out.println("结束");
		
		
		
		System.out.println("局部内部类-------------------------------------");
		
		/**
		 * <PRE>
		 * 局部内部类
		 * </PRE>
		 *
		 * 项目名称：javaStudy</BR>
		 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
		 * 
		 * @version 1.0 2019年6月1日
		 * @author xiangning
		 * @since JDK1.8
		 */
		class InnerDealClass implements Deal{

			@Override
			public boolean whileDeal() {
				System.out.println("循环执行局部内部类");
				return true;
			}
			
		}
		
		new WhileDealForTime(1000,300,new InnerDealClass());
		
		
	}

}
