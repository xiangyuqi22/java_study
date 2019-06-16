package j2ee.pattern.dataaccessobject;

import java.util.List;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��15��
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
