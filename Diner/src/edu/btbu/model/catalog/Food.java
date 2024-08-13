package edu.btbu.model.catalog;

import java.util.Objects;

/**
 * Food - 目录Catalog类、基类：实体类、POJO类。（食品是对饭菜的抽象数据，用于上架食品目录类的基类）
 * POJO类 - Plain Ordinary Java Object 类（封装属性，有（缺省）构造方法，并提供属性访问器（getter/setter）。
 * POJO类将来可作为Java-Been类，或用于数据库访问
 */
public class Food {
private String id;
private String name;
private float price;
private int calorie;
private boolean forSale;

{

  price = 0.0f;
  calorie = 0;
  forSale = true;
}

public Food() {
  id = "";
  name = "";
}

public Food(String id, String name) {
  this.id = id;
  this.name = name;
}

public Food(String id, String name, float price, int calorie, boolean forSale) {
  this.id = id;
  this.name = name;
  this.price = price;
  this.calorie = calorie;
  this.forSale = forSale;
}

public Food(Food food) {
  id = food.id;
  name = food.name;
  price = food.price;
  calorie = food.calorie;
  forSale = food.forSale;
}

public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public float getPrice() {
  return price;
}

public void setPrice(float price) {
  if (price < 2.0f)
    System.out.println("\t Warning: Exception low price !");
  this.price = price;
}

public int getCalorie() {
  return calorie;
}

public void setCalorie(int calorie) {
  this.calorie = calorie;
}

public boolean getForSale() {
  return forSale;
}

public void setForSale(boolean forSale) {
  this.forSale = forSale;
}

@Override
public String toString() {
  return "\t 【Food】食品-类：" + id + ":" + "(" + name + "),价格：" + price + ", 卡路里:" + calorie + (forSale ? ", 在售" : ", 已下架");
}

@Override
public boolean equals(Object o) {
  if (this == o) return true;
  if (!(o instanceof Food)) return false;
  Food food = (Food) o;
  return Float.compare(food.getPrice(), getPrice()) == 0 && getCalorie() == food.getCalorie() && getForSale() == food.getForSale() && Objects.equals(getId(), food.getId()) && Objects.equals(getName(), food.getName())
      ;
}

@Override
public int hashCode() {
  return Objects.hash(getId(), getName(), getPrice(), getCalorie(), getForSale());
}
}







