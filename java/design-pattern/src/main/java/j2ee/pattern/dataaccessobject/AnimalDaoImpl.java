package j2ee.pattern.dataaccessobject;

import java.util.List;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月15日
 * @author xiangning
 * @since JDK1.8
 */
public class AnimalDaoImpl implements AnimalDao {
	
	private Databases Databases = new Databases();

	@Override
	public void addAnimal(Animal animal) {
		Databases.addAnimal(animal);
	}

	@Override
	public Animal getAnimal(Long id) {
		return Databases.getAnimal(id);
	}

	@Override
	public boolean deleteAnimal(Long id) {
		return Databases.deleteAnimal(id);
	}

	@Override
	public boolean updateAnimal(Animal animal) {
		return Databases.updateAnimal(animal);
	}

	@Override
	public List<Animal> getAllAnimals() {
		return Databases.getAllAnimals();
	}

}
