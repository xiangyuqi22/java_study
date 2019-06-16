package create.pattern.builderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��23��
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
