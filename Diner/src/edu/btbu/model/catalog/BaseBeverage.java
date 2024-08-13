package edu.btbu.model.catalog;

import java.util.Date;
/**
 * BaseBeverage - 培根-抽象类 继承 Dish 抽象类
 * 添加属性：SizeEnum - 大杯、中杯、小杯
 *          TempEnum - //温度等级
 */
abstract public class BaseBeverage extends Dish {
private SizeEnum size;
private TempEnum temp;

public BaseBeverage() {
	this.size = SizeEnum.MEDIUM;
	this.temp = TempEnum.NORMAL;
}

public BaseBeverage(SizeEnum size, TempEnum temp) {
	this.size = size;
	this.temp = temp;
}

public BaseBeverage(int shelfLife, String LOT, long EXP, SizeEnum size, TempEnum temp) {
	super(shelfLife, LOT, EXP);
	this.size = size;
	this.temp = temp;
}

public BaseBeverage(String id, String name, float price, int calorie, boolean forSale, int shelfLife, String LOT, long EXP, SizeEnum size, TempEnum temp) {
	super(id, name, price, calorie, forSale, shelfLife, LOT, EXP);
	this.size = size;
	this.temp = temp;
}

public BaseBeverage(Food food, int shelfLife, String LOT, long EXP, SizeEnum size, TempEnum temp) {
	super(food, shelfLife, LOT, EXP);
	this.size = size;
	this.temp = temp;
}

public SizeEnum getSize() {
	return size;
}

public void setSize(SizeEnum size) {
	this.size = size;
}

public TempEnum getTemp() {
	return temp;
}

public void setTemp(TempEnum temp) {
	this.temp = temp;
}

@Override
public String toString() {
	return "\t 【BaseBeverage】["+super.toString() +"]{size=" + size + ", temp=" + temp + '}';
}

@Override
public void slice() {
	super.slice();
	System.out.println("\t 【BaseBeverage】类slice（） called ！，（基础）饮料 - 理料");
}

}
