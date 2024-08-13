package edu.btbu;

import edu.btbu.model.catalog.*;
import edu.btbu.view.Browsing;

import java.util.Random;

public class Main {
//实例的类成员-变量
public Food[] allFoods = {
    new Food("Fries", "薯条", 6.8f, 228, true),  //在售
    new Food("Hamburger", "汉堡包", 16.8f, 137, true),
    new Food("McChicken", "麦香鸡", 11.8f, 28, true),
    new Food("Sprite", "雪碧", 5.8f, 38, true),
    new Food("Apple Pie", "苹果派", 8.7f, 77, true),
    new Food("Spicy Mc-Wings", "麦辣鸡翅", 26.6f, 126, true),
    new Food("Mutton Sandwich ", "羊肉三明治", 19.7f, 139, false),  //已下架
    new Food("Sausage Egg Biscuit CM", "香肠鸡蛋饼组合餐", 37.6f, 236, true),
};

public static void main(String[] args) {
  Main selfObj=new Main();

  selfObj.lab4_test();
}

private void lab2_test(){
  Catalog catalogs = new Catalog();
  Main main = new Main();
  catalogs.add(main.allFoods[0]);
  catalogs.add(main.allFoods[1]);
  catalogs.add(main.allFoods[2]);
  catalogs.add(main.allFoods[3]);
  catalogs.add(main.allFoods[4]);
  catalogs.add(main.allFoods[5]);
  catalogs.add(main.allFoods[6]);
  catalogs.add(main.allFoods[7]);
    Browsing browsing = new Browsing();
    browsing.browse(catalogs);
}

private void lab4_test(){

  System.out.println();
  System.out.println("=== 测试 CocaCola、 Fries、 BaconBurger、 CheeseBurger 类（重写方法调用过程） =====================");
  Dish[] theDishes = new Dish[4];
  Random random = new Random();
  for (int i = 0; i < 4; i++) {
//      int n=random.nextInt(4);
    int n = i % 4;
    switch (n) {
      case 0:   //Cocacola
        theDishes[i] = new CocaCola("CocaCola", "可口可乐", 3.5f, 78, true, 10, "2021-11-21 21:15:16", System.currentTimeMillis() + 10 * 360000, SizeEnum.MEDIUM, TempEnum.COOL, true);
        break;
      case 1:   //Fries
        theDishes[i] = new Fries("Fries", "薯条", 2.5f, 128, true, 8, "2021-11-21 21:15:17", System.currentTimeMillis() + 8 * 360000, SizeEnum.BIG);
        break;
      case 2:   //BaconBurger
        theDishes[i] = new BaconBurger("BaconBurger", "培根汉堡", 7.5f, 198, true, 7, "2021-11-21 21:15:18", System.currentTimeMillis() + 7 * 360000, SpicyEnum.MEDIUM, 3);
        break;
      case 3:   //CheeseBurger
        theDishes[i] = new CheeseBurger("CheeseBurger", "奶酪汉堡", 8.7f, 218, true, 11, "2021-11-21 21:15:19", System.currentTimeMillis() + 11 * 360000, SpicyEnum.MEDIUM, 2);
        break;
      default:
        theDishes[i] = new Fries("CocaCola", "薯条", 2.5f, 128, true, 8, "2021-11-21 21:15:17", System.currentTimeMillis() + 8 * 360000, SizeEnum.BIG);
        break;
    }
  }
  System.out.println();
  System.out.println("*** 测试： 理料-slice() - 方法 *** 体会 “动态绑定”  ***");
  for (int i = 0; i < theDishes.length; i++) {
    System.out.println("  >>> " + i + ": " + theDishes[i].getClass().toString() + " 类 >>>>>>");
    theDishes[i].slice();
  }
  System.out.println();
  System.out.println("*** 测试： 烹饪-cook() - 方法  *** 体会 “动态绑定”  ***");
  for (int i = 0; i < theDishes.length; i++) {
    System.out.println("  >>> " + i + ": " + theDishes[i].getClass().toString() + " 类 >>>>>>");
    theDishes[i].cook();
  }
  System.out.println();
  System.out.println("=== 测试： Meal 类 （“类组合“方式重用）” =========================================================");
  System.out.println();
  Dish[] someDishes = {
      new CocaCola("CocaCola", "可口可乐", 3.5f, 78, true, 10, "2021-11-21 21:15:16", System.currentTimeMillis() + 10 * 360000, SizeEnum.MEDIUM, TempEnum.COOL, true),
      new Fries("CocaCola", "薯条", 2.5f, 128, true, 8, "2021-11-21 21:15:17", System.currentTimeMillis() + 8 * 360000, SizeEnum.BIG),
      new BaconBurger("BaconBurger", "培根汉堡", 7.5f, 198, true, 7, "2021-11-21 21:15:18", System.currentTimeMillis() + 7 * 360000, SpicyEnum.MEDIUM, 3)
  };
  Meal meal = new Meal(someDishes);
  System.out.println(" ### 调用 meal.assemble() ## 开始 ##");
  meal.assemble();
  System.out.println(" ### 调用 meal.assemble() ## 结束 ##");
  System.out.println();
  System.out.println(" %%% 直接打印 meal.split() 返回的数组 %%");
  Dish[] splitDishes = meal.split();
  splitDishes.toString();
}
}
