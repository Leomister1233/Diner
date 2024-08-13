package edu.btbu.model.catalog;

import java.util.Date;

/**
 * BaconBurger - 培根-类 继承 BaseBurger 抽象类
 * 添加属性：bacon - 培根数量
 */
public class BaconBurger extends BaseBurger {
private int bacon = 1;

public BaconBurger() {
  this.bacon = 1;
}

public BaconBurger(int bacon) {
  this.bacon = bacon;
}

public BaconBurger(SpicyEnum spicyEnum, int bacon) {
  super(spicyEnum);
  this.bacon = bacon;
}


public BaconBurger(String id, String name, float price, int calorie, boolean forSale, int shelfLife, String LOT, long EXP, SpicyEnum spicyEnum, int bacon) {
  super(id, name, price, calorie, forSale, shelfLife, LOT, EXP, spicyEnum);
  this.bacon = bacon;
}


public BaconBurger(Food food, int shelfLife, String LOT, long EXP, SpicyEnum spicyEnum, int bacon) {
  super(food, shelfLife, LOT, EXP, spicyEnum);
  this.bacon = bacon;
}

public int getBacon() {
  return bacon;
}

public void setBacon(int bacon) {
  this.bacon = bacon;
}

@Override
public String toString() {
  return " \t 【BaconBurger】{" +
             super.toString() +
             "bacon=" + bacon +
             '}';
}
@Override
public void slice() {
  super.slice();
  System.out.println("\t 【BaconBurger】 - slice（）：called  ”培根汉堡“-被理料（切墩）");
}
}
