package j2ee.pattern.dataaccessobject.main;

import j2ee.pattern.dataaccessobject.Animal;
import j2ee.pattern.dataaccessobject.AnimalDao;
import j2ee.pattern.dataaccessobject.AnimalDaoImpl;

/**
 * <PRE>

	���ݷ��ʶ���ģʽ
		���ݷ��ʶ���ģʽ��Data Access Object Pattern���� DAO ģʽ���ڰѵͼ������ݷ��� API ������Ӹ߼���ҵ������з��������
		���������ݷ��ʶ���ģʽ�Ĳ����ߡ�
		
	���ݷ��ʶ���ӿڣ�Data Access Object Interface�� - 
		�ýӿڶ�������һ��ģ�Ͷ�����Ҫִ�еı�׼������
	���ݷ��ʶ���ʵ���ࣨData Access Object concrete class�� - 
		����ʵ���������Ľӿڡ����ฺ�������Դ��ȡ���ݣ�����Դ���������ݿ⣬Ҳ������ xml�������������Ĵ洢���ơ�
	ģ�Ͷ���/��ֵ����Model Object/Value Object�� - 
		�ö����Ǽ򵥵� POJO�������� get/set �������洢ͨ��ʹ�� DAO ������������ݡ�

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��15��
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
			animal.setGender("��");
			animal.setName("С��");
			animalDao.addAnimal(animal);
		}
		{
			Animal animal = new Animal();
			animal.setId(1002L);
			animal.setAge(2);
			animal.setGender("ĸ");
			animal.setName("С��");
			animalDao.addAnimal(animal);
		}
		{
			Animal animal = new Animal();
			animal.setId(1003L);
			animal.setAge(3);
			animal.setGender("ĸ");
			animal.setName("С��");
			animalDao.addAnimal(animal);
		}
		System.out.println(animalDao.getAllAnimals());
		
		{
			Animal animal = new Animal();
			animal.setId(1003L);
			animal.setName("С��");
			animal.setAge(4);
			animal.setGender("ĸ");
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
