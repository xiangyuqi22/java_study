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
public class ColorFactory extends AbstractorFactory {

	@Override
	public IColor getColor(String color) {
		if("BLACK".equals(color)) {
			return new Black();
		}else if("YELLOW".equals(color)) {
			return new Black();
		}else if("BLUE".equals(color)) {
			return new Black();
		}
		throw new NullPointerException("��ѡ������ɫ������");
	}

	@Override
	public IShape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}


}
