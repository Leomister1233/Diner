package edu.btbu.control;

import java.util.Scanner;

public class Control {

  public void ShowMenu() {
    String choose = "0";

    do {
      System.out.println("****** 主菜单 ******");
      System.out.println("0. 退出");
      System.out.println("1. 看餐");
      System.out.println("2. 选餐");
      System.out.println("3. 支付");
      System.out.println("*** 请选择（0-退出）：");
      Scanner scanner = new Scanner(System.in);
      choose = scanner.next();
      switch (choose) {
        case "1":
          ShowMenu2();
          break;
      }
      System.out.println("主菜单选项="+choose);
    } while (!choose.equals("0"));
    System.out.println(">>> 你已经退出选餐系统 ！");
  }

  int ShowMenu2() {
    int choose2 = 0;
    do {
      System.out.println("****** 1.汉堡菜单 ******");
      System.out.println("0. 退出");
      System.out.println("1. 汉堡包");
      System.out.println("2. 吉士汉堡包");
      System.out.println("3. 麦香鸡");
      System.out.println("4. 双层吉士汉堡包");
      System.out.println("*** 请选择(0-退出）：");
      Scanner scanner2 = new Scanner(System.in);
      choose2 = scanner2.nextInt();
    } while (choose2 != 0);
    return choose2;
  }
}
