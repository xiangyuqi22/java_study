package com.study.algorithm.stack;

import java.util.Scanner;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��20��
 * @author xiangning
 * @since JDK1.8
 */
public class StackUtils {
	
	
	/**
	 * scannerUtils:(��֤ջ����ר�ù��߷���)
	 * @author xiangning
	 *
	 * @param stack
	 */
	public static void scannerUtils(StackInterface stack) {
		Scanner scanner = new Scanner(System.in);
		//��������̨����
		if(stack == null) {
			System.out.println("����������ѡ��1������ջ��2������ջ");
			
			int type = scanner.nextInt();
			if(type == 1) {
				stack = new ArrayStack(5);
				System.out.println("��ѡ��������ջ");
			}else {
				stack = new LinkedStack(5);
				System.out.println("��ѡ��������ջ");
			}
		}
		
		//����ѭ������
		boolean loop = true;
		while(loop) {
			System.out.println("����������ѡ��");
			System.out.println("\t push����ջ");
			System.out.println("\t pop����ջ");
			System.out.println("\t show������ջ");
			System.out.println("\t exit���˳�");
			
			String choose = scanner.next();
			switch (choose) {
				case "push":
					System.out.println("���������ݣ�����������");
					int data = scanner.nextInt();
					if(stack.push(data)) {
						System.out.println("��ջ�ɹ�");
					}else {
						System.out.println("��ջʧ��");
					}
					break;
				case "pop":
					try {
						System.out.printf("��ջ���� -> %d\n",stack.pop());
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
					System.out.println("������������������");
			}
		}
		scanner.close();
		System.out.println("�����˳�");
	}
}
