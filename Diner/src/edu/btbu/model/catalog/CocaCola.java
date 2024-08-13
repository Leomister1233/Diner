package edu.btbu.model.catalog;

import java.util.Date;

public class CocaCola extends BaseBeverage{
private boolean isIce; //是否加冰

public CocaCola( ) {
  this.isIce = false;
}
public CocaCola(boolean isIce) {
  this.isIce = isIce;
}

public CocaCola(SizeEnum size, TempEnum temp, boolean isIce) {
  super(size, temp);
  this.isIce = isIce;
}

public CocaCola(int shelfLife, String LOT, long EXP, SizeEnum size, TempEnum temp, boolean isIce) {
  super(shelfLife, LOT, EXP, size, temp);
  this.isIce = isIce;
}

public CocaCola(String id, String name, float price, int calorie, boolean forSale, int shelfLife, String LOT, long EXP, SizeEnum size, TempEnum temp, boolean isIce) {
  super(id, name, price, calorie, forSale, shelfLife, LOT, EXP, size, temp);
  this.isIce = isIce;
}

public CocaCola(Food food, int shelfLife, String LOT, long EXP, SizeEnum size, TempEnum temp, boolean isIce) {
  super(food, shelfLife, LOT, EXP, size, temp);
  this.isIce = isIce;
}

@Override
public String toString() {
  return "\t 【CocaCola】{" +
             super.toString()+
             "isIce=" + isIce +
             '}';
}

//子类不再定义，直接使用基类slice（）方法
//@Override
//public void slice() {super.slice();}

//基类BaseBeverage类没定义，子类重写cook（）方法
@Override
public void cook() {
  System.out.println("\t 【CocaCola】类-cook(): called ! 可口可乐 - 被烹饪");
}
}
