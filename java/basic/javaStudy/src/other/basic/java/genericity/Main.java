package other.basic.java.genericity;

import java.util.ArrayList;
import java.util.List;

import other.basic.java.bean.Animal;
import other.basic.java.bean.Fish;
import other.basic.java.bean.User;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月23日
 * @author xiangning
 * @since JDK1.8
 */
public class Main {
	
	public static void main(String[] args) {
		
		
		MessageData<User, Fish, Animal> messageData = new MessageData<>();
		messageData.setData(User.getUser());
		messageData.setDataE(Fish.getFish());
		messageData.setDataF(Animal.getAnimal());
		
		System.out.println(messageData);
		
		List<String> stringArrayList = new ArrayList<String>();
		List<Integer> integerArrayList = new ArrayList<Integer>();

		Class classStringArrayList = stringArrayList.getClass();
		Class classIntegerArrayList = integerArrayList.getClass();

		if(classStringArrayList.equals(classIntegerArrayList)){
			System.out.println(classStringArrayList);
			System.out.println(classIntegerArrayList);
		    System.out.println("泛型类型相同");
		}
		
		showList(new ArrayList<Object>());
		
		try {
			ArrayList obj = getObj(ArrayList.class);
			
			User user = getObj(User.class);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * showList:(泛型通配符)
	 * @author xiangning
	 *
	 * @param list
	 */
	public static void showList(List<?> list) {
		System.out.println("other.basic.java.genericity.Main.showList(List<Object>)");
	}
	
	public static <T> T getObj(Class<T> tClass) throws InstantiationException, IllegalAccessException {
		T newInstance = tClass.newInstance();
		return newInstance;
	}
	
	

}
