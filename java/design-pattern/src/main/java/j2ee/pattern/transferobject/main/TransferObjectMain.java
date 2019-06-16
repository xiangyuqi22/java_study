package j2ee.pattern.transferobject.main;

import j2ee.pattern.transferobject.StudentBO;
import j2ee.pattern.transferobject.StudentVO;

/**
 * <PRE>

	�������ģʽ
	�������ģʽ��Transfer Object Pattern�����ڴӿͻ����������һ���Դ��ݴ��ж�����Ե����ݡ�
	�������Ҳ����Ϊ��ֵ���󡣴��������һ������ getter/setter �����ļ򵥵� POJO �࣬
	���ǿ����л��ģ�����������ͨ�����紫�䡣��û���κε���Ϊ���������˵�ҵ����ͨ�������ݿ��ȡ���ݣ�
	Ȼ����� POJO�����������͵��ͻ��˻�ֵ�����������ڿͻ��ˣ����������ֻ���ġ��ͻ��˿��Դ����Լ��Ĵ������
	���������ݸ����������Ա�һ���Ը������ݿ��е���ֵ���������������ģʽ��ʵ�塣
	
	ҵ�����Business Object�� 
		- Ϊ�������������ݵ�ҵ�����
	�������Transfer Object�� 
		- �򵥵� POJO��ֻ������/��ȡ���Եķ�����
	�ͻ��ˣ�Client�� 
		- �ͻ��˿��Է���������߷��ʹ������ҵ�����



 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��19��
 * @author xiangning
 * @since JDK1.8
 */
public class TransferObjectMain {
	
	public static void main(String[] args) {
		StudentBO studentBO = new StudentBO();
		System.out.println(studentBO.getStudentVOs());
		
	}

}
