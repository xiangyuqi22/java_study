package j2ee.pattern.compositeentiry;
/**
 * <PRE>
 * 
 * 
	���ʵ��ģʽ
	���ʵ��ģʽ��Composite Entity Pattern������ EJB �־û������С�
	һ�����ʵ����һ�� EJB ʵ�� bean�������˶����ͼ�⡣������һ�����ʵ��ʱ���ڲ��������� beans ���Զ����£�
	��Ϊ�������� EJB ʵ�� bean ����ġ����������ʵ�� bean �Ĳ����ߡ�
	
	���ʵ�壨Composite Entity�� - ������Ҫ��ʵ�� bean���������Ǵ����ģ����߿��԰���һ�������ȶ������ڳ����������ڡ�
	�����ȶ���Coarse-Grained Object�� - �ö�������������������Լ����������ڣ�Ҳ�ܹ�������������������ڡ�
	��������Dependent Object�� - ����������һ�������������������ڴ����ȶ���Ķ���
	���ԣ�Strategies�� - ���Ա�ʾ���ʵ�����ʵ�塣


* </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��14��
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
