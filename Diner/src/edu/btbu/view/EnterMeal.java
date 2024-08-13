package edu.btbu.view;

import edu.btbu.model.catalog.Meal;
import java.util.*;

public class EnterMeal {
//  public Meal inputMeal() throws NumberFormatException{
  public Meal inputMeal(){
    System.out.println("*** 请输入一个菜品信息");
    System.out.println("*** 菜品信息：[英文名],[中文名],[价格],[卡路里]");
    Scanner scanner=new Scanner(System.in);
    String input=scanner.nextLine();
    String[] enteredStrings=input.split(",");
    Meal meal=new Meal();
    meal.setId(enteredStrings[0]);
    meal.setName(enteredStrings[1]);
    try {
      meal.setPrice(Float.parseFloat(enteredStrings[2]));
      meal.setCalorie(Integer.parseInt(enteredStrings[3]));
    }catch(NumberFormatException e) {
      e.printStackTrace();
    }

    return meal;
  }
}
