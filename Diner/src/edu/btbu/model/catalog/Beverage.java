package edu.btbu.model.catalog;

public class Beverage extends Meal{
  private String size;
  private Boolean hot;
  private ICED ice;


  void setHot()
  {
    hot=true;
    System.out.println("微波炉加热。。。");
  }
  void setIce(ICED iced)
  {
    ice=iced;
    System.out.println("加冰量："+iced);
  }
}
