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
public interface AnimalDao {
	
	public void addAnimal(Animal animal);
	
	public Animal getAnimal(Long id);
	
	public boolean deleteAnimal(Long id);
	
	public boolean updateAnimal(Animal animal);
	
	public List<Animal>  getAllAnimals();

}
