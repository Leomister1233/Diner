package edu.btbu.model.catalog;
import java.util.Scanner;
import java.util.Date;

public abstract class BaseBurger extends Dish {
private int beefPatties;
private SpicyEnum spicyEnum;
public BaseBurger() {
	this.spicyEnum = SpicyEnum.NONE;
}
public BaseBurger(SpicyEnum spicyEnum) {
	this.spicyEnum = spicyEnum;
}
public BaseBurger(String id, String name, float price, int calorie, boolean forSale, int shelfLife, String LOT, long EXP, SpicyEnum spicyEnum) {
	super(id, name, price, calorie, forSale, shelfLife, LOT, EXP);
	this.spicyEnum = spicyEnum;
}
public BaseBurger(int shelfLife, String LOT, long EXP, SpicyEnum spicyEnum) {
	super(shelfLife, LOT, EXP);
	this.spicyEnum = spicyEnum;
}
public BaseBurger(Food food, int shelfLife, String LOT, long EXP, SpicyEnum spicyEnum) {
	super(food, shelfLife, LOT, EXP);
	this.spicyEnum = spicyEnum;
}
public int getBeefPatties() {return beefPatties;}
public void setBeefPatties(int beefPatties) {this.beefPatties = beefPatties;}

public SpicyEnum getSpicyEnum() {
	return spicyEnum;
}
public void setSpicyEnum(SpicyEnum spicyEnum) {
	this.spicyEnum = spicyEnum;
}
@Override
public String toString() {
	return "\t 【BaseBurger】{" +
						 super.toString()+
			       "spicyEnum=" + spicyEnum +
			       '}';
}
@Override
public void slice() {
	super.slice();
	System.out.println("\t 【BaseBurger】-slice(): called , ”（基础）汉堡“-被理料（切墩） ！");
}

@Override
public void cook() {
	System.out.println("\t 【BaseBurger】-cook(): called , ”（基础）汉堡“-被烹饪 ！");
}
}
