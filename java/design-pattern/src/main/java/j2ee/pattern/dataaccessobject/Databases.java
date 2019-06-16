package j2ee.pattern.dataaccessobject;

import java.util.ArrayList;
import java.util.Iterator;
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
public class Databases {
	
	private List<Animal> animals = new ArrayList<>();
	
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	public Animal getAnimal(Long id) {
		for (Animal animal : animals) {
			if(id.equals(animal.getId())) {
				return animal;
			}
		}
		return null;
	}

	public boolean deleteAnimal(Long id) {
		Iterator<Animal> iterator = animals.iterator();
		while (iterator.hasNext()) {
			Animal next = iterator.next();
			if(id.equals(next.getId())) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public boolean updateAnimal(Animal animal1) {
		Iterator<Animal> iterator = animals.iterator();
		while (iterator.hasNext()) {
			Animal animal = iterator.next();
			if(animal.getId().equals(animal1.getId())) {
				iterator.remove();
				animals.add(animal1);
				return true;
			}
		}
		
		return false;
	}

	public List<Animal> getAllAnimals() {
		return animals;
	}

}
