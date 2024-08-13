package edu.btbu.model;

import edu.btbu.model.catalog.Catalog;

public class LineItem {
  String id; //菜品的id
  int amount; //份数
  //Abstract
  boolean packaged;//是否打包带走
  //TODO: 自己写
  public float sunTotal(Catalog catalog){
    return catalog.find(id).getPrice()*amount;
  }
  //TODO: 自己写
  public long calorieTotal(Catalog catalog){
    return (long) catalog.find(id).getCalorie()*amount;
  }
  @Override
  public String toString(){
    return "Select: "+amount+" x "+id; 
  }
}
