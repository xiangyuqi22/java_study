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
