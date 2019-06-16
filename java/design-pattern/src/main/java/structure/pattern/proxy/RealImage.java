package structure.pattern.proxy;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��3��
 * @author xiangning
 * @since JDK1.8
 */
public class RealImage implements Image {
	
	private String fileName;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}
	
	public void loadImage() {
		System.out.println("Loading " + fileName);
	}

}
