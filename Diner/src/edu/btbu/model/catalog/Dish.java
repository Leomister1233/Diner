package edu.btbu.model.catalog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Dish extends Food {
private int shelfLife;
private String LOT;
private long EXP;

public Dish() {
	shelfLife=0;
	this.LOT = "";
	this.EXP = 0;
}

public Dish(int shelfLife, String LOT, long EXP) {
	this.shelfLife=shelfLife;
	this.LOT = LOT;
	this.EXP = EXP;
}
public Dish(String id, String name,float price, int calorie, boolean forSale, int shelfLife,
            String LOT, long EXP) {
	super(id, name, price, calorie, forSale);
	this.shelfLife = shelfLife;
	this.LOT = LOT;
	this.EXP = EXP;
}

public Dish(Food food, int shelfLife, String LOT, long EXP) {
	super(food);
	this.shelfLife = shelfLife;
	this.LOT = LOT;
	this.EXP = EXP;
}
public Dish(Dish dish ) {
	this.setId(dish.getId());
	setName(dish.getName());
	setPrice(dish.getPrice());
	setCalorie(dish.getCalorie());
	setForSale(dish.getForSale());
	this.shelfLife = dish.getShelfLife();
	this.LOT = dish.getLOT();
	this.EXP = dish.getEXP();
}

public int getShelfLife() {
	return shelfLife;
}

public void setShelfLife(int shelfLife) {
	this.shelfLife = shelfLife;
}
public String getLOT() {
	return LOT;
}

public void setLOT(String LOT) {
	this.LOT = LOT;
}

public long getEXP() {
	return EXP;
}

public void setEXP(long EXP) {
	this.EXP = EXP;
}

@Override
public String toString() {
	return "\t 【Dish】{" +
			       super.toString()+
			       ", shelfLife='" + shelfLife + '\'' +
			       ", LOT='" + LOT + '\'' +
			       ", EXP=" + EXP +
			       '}';
}

@Override
public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	if (!super.equals(o)) return false;
	Dish dish = (Dish) o;
	return shelfLife == dish.shelfLife && Objects.equals(LOT, dish.LOT) && Objects.equals(EXP, dish.EXP);
}

@Override
public int hashCode() {
	return Objects.hash(super.hashCode(), shelfLife, LOT, EXP);
}
public void slice(){
	System.out.println("\t 【Dish】 - slice（）：called  基本”饭菜“ - 被理料（切墩）");
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	LOT = formatter.format(currentTime);
};
public abstract void cook();
}
