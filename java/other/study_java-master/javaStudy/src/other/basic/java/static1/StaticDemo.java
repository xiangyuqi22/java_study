package other.basic.java.static1;
/**
 * <PRE>
 * �ڲ���   
 * 
 * 		�ڲ���д��̬����,��ǰ�ڲ���Ҳ�����Ǿ�̬��
 * 
 * ��̬�ڲ������ⲿ��ӵ������Ȩ��,���ھ�̬������ʹ�õ�
 * ����
 * 		�Ǿ�̬�ڲ������治��д��̬����
 * 		�Ǿ�̬�ڲ���,���������ⲿ��ľ�̬��������ʹ��,�������󶼲���
 * 
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��5��
 * @author xiangning
 * @since JDK1.8
 */
public class StaticDemo {
	
	
	public static void main(String[] args) {
		System.out.println(A.b);
	}
	

}


class A{
	
	public static B b = B.getB();
	
	public static class B{
			private static B getB() {
				return new B();
			}
		}
}