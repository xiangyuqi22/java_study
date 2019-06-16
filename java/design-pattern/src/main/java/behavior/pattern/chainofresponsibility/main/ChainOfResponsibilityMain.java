package behavior.pattern.chainofresponsibility.main;

import behavior.pattern.chainofresponsibility.AbstractLogger;
import behavior.pattern.chainofresponsibility.DebugLogger;
import behavior.pattern.chainofresponsibility.ErrorLogger;
import behavior.pattern.chainofresponsibility.InfoLogger;

/**
 * <PRE>
	������ģʽ
		����˼�壬������ģʽ��Chain of Responsibility Pattern��Ϊ���󴴽���һ�������߶��������
		����ģʽ������������ͣ�������ķ����ߺͽ����߽��н���������͵����ģʽ������Ϊ��ģʽ��
		������ģʽ�У�ͨ��ÿ�������߶���������һ�������ߵ����á�
		���һ�������ܴ����������ô�������ͬ�����󴫸���һ�������ߣ���������

	��ͼ��
		������������������������һ���ö�������п��ܽ������󣬽���Щ�������ӳ�һ����������������������������ֱ���ж�������Ϊֹ��
	
	��Ҫ�����
		ְ�����ϵĴ����߸��������󣬿ͻ�ֻ��Ҫ�������͵�ְ�����ϼ��ɣ������������Ĵ���ϸ�ں�����Ĵ��ݣ�����ְ����������ķ����ߺ�����Ĵ����߽����ˡ�
	
	��ʱʹ�ã�
		�ڴ�����Ϣ��ʱ���Թ��˺ܶ����
	
	��ν����
		���ص��඼ʵ��ͳһ�ӿڡ�
	
	�ؼ����룺
		Handler ����ۺ����Լ����� HandlerRequest ���ж��Ƿ���ʣ����û�ﵽ���������´��ݣ���˭����֮ǰ set ��ȥ��
	
	Ӧ��ʵ���� 
		1����¥���е�"���Ĵ���"�� 
		2��JS �е��¼�ð�ݡ� 
		3��JAVA WEB �� Apache Tomcat �� Encoding �Ĵ���Struts2 ����������jsp servlet �� Filter��
		
	�ŵ㣺 
		1��������϶ȡ���������ķ����ߺͽ����߽�� 
		2�����˶���ʹ�ö�����Ҫ֪�����Ľṹ�� 
		3����ǿ������ָ��ְ�������ԡ�ͨ���ı����ڵĳ�Ա���ߵ������ǵĴ�������̬����������ɾ�����Ρ� 
		4�������µ���������ܷ��㡣
	
	ȱ�㣺 
		1�����ܱ�֤����һ�������ա� 
		2��ϵͳ���ܽ��ܵ�һ��Ӱ�죬�����ڽ��д������ʱ��̫���㣬���ܻ����ѭ�����á� 
		3�����ܲ����׹۲�����ʱ���������а��ڳ���
	
	ʹ�ó����� 
		1���ж��������Դ���ͬһ�����󣬾����ĸ������������������ʱ���Զ�ȷ���� 
		2���ڲ���ȷָ�������ߵ�����£����������е�һ���ύһ������ 
		3���ɶ�ָ̬��һ�����������
	
	ע�����
	�� JAVA WEB �������ܶ�Ӧ�á�
	
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��6��
 * @author xiangning
 * @since JDK1.8
 */
public class ChainOfResponsibilityMain {
	

	public static void main(String[] args) {
		
		AbstractLogger logger = getLogger();
		
		logger.showMessage(AbstractLogger.DEBUG, "  ->  ��ӡdebug���ϵ���Ϣ");
		System.out.println("--------------------------------------------");
		logger.showMessage(AbstractLogger.ERROR, "  ->  ��ӡerror���ϵ���Ϣ");
		System.out.println("--------------------------------------------");
		logger.showMessage(AbstractLogger.INFO, "  ->  ��ӡinfo���ϵ���Ϣ");
		
	}
	
	
	public static AbstractLogger getLogger() {
		AbstractLogger errorLogger = new ErrorLogger(null, AbstractLogger.ERROR);
		AbstractLogger debugLogger = new DebugLogger(errorLogger, AbstractLogger.DEBUG);
		AbstractLogger infoLogger = new InfoLogger(debugLogger, AbstractLogger.INFO);
		
		return infoLogger;
	}

}
