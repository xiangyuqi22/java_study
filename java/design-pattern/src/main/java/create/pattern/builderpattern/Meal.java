package create.pattern.builderpattern;

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
 * @version 1.0 2019��4��23��
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
			System.out.println(item.name() + "�ļ۸�:" + item.price() + "����װ�ǣ�" + item.packing().packing());
		});
		System.out.println("�ܼ��ǣ�" + price);
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
