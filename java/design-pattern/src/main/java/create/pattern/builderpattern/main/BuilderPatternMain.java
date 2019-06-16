package create.pattern.builderpattern.main;

import create.pattern.builderpattern.ChickenBurger;
import create.pattern.builderpattern.Meal;
import create.pattern.builderpattern.MealBuilder;

/**
 * 
 * <PRE>
 * 
 * ѧϰ��ַ��http://www.runoob.com/design-pattern/builder-pattern.html
	
	������ģʽ��Builder Pattern��ʹ�ö���򵥵Ķ���һ��һ��������һ�����ӵĶ���
	�������͵����ģʽ���ڴ�����ģʽ�����ṩ��һ�ִ����������ѷ�ʽ��
	һ�� Builder ���һ��һ���������յĶ��󡣸� Builder ���Ƕ�������������ġ�
	
	��ͼ����һ�����ӵĹ��������ʾ����룬ʹ��ͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ��
	
	��Ҫ�������Ҫ��������ϵͳ�У���ʱ��������"һ�����Ӷ���"�Ĵ�����������ͨ���ɸ������ֵ��Ӷ�����һ�����㷨���ɣ�
	��������ı仯��������Ӷ���ĸ������־��������ž��ҵı仯�����ǽ����������һ����㷨ȴ����ȶ���
	
	��ʱʹ�ã�һЩ������������䣬������Ͼ����仯��ʱ��
	
	��ν���������벻����뿪��
	
	�ؼ����룺�����ߣ��������ṩʵ�������ݣ������������ʵ����������ϵ
	
	Ӧ��ʵ���� 
		1��ȥ�ϵ»������������֡�������ը������ǲ���ģ���������Ǿ����仯�ģ����ɳ���ν��"�ײ�"�� 
		2��JAVA �е� StringBuilder��
	
	�ŵ㣺 
		1�������߶���������չ��
		2�����ڿ���ϸ�ڷ��ա�
	
	ȱ�㣺 
		1����Ʒ�����й�ͬ�㣬��Χ�����ơ� 
		2�����ڲ��仯���ӣ����кܶ�Ľ����ࡣ
	
	ʹ�ó�����
	 	1����Ҫ���ɵĶ�����и��ӵ��ڲ��ṹ�� 
	 	2����Ҫ���ɵĶ����ڲ����Ա����໥������
	
	ע������빤��ģʽ�������ǣ�������ģʽ���ӹ�ע�����װ���˳��
	
	�Լ������ ��
		ĳ����Ʒ��һϵ�е������϶��ɣ���ͬ�������Ϸ������ɲ�ͬ�Ĳ�Ʒ��
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��23��
 * @author xiangning
 * @since JDK1.8
 */
public class BuilderPatternMain {
	
	public static void main(String[] args) {
		
		MealBuilder.builder(1).showItem();
		MealBuilder.builder(2).showItem();
		MealBuilder.builder(3).showItem();
		MealBuilder.builder(4).showItem();
		Meal meal = MealBuilder.builder(14);
		meal.showItem();
		meal.removeItem(ChickenBurger.class , false);
		meal.showItem();
		meal.removeItem(ChickenBurger.class , true);
		meal.showItem();
		ChickenBurger chickenBurger1 = new ChickenBurger();
		ChickenBurger chickenBurger2 = new ChickenBurger();
		meal.addItem(chickenBurger1 , chickenBurger2);
		meal.showItem();
		meal.removeItem(chickenBurger1.getClass(), true);
		meal.showItem();
	}

}
