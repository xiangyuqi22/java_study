package create.pattern.abstractfactorypattern;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��17��
 * @author xiangning
 * @since JDK1.8
 */
public class FactoryProducer {
	
	public static AbstractorFactory getFactory(String choice) {
		if("SHAPE".equals(choice)) {
			return new ShapeFactory();
		}else if("COLOR".equals(choice)) {
			return new ColorFactory();
		}
		throw new NullPointerException("��ѡ������ʽ�����ڣ�");
	}
	
	

}
