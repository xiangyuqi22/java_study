package behavior.pattern.memento.main;

import behavior.pattern.memento.Memento;
import behavior.pattern.memento.MementoList;
import behavior.pattern.memento.Originator;

/**
 * <PRE>



	����¼ģʽ
		����¼ģʽ��Memento Pattern������һ�������ĳ��״̬���Ա����ʵ���ʱ��ָ����󡣱���¼ģʽ������Ϊ��ģʽ��
	��ͼ��
		�ڲ��ƻ���װ�Ե�ǰ���£�����һ��������ڲ�״̬�����ڸö���֮�Ᵽ�����״̬��
	��Ҫ�����
		��ν����¼ģʽ�����ڲ��ƻ���װ��ǰ���£�����һ��������ڲ�״̬�����ڸö���֮�Ᵽ�����״̬�������������Ժ󽫶���ָ���ԭ�ȱ����״̬��
	��ʱʹ�ã�
		�ܶ�ʱ������������Ҫ��¼һ��������ڲ�״̬����������Ŀ�ľ���Ϊ�������û�ȡ����ȷ�����ߴ���Ĳ������ܹ��ָ�����ԭ�ȵ�״̬��ʹ������"���ҩ"�ɳԡ�
	��ν����
		ͨ��һ������¼��ר�Ŵ洢����״̬��
	�ؼ����룺
		�ͻ����뱸��¼����ϣ��뱸��¼��������ϡ�
	Ӧ��ʵ���� 
		1�����ҩ�� 2������Ϸʱ�Ĵ浵�� 
		3��Windows ��� ctri + z�� 
		4��IE �еĺ��ˡ� 
		5�����ݿ���������
	�ŵ㣺
		1�����û��ṩ��һ�ֿ��Իָ�״̬�Ļ��ƣ�����ʹ�û��ܹ��ȽϷ���ػص�ĳ����ʷ��״̬�� 
		2��ʵ������Ϣ�ķ�װ��ʹ���û�����Ҫ����״̬�ı���ϸ�ڡ�
	ȱ�㣺
		������Դ�������ĳ�Ա�������࣬�Ʊػ�ռ�ñȽϴ����Դ������ÿһ�α��涼������һ�����ڴ档
	ʹ�ó����� 
		1����Ҫ����/�ָ����ݵ����״̬������ 
		2���ṩһ���ɻع��Ĳ�����
	ע����� 
		1��Ϊ�˷��ϵ�����ԭ�򣬻�Ҫ����һ��������¼���ࡣ 
		2��Ϊ�˽�Լ�ڴ棬��ʹ��ԭ��ģʽ+����¼ģʽ��
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��8��
 * @author xiangning
 * @since JDK1.8
 */
public class MementoMain {
	public static void main(String[] args) {
		
		Originator originator = new Originator();
		MementoList mementoList = new MementoList();
		
		{
			originator.setStatus("one");
			Memento one = originator.saveMeneto();
			mementoList.add(one);
		}
		{
			originator.setStatus("two");
			Memento one = originator.saveMeneto();
			mementoList.add(one);
		}
		{
			originator.setStatus("three");
			Memento one = originator.saveMeneto();
			mementoList.add(one);
		}
		
		System.out.println(mementoList.getMemento(1).getStatus());
	}
}
