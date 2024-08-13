package edu.btbu.view;

import edu.btbu.model.catalog.Food;

import java.util.Scanner;

public class InputEntity {
  public Food enterAFood()
  {
    System.out.println("******** 输入一个Meal *********");
    System.out.println("*** 输入格式：【菜品英文名】,【中文名】,【价格】,【卡路里】,【是否上架在售true/false】");
    System.out.print(">>> 请输入：");
    Scanner scanner=new Scanner(System.in);
    String mealString=scanner.nextLine();
    String [] attrString=mealString.split(",");
    Food aFood=new Food();
    aFood.setId(attrString[0]);
    aFood.setName(attrString[1]);
    try {
      aFood.setPrice(Float.parseFloat(attrString[2].trim()));
      aFood.setCalorie(Integer.parseInt(attrString[3].trim()));
      aFood.setForSale(Boolean.parseBoolean(attrString[4].trim()));
    }catch (Exception e){
      System.out.println(e);
      return null;
    }
    return aFood;
  }

}
