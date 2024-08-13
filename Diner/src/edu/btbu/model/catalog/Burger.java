package edu.btbu.model.catalog;

public class Burger extends Meal{
  private SPICY spicy;//辣的程度的枚举类型
  public Burger(){
    spicy=SPICY.NONE_SPICY;
  }
  public Burger(SPICY aSpicy){
    spicy=aSpicy;
  }
  public Burger(String id, String name, float price, int calorie, SPICY aSpicy){
    super(id, name, price, calorie);
    this.spicy=aSpicy;
  }
  void setSpicy(SPICY spicy){
    this.spicy=spicy;
  }
}
