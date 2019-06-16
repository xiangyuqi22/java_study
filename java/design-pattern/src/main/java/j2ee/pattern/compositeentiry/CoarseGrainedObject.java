package j2ee.pattern.compositeentiry;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��14��
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
