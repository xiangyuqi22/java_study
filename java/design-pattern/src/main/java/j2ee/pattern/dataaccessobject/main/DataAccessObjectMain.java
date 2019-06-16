package j2ee.pattern.dataaccessobject.main;

import j2ee.pattern.dataaccessobject.Animal;
import j2ee.pattern.dataaccessobject.AnimalDao;
import j2ee.pattern.dataaccessobject.AnimalDaoImpl;

/**
 * <PRE>

	数据访问对象模式
		数据访问对象模式（Data Access Object Pattern）或 DAO 模式用于把低级的数据访问 API 或操作从高级的业务服务中分离出来。
		以下是数据访问对象模式的参与者。
		
	数据访问对象接口（Data Access Object Interface） - 
		该接口定义了在一个模型对象上要执行的标准操作。
	数据访问对象实体类（Data Access Object concrete class） - 
		该类实现了上述的接口。该类负责从数据源获取数据，数据源可以是数据库，也可以是 xml，或者是其他的存储机制。
	模型对象/数值对象（Model Object/Value Object） - 
		该对象是简单的 POJO，包含了 get/set 方法来存储通过使用 DAO 类检索到的数据。

 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月15日
 * @author xiangning
 * @since JDK1.8
 */
public class DataAccessObjectMain {
	
	public static void main(String[] args) {
		
		AnimalDao animalDao = new AnimalDaoImpl();
		
		{
			Animal animal = new Animal();
			animal.setId(1001L);
			animal.setAge(1);
			animal.setGender("公");
			animal.setName("小黑");
			animalDao.addAnimal(animal);
		}
		{
			Animal animal = new Animal();
			animal.setId(1002L);
			animal.setAge(2);
			animal.setGender("母");
			animal.setName("小白");
			animalDao.addAnimal(animal);
		}
		{
			Animal animal = new Animal();
			animal.setId(1003L);
			animal.setAge(3);
			animal.setGender("母");
			animal.setName("小白");
			animalDao.addAnimal(animal);
		}
		System.out.println(animalDao.getAllAnimals());
		
		{
			Animal animal = new Animal();
			animal.setId(1003L);
			animal.setName("小紫");
			animal.setAge(4);
			animal.setGender("母");
			boolean updateAnimal = animalDao.updateAnimal(animal);
			System.out.println(updateAnimal);
		}
		System.out.println(animalDao.getAllAnimals());
		{
			Animal animal = animalDao.getAnimal(1001L);
			System.out.println(animal);
		}
		{
			boolean deleteAnimal = animalDao.deleteAnimal(1002L);
		}
		System.out.println(animalDao.getAllAnimals());
	}

}
