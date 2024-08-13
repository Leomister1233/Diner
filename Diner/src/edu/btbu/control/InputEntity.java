package edu.btbu.control;

import edu.btbu.model.catalog.Meal;

import java.util.Scanner;

public class InputEntity {
  public Meal InputAMeal()
  {
    System.out.println("******** 输入一个Meal *********");
    System.out.println("*** 输入格式：【菜品英文名】，【中文名】，【价格】，【卡路里】");
    System.out.print(">>> 请输入：");
    Scanner scanner=new Scanner(System.in);
    String mealString=scanner.nextLine();
    String [] attrString=mealString.split(",");
    Meal aMeal=new Meal();
    aMeal.setId(attrString[0]);
    aMeal.setName(attrString[1]);
    try {
      aMeal.setPrice(Float.parseFloat(attrString[2].trim()));
      aMeal.setCalorie(Integer.parseInt(attrString[3].trim()));
    }catch (Exception e){
      System.out.println(e);
      return null;
    }
    return aMeal;
  }

}
