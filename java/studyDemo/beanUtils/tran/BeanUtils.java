package beanUtils.tran;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beanUtils.annotation.BeanTrans;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�demo</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��2��
 * @author xiangning
 * @since JDK1.8
 */
public class BeanUtils {

	/**
	 * ����ʹ�� transBeanByAnnotation���� transBean:(��������ת������A��������Ը�ֵ��B���� ǰ��Ҫ��
	 * 1:��A����ķ�����T getName() ��ôB����ķ�����Ҫ��ӦΪ��setName(T t); 2:A����T
	 * getName()�ķ���ֵ���ͱ���ΪB����Ĳ������� 3:B����ֻ�ܽ���һ������ 4:��������һ������û�а������� �߼��� 1������A���������з���
	 * 2������B���������з��� �õ������������ж� �� 1����A����ķ�����getName() �ĳ� setName();
	 * 2���Ա�B�����Ƿ�setName() ���û�У��˴�ѭ������ ����У������Աȷ���ֵ���͡� 1���õ�A����getName()�ķ���ֵ����
	 * 2���õ�B����setName()�ķ���ֵ���� 3���ж������Ƿ�һ�� �����һ�£��˴�ѭ������ ���һ�£���A�����ֵ����B����
	 * 1��ִ�е���getName()�����õ�����ֵ �� 2��ִ�е���setName()��������ɸ�ֵ�� ��ֵʱ������쳣����Ҫ��Ƹ�쳣��
	 * 
	 * @author xiangning
	 *
	 * @param bean1
	 *            ���в����Ķ���A
	 * @param bean2
	 *            ���ղ����Ķ���B
	 * @param ignores
	 *            ����ת�������ԡ�����Ϊ�ַ�������,�ɱ���� ����Ĳ�������Ϊ�� BeanUtils.transBean(A, B , null);
	 *            BeanUtils.transBean(A, B , ""); BeanUtils.transBean(A, B , "age");
	 *            BeanUtils.transBean(A, B , "age","name"); BeanUtils.transBean(A, B
	 *            , new String[0]);
	 * @throws Exception
	 */
	@Deprecated
	public static void transBeanByMethodName(Object bean1, Object bean2, String... ignores) {
		Method[] methods1 = bean1.getClass().getDeclaredMethods();
		Method[] methods2 = bean2.getClass().getDeclaredMethods();
		try {
			for (Method method1 : methods1) {
				String methodName1 = method1.getName();
				if (!methodName1.startsWith("get")) {
					continue;
				}
				for (Method method2 : methods2) {
					String methodName2 = method2.getName();
					boolean flag = false;
					if (!methodName2.startsWith("set")) {
						flag = true;
						;
					}
					String tempMethodName2 = methodName2.replace("set", "").toLowerCase();
					if (ignores != null) {
						for (int i = 0; i < ignores.length; i++) {
							if (tempMethodName2.equals(ignores[i].toLowerCase())) {
								flag = true;
							}
						}
					}
					if (flag) {
						continue;
					}
					if (methodName1.replaceFirst("get", "set").equals(methodName2)) {
						Type type = method1.getGenericReturnType();
						Type[] paramTypes = method2.getGenericParameterTypes();
						if (paramTypes.length > 1) {
							continue;
						}
						// System.out.println(paramTypes[0].getName());
						if (type.getTypeName().equals(paramTypes[0].getTypeName())) {
							Object obj = method1.invoke(bean1);
							method2.invoke(bean2, obj);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new ServiceDealException(MessageData.isError("��������ת������"));
		}
	}

	/**
	 * transBeanByAnnotation:(ͨ��ע��������ֵ����ת��)
	 * 
	 * @author xiangning
	 *
	 * @param bean1
	 *            ��������ֵ�Ķ���A
	 * @param bean2
	 *            ��������ֵ�Ķ���B
	 * @param type
	 *            type = true:ignoresָ�����������Żᱻ��ֵ
	 *            type = flase��ignoresָ�������������ᱻ��ֵ
	 * @param ignores
	 *            ��ֵ������������ע��@BeanTrans���ȣ�����Ƕ����������
	 * 
	 * @throws Exception
	 *             ����Ĳ�������Ϊ�� BeanUtils.transBeanByAnnotation(A, B , false, null);
	 *             BeanUtils.transBeanByAnnotation(A, B , false, "");
	 *             BeanUtils.transBeanByAnnotation(A, B , false, "age");
	 *             BeanUtils.transBeanByAnnotation(A, B , true, "age","name");
	 *             BeanUtils.transBeanByAnnotation(A, B , false, new String[0]);
	 */
	public static void transBeanByAnnotation(Object bean1, Object bean2, boolean type, String... ignores) {
		Field[] fields1 = bean1.getClass().getDeclaredFields();
		Field[] fields2 = bean2.getClass().getDeclaredFields();
		List<Map<Field, Object>> list1 = new ArrayList<Map<Field, Object>>();
		try {
			for (Field field1 : fields1) {
				Map<String, Object> fieldMap1 = BeanUtils.getFieldInfo(field1, bean1);
				if (fieldMap1.get("obj") == null) {
					continue;
				}
				boolean flag1 = true;
				boolean flag2 = false;
				if (ignores != null) {
					for (String string : ignores) {
						if (fieldMap1.get("name").equals(string)) {
							if (type) {
								flag1 = false;
							} else {
								flag2 = true;
							}
						}
					}
				}
				if ((type && flag1) || (type == false && flag2)) {
					continue;
				}
				for (Field field2 : fields2) {
					Map<String, Object> fieldMap2 = BeanUtils.getFieldInfo(field2, bean2);
					if (fieldMap1.get("name").equals(fieldMap2.get("name"))
							&& fieldMap1.get("typeName").equals(fieldMap2.get("typeName"))) {
						// ���������һ����ͬʱ��������һ����ô�Ϳ��Խ�A�����ֵ����B����
						field2.set(bean2, fieldMap1.get("obj"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new ServiceDealException(MessageData.isError("��������ת������"));
		}
	}

	private static Map getFieldInfo(Field field, Object bean) throws Exception {
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		field.setAccessible(true);
		String fieldName = field.getName();
		Object value = field.get(bean);
		String typeName = field.getGenericType().getTypeName();
		if (field.isAnnotationPresent(BeanTrans.class)) {
			BeanTrans annotation = field.getAnnotation(BeanTrans.class);
			fieldName = annotation.value();
		}
		fieldMap.put("name", fieldName);
		fieldMap.put("obj", value);
		fieldMap.put("typeName", typeName);
		return fieldMap;
	}

}
