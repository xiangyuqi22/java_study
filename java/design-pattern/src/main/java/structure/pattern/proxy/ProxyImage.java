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
public class ProxyImage implements Image {
	
	private String fileName;
	
	private RealImage realImage;
	
	public ProxyImage(String fileName) {
		this.fileName = fileName;
		realImage = new RealImage(fileName);
	}

	@Override
	public void display() {
		realImage.display();
	}
	
	public void loadImage() {
		System.out.println("����ͼƬǰ������ĳЩ����........");
		realImage.loadImage();
		System.out.println("����ͼƬ���ʱ������ĳЩ����........");
	}

}
