package com.study.algorithm.stack;

import java.util.Scanner;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月20日
 * @author xiangning
 * @since JDK1.8
 */
public class StackUtils {
	
	
	/**
	 * scannerUtils:(验证栈输入专用工具方法)
	 * @author xiangning
	 *
	 * @param stack
	 */
	public static void scannerUtils(StackInterface stack) {
		Scanner scanner = new Scanner(System.in);
		//创建控制台输入
		if(stack == null) {
			System.out.println("请输入您的选择：1、数组栈；2、链表栈");
			
			int type = scanner.nextInt();
			if(type == 1) {
				stack = new ArrayStack(5);
				System.out.println("您选择了数组栈");
			}else {
				stack = new LinkedStack(5);
				System.out.println("您选择了链表栈");
			}
		}
		
		//控制循环输入
		boolean loop = true;
		while(loop) {
			System.out.println("请输入您的选择：");
			System.out.println("\t push：入栈");
			System.out.println("\t pop：出栈");
			System.out.println("\t show：遍历栈");
			System.out.println("\t exit：退出");
			
			String choose = scanner.next();
			switch (choose) {
				case "push":
					System.out.println("请输入数据，必须是整数");
					int data = scanner.nextInt();
					if(stack.push(data)) {
						System.out.println("入栈成功");
					}else {
						System.out.println("入栈失败");
					}
					break;
				case "pop":
					try {
						System.out.printf("出栈数据 -> %d\n",stack.pop());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "show":
					stack.show();
					break;
				case "exit":
					loop = false;
					break;
	
				default:
					System.out.println("输入有误，请重新输入");
			}
		}
		scanner.close();
		System.out.println("程序退出");
	}
}
