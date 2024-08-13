package edu.btbu.view;

import edu.btbu.exception.MealTooMoreException;
import edu.btbu.model.Cart;
import edu.btbu.model.catalog.Catalog;
import edu.btbu.model.catalog.Food;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ordering {
  public String[] choose(Catalog catalog, Cart cart){
    String choose = "";
    int choose2 = 0;
    int quantity = 0;
    String[] myOrders = new String[100];
    int totalOrders = 0;
    Food[] allFoods= catalog.retrieveAll();
    System.out.println("****** 点餐菜单 ******");
    int menuTotal = 0;
    for (menuTotal = 0; menuTotal < allFoods.length; menuTotal++) {
      Food food = allFoods[menuTotal];
      if (food == null) break;
      System.out.println((menuTotal + 1) + ". " + food.getName());
    }
    Pattern p = Pattern.compile("[\u4E00-\u9FA5|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
    do {
      System.out.print("<<< 点餐请输入【菜品号，份数】(回车-结束点餐）: ");
      Scanner scanner2 = new Scanner(System.in);
      choose = scanner2.nextLine();
      Matcher m = p.matcher(choose);
      if (m.find()) { System.out.println("Warning：输入包含汉字符号， 无效点餐 ！"); continue;}
      int l=choose.length();
      if (l==0) break;
      if (l==1 || l==2 || l> 2 && -1==choose.indexOf(',') ){ System.out.println("Warning：格式不对， 无效点餐 ！"); continue;}
      if ( l> 2  && choose.contains(",")) {
        String[] youstrings = choose.split(",");
        try {
          choose2 = Integer.parseInt(youstrings[0]);
          if (choose2>menuTotal) {
            System.out.println("Warning：菜品号超界， 无效点餐 ！");
            continue;
          }
          quantity = Integer.parseInt(youstrings[1]);
          myOrders[totalOrders] = choose2 + "," + quantity;
          totalOrders++;
          System.out.println(">>> 你点了餐：【"+quantity+"份"+allFoods[choose2 - 1].toString() + "】");

        } catch (NumberFormatException e) {
          e.printStackTrace();
        }
      }
    } while (choose.length()!=0);
    if (totalOrders == 0) return null;
    System.out.println("*** 你的点餐结果清单:（共"+totalOrders+"笔）：");
    int c=0; float t=0.0f;
    for (int i = 0; i < totalOrders; i++) {
      try {
        String[] yousOrders = myOrders[i].split(",");
        choose2 = Integer.parseInt(yousOrders[0].trim());
        quantity = Integer.parseInt(yousOrders[1].trim());
        System.out.println(i + 1 + ". 【" + quantity + "份：" + allFoods[choose2 - 1].toString() + "】");
        c+=allFoods[choose2 - 1].getCalorie();
        t+=allFoods[choose2 - 1].getPrice();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    DecimalFormat df=new DecimalFormat("0.00");
    df.setRoundingMode(RoundingMode.HALF_UP);
    System.out.println("总热量：" + c + "; 总价格：" + df.format(t));
    System.out.println("*** 点餐结束 ！");
    try {
      if (totalOrders > 2)
        throw new MealTooMoreException();
    }catch(MealTooMoreException e){
      System.out.println(e.getMessage());
      //     e.printStackTrace();
    }
    return myOrders;
  }
}
