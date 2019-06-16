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
public  class ShapeFactory extends AbstractorFactory {

	@Override
	public IShape getShape(final String shape) {
		if("CIRCLE".equals(shape)) {
			return new Circle();
		}else if("SQUARE".equals(shape)) {
			return new Square();
		}else if("RECTANGLE".equals(shape)) {
			return new Rectangle();
		}
		throw new NullPointerException("����ѡ����״������");
	}

	@Override
	public IColor getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}
