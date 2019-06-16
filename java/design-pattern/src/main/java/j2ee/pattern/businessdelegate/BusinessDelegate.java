package j2ee.pattern.businessdelegate;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��13��
 * @author xiangning
 * @since JDK1.8
 */
public class BusinessDelegate {
	
	private BusinessLookup businessLookup;
	private BusinessService businessService;
	
	public BusinessDelegate() {
		this.businessLookup = new BusinessLookup();
	}
	
	public void setType(String type) {
		businessService = this.businessLookup.lookup(type);
	}
	
	
	public void doTask() {
		businessService.doProcessing();
		businessService.doSomething();
	}
	

}
