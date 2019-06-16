package behavior.pattern.observer.main;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

import behavior.pattern.observer.BinaryObserver;
import behavior.pattern.observer.HexaObserver;
import behavior.pattern.observer.OctalObserver;
import behavior.pattern.observer.Subject;

/**
 * <PRE>
	
	�۲���ģʽ
		����������һ�Զ��ϵʱ����ʹ�ù۲���ģʽ��Observer Pattern����
		���磬��һ�������޸�ʱ������Զ�֪ͨ�����������󡣹۲���ģʽ������Ϊ��ģʽ��
	
	��ͼ��
		���������һ��һ�Զ��������ϵ����һ�������״̬�����ı�ʱ���������������Ķ��󶼵õ�֪ͨ�����Զ����¡�
	��Ҫ�����
		һ������״̬�ı����������֪ͨ�����⣬����Ҫ���ǵ����ú͵���ϣ���֤�߶ȵ�Э����
	��ʱʹ�ã�
		һ������Ŀ����󣩵�״̬�����ı䣬���е��������󣨹۲��߶��󣩶����õ�֪ͨ�����й㲥֪ͨ��
	��ν����
		ʹ����������������Խ�����������ϵ������
	�ؼ����룺
		�ڳ���������һ�� ArrayList ��Ź۲����ǡ�
	Ӧ��ʵ���� 
		1��������ʱ������ʦ�۲���߱�ۣ�Ȼ��֪ͨ�����������߾��ۡ� 
		2�����μ���������������������캢������������һ��ˮ����һ�����ڹ꣬����ڹ���ǹ۲��ߣ����۲�������ˮ���������
	�ŵ㣺 
		1���۲��ߺͱ��۲����ǳ�����ϵġ� 
		2������һ�״������ơ�
	ȱ�㣺 
		1�����һ�����۲��߶����кܶ��ֱ�Ӻͼ�ӵĹ۲��ߵĻ��������еĹ۲��߶�֪ͨ���Ứ�Ѻܶ�ʱ�䡣 
		2������ڹ۲��ߺ͹۲�Ŀ��֮����ѭ�������Ļ����۲�Ŀ��ᴥ������֮�����ѭ�����ã����ܵ���ϵͳ������ 
		3���۲���ģʽû����Ӧ�Ļ����ù۲���֪�����۲��Ŀ���������ô�����仯�ģ�������ֻ��֪���۲�Ŀ�귢���˱仯��
	ʹ�ó�����
		һ������ģ�����������棬����һ��������������һ�����档����Щ�����װ�ڶ����Ķ�����ʹ���ǿ��Ը��Զ����ظı�͸��á�
		һ������ĸı佫��������һ����������Ҳ�����ı䣬����֪�������ж��ٶ��󽫷����ı䣬���Խ��Ͷ���֮�����϶ȡ�
		һ���������֪ͨ�������󣬶�����֪����Щ������˭��
		��Ҫ��ϵͳ�д���һ����������A�������Ϊ��Ӱ��B����B�������Ϊ��Ӱ��C���󡭡�������ʹ�ù۲���ģʽ����һ����ʽ�������ơ�
	ע����� 
		1��JAVA ���Ѿ����˶Թ۲���ģʽ��֧���ࡣ 
		2������ѭ�����á� 
		3�����˳��ִ�У�ĳһ�۲��ߴ���ᵼ��ϵͳ���ǣ�һ������첽��ʽ��

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��8��
 * @author xiangning
 * @since JDK1.8
 */
public class ObserverMain {
	
	public static void main(String[] args) {
		Subject subject = new Subject();
		
		BinaryObserver  binaryObserver = new BinaryObserver(subject); 
		
		OctalObserver observer = new OctalObserver(subject);
		
		HexaObserver hexaObserver = new HexaObserver(subject);
		
		subject.setStatus(10);
		
		subject.setStatus(300);
		
		
	}

}
