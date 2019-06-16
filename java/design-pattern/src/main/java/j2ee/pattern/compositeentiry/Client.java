package j2ee.pattern.compositeentiry;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月14日
 * @author xiangning
 * @since JDK1.8
 */
public class Client {
	
	private CoarseGrainedObject coarseGrainedObject = new CoarseGrainedObject();
	
	public void setData(String data1, String data2) {
		coarseGrainedObject.setData(data1, data2);
	}
	
	public void print() {
		for (int i = 0; i < coarseGrainedObject.getData().length; i++) {
			System.out.println(coarseGrainedObject.getData()[i]);
		}
	}

}
