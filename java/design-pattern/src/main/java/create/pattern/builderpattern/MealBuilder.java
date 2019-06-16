package create.pattern.builderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月23日
 * @author xiangning
 * @since JDK1.8
 */
public class MealBuilder {
	
//	private List<String> list = new ArrayList<String>();
	
	
	public static Meal builder(int a) {
		Meal meal = new Meal();
		switch (a) {
			case 1:
				meal.addItem(new VegBurger());
				meal.addItem(new VegBurger());
				meal.addItem(new VegBurger());
				meal.addItem(new Pepsi());
				break;
			case 2:
				meal.addItem(new ChickenBurger());
				meal.addItem(new Coke());
				break;
			case 3:
				meal.addItem(new VegBurger());
				meal.addItem(new Coke());
				break;
			case 4:
				meal.addItem(new ChickenBurger());
				meal.addItem(new Pepsi());
				break;
			default:
				meal.addItem(new VegBurger());
				meal.addItem(new Coke());
				meal.addItem(new ChickenBurger());
				meal.addItem(new ChickenBurger());
				meal.addItem(new ChickenBurger());
				meal.addItem(new ChickenBurger());
				meal.addItem(new ChickenBurger());
				meal.addItem(new Pepsi());
		}
		return meal;
	}
	

}
