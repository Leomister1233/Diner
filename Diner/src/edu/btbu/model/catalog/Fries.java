package edu.btbu.model.catalog;

public class Fries extends Dish{
private SizeEnum size; //大小号

public Fries( ) {
  this.size = SizeEnum.MEDIUM;
}

public Fries(SizeEnum size) {
  this.size = size;
}

public Fries(int shelfLife, String LOT, long EXP, SizeEnum size) {
  super(shelfLife, LOT, EXP);
  this.size = size;
}

public Fries(String id, String name, float price, int calorie, boolean forSale, int shelfLife, String LOT, long EXP, SizeEnum size) {
  super(id, name, price, calorie, forSale, shelfLife, LOT, EXP);
  this.size = size;
}

public Fries(Food food, int shelfLife, String LOT, long EXP, SizeEnum size) {
  super(food, shelfLife, LOT, EXP);
  this.size = size;
}

public Fries(Dish dish, SizeEnum size) {
  super(dish);
  this.size = size;
}

public SizeEnum getSize() {
  return size;
}

public void setSize(SizeEnum size) {
  this.size = size;
}

@Override
public String toString() {
  return "\t 【Fries】{" +
             super.toString()+
             "size=" + size +
             '}';
}

@Override
public void cook() {
  System.out.println("\t 【Fries】类：cook（） called ！ 薯条 - 被烹饪");
}
}
