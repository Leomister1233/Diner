package edu.btbu.model.catalog;

import java.util.Date;
public class CheeseBurger extends BaseBurger {
private int cheese = 0;

public CheeseBurger() {
	this.cheese = 1;
}

public CheeseBurger(int cheese) {
	this.cheese = cheese;
}
public CheeseBurger(SpicyEnum spicyEnum, int cheese) {
	super(spicyEnum);
	this.cheese = cheese;
}
public CheeseBurger(String id, String name, float price, int calorie, boolean forSale, int shelfLife, String LOT, long EXP, SpicyEnum spicyEnum, int cheese) {
	super(id, name, price, calorie, forSale, shelfLife, LOT, EXP, spicyEnum);
	this.cheese = cheese;
}
public CheeseBurger(Food food, int shelfLife, String LOT, long EXP, SpicyEnum spicyEnum, int cheese) {
	super(food, shelfLife,  LOT, EXP, spicyEnum);
	this.cheese = cheese;
}

public int getCheese() {
	return cheese;
}

public void setCheese(int cheese) {
	this.cheese = cheese;
}

@Override
public String toString() {
	return "\t 【CheeseBurger】{" +
						 super.toString()+
			       "cheese=" + cheese +
			       '}';
}

@Override
public void slice() {
	super.slice();
	System.out.println("\t 【CheeseBurger】类 slice（） called ！，奶酪汉堡 - 被理料");
}

@Override
public void cook() {
	super.cook();
	System.out.println("\t 【CheeseBurger】类-cook（） called ！，奶酪汉堡 - 被烹饪");
}
}
