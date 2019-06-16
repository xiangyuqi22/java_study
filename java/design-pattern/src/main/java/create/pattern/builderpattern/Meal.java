package create.pattern.builderpattern;

import java.util.ArrayList;
import java.util.Iterator;
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
public class Meal {
	
	private List<Item> itemList = new ArrayList<Item>();
	
	private float price;
	
	
	public void addItem(Item... item) {
		for (Item item1 : item) {
			price += item1.price();
			itemList.add(item1);
		}
	}
	
	public void showItem() {
		itemList.forEach((item) -> {
			System.out.println(item.name() + "的价格:" + item.price() + "；包装是：" + item.packing().packing());
		});
		System.out.println("总价是：" + price);
		System.out.println("---------------------------------------");
	}
	
	public void removeItem(Class cla , boolean isAll) {
		Iterator<Item> iterator = itemList.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			if(item.getClass().equals(cla)) {
				iterator.remove();
				price -= item.price();
				if(!isAll) {
					break;
				}
			}
		}
		
		
	}
	
}
