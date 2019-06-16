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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：demo</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月2日
 * @author xiangning
 * @since JDK1.8
 */
public class BeanUtils {

	/**
	 * 建议使用 transBeanByAnnotation方法 transBean:(对象属性转换，将A对象的属性赋值给B对象。 前提要求：
	 * 1:如A对象的方法：T getName() 那么B对象的方法需要对应为：setName(T t); 2:A对象T
	 * getName()的返回值类型必须为B对象的参数类型 3:B对象只能接收一个参数 4:传入的最后一个参数没有把它忽略 逻辑： 1：遍历A对象中所有方法
	 * 2：遍历B对象中所有方法 得到方法名进行判断 ： 1：将A对象的方法名getName() 改成 setName();
	 * 2：对比B方法是否含setName() 如果没有，此次循环结束 如果有，继续对比返回值类型。 1：得到A对象getName()的返回值类型
	 * 2：得到B对象setName()的返回值类型 3：判断类型是否一致 如果不一致，此次循环结束 如果一致，将A对象的值赋给B对象
	 * 1：执行调用getName()方法得到返回值 。 2：执行调用setName()方法，完成赋值。 赋值时如果有异常，需要招聘异常。
	 * 
	 * @author xiangning
	 *
	 * @param bean1
	 *            带有参数的对象A
	 * @param bean2
	 *            接收参数的对象B
	 * @param ignores
	 *            忽略转换的属性。参数为字符串数组,可变参数 传入的参数可以为： BeanUtils.transBean(A, B , null);
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
			// throw new ServiceDealException(MessageData.isError("对象属性转换错误"));
		}
	}

	/**
	 * transBeanByAnnotation:(通过注解获对属性值进行转换)
	 * 
	 * @author xiangning
	 *
	 * @param bean1
	 *            带有属性值的对象A
	 * @param bean2
	 *            接收属性值的对象B
	 * @param type
	 *            type = true:ignores指定的属性名才会被赋值
	 *            type = flase：ignores指定的属性名不会被赋值
	 * @param ignores
	 *            传值的属性名，以注解@BeanTrans优先，其次是定义的属性名
	 * 
	 * @throws Exception
	 *             传入的参数可以为： BeanUtils.transBeanByAnnotation(A, B , false, null);
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
						// 如果属性名一样，同时数据类型一样那么就可以将A对象的值赋给B对象
						field2.set(bean2, fieldMap1.get("obj"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new ServiceDealException(MessageData.isError("对象属性转换错误"));
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
