package edu.btbu.model.catalog;

import java.util.Arrays;
import java.util.Date;

public class Meal extends Dish {
private Dish[] dishes;

public Meal() {
	this.dishes = null;
}

public Meal(String id, String name, float price, int calorie, boolean forSale, int shelfLife, String LOT, long EXP, Dish[] dishes) {
	super(id, name, price, calorie, forSale, shelfLife, LOT, EXP);
	this.dishes = dishes;
	setCalorie(calCalorie());
}
public Meal(Dish[] dishes) {
	this.dishes = dishes;
	setCalorie(calCalorie());
}
public Meal(Dish dish , Dish[] dishes) {
	super(dish);
	this.dishes = dishes;
	setCalorie(calCalorie());
}
public Meal(Meal meal ) {

	this.setId(meal.getId());
	setName(meal.getName());
	setPrice(meal.getPrice());
	setCalorie(meal.getCalorie());
	setForSale(meal.getForSale());
	setShelfLife(meal.getShelfLife());
	setLOT(meal.getLOT());
	setEXP(meal.getEXP());
	dishes=meal.dishes;
	setCalorie(calCalorie());
}

	public Meal(String id, String name, float price, int calorie) {
	}

	@Override
public String toString() {
	return "\t 【Meal】{" +
			       super.toString() +
			       "dishes=" + Arrays.toString(dishes) +
			       '}';
}

@Override
public void cook() {
	for (Dish dish: dishes){
		dish.cook();
	}
	System.out.println("\t 【Meal】类含饭菜cook（） 均被called ！ ， 至此：餐-被烹饪！");
}

private String contents() {
	if (dishes == null) return "";
	String sContent = "";
	for (int i = 0; i < dishes.length; i++) {
		sContent += dishes[i].getId() + "(" + dishes[i].getName() + ")";
		if (i < dishes.length - 1) sContent += "、";
	}
	return sContent;
}
private int calCalorie(){
	int c=0;
	for (Dish dish: dishes) c+=dish.getCalorie();
	return c;
}
public void assemble(){
	cook();
	System.out.println("\t 组餐Meal饭菜：[" + contents() + "]");
}
public Dish[] split() {
	System.out.println("\t 分解Meal餐食：[" + contents() + "]");
	return dishes;
}
}
