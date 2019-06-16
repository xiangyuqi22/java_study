package structure.pattern.filter.main;

import java.util.ArrayList;
import java.util.List;

import structure.pattern.filter.AndCriteria;
import structure.pattern.filter.Criteria;
import structure.pattern.filter.FemaleCriteria;
import structure.pattern.filter.MaleCriteria;
import structure.pattern.filter.Persion;
import structure.pattern.filter.SingleCriteria;

/**
 * <PRE>
 * ������ģʽ��Filter Pattern�����׼ģʽ��Criteria Pattern����һ�����ģʽ������ģʽ��������Աʹ�ò�ͬ�ı�׼������һ�����
 * ͨ���߼������Խ���ķ�ʽ�����������������������͵����ģʽ���ڽṹ��ģʽ������϶����׼����õ�һ��׼��
 * 
 * ѧϰ��ַ��https://www.runoob.com/design-pattern/filter-pattern.html
 * 
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��27��
 * @author xiangning
 * @since JDK1.8
 */
public class FilterMain {
	
	public static void main(String[] args) {
		List<Persion> persions = new ArrayList<Persion>();
		persions.add(new Persion("�ν�" , "male" , "Single"));
		persions.add(new Persion("��Ӣ" , "male" , "married"));
		persions.add(new Persion("������" , "female" , "married"));
		persions.add(new Persion("¬����" , "male" , "married"));
		persions.add(new Persion("����" , "male" , "Single"));
		persions.add(new Persion("�ֳ�" , "male" , "married"));
		persions.add(new Persion("�����" , "female" , "married"));
		persions.add(new Persion("�˴�ɩ" , "female" , "Single"));
		
		Criteria maleCriteria = new MaleCriteria();
		Criteria femaleCriteria = new FemaleCriteria();
		Criteria singleCriteria = new SingleCriteria();
		AndCriteria andCriteria1 = new AndCriteria(maleCriteria, singleCriteria);
		AndCriteria andCriteria2 = new AndCriteria(new FemaleCriteria(), new SingleCriteria());
		
		
		System.out.println("ˮ䰴��е����ԣ�");
		showPersion(maleCriteria.meetCriteria(persions));
		
		System.out.println("ˮ䰴��е�Ů�ԣ�");
		showPersion(femaleCriteria.meetCriteria(persions));
		
		System.out.println("ˮ䰴��е���ĺú���");
		showPersion(singleCriteria.meetCriteria(persions));
		
		System.out.println("ˮ䰴��е������Ӣ�ۣ�");
		showPersion(andCriteria1.meetCriteria(persions));
		
		System.out.println("ˮ䰴��е����ŮӢ�ۣ�");
		showPersion(andCriteria2.meetCriteria(persions));
		
		
		
		
	}
	
	
	public static void showPersion(List<Persion> persions) {
		persions.forEach((persion) -> {
			System.out.println(persion);
		});
		System.out.println("--------------------------------------- һ���У�" + persions.size() + "λ��");
	}

}
