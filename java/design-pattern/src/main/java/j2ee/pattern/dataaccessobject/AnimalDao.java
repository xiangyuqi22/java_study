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
public interface AnimalDao {
	
	public void addAnimal(Animal animal);
	
	public Animal getAnimal(Long id);
	
	public boolean deleteAnimal(Long id);
	
	public boolean updateAnimal(Animal animal);
	
	public List<Animal>  getAllAnimals();

}
