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
public class CoarseGrainedObject {
	
	private DependentObject1 dependentObject1 = new DependentObject1();
	
	private DependentObject2 dependentObject2 = new DependentObject2();
	
	public void setData(String data1 , String data2) {
		dependentObject1.setData(data1);
		dependentObject2.setData(data2);
	}
	
	public String[] getData() {
		return new String[] {dependentObject1.getData(),dependentObject2.getData()};
	}

}
