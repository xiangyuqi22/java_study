package structure.pattern.proxy;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月3日
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
