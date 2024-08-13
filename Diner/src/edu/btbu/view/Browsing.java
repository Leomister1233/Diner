package edu.btbu.view;

import edu.btbu.exception.MealTooMoreException;
import edu.btbu.model.catalog.Catalog;
import edu.btbu.model.catalog.Food;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Browsing {
public String[] browse(Catalog catalog){
	String choose = "";
	int choose2 = 0;
	int quantity = 0;
	String[] myOrders = new String[100];
	int totalOrders = 0;
	Food[] allFoods= catalog.retrieveAll();
	System.out.println("****** 看餐菜单 ******");
	int menuTotal = 0; //有效菜单项数
	for (menuTotal = 0; menuTotal < allFoods.length; menuTotal++) {
		Food food = allFoods[menuTotal];
		if (food == null) break;
		System.out.println((menuTotal + 1) + ". " + food.getName());
	}
//    Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	Pattern p = Pattern.compile("[\u4E00-\u9FA5|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
	do {
		System.out.print("<<< 看餐请输入【菜品号，份数】(回车-结束看餐）: ");
		Scanner scanner2 = new Scanner(System.in);
		choose = scanner2.nextLine();
		Matcher m = p.matcher(choose);
		if (m.find()) { System.out.println("Warning：输入包含汉字符号， 无效看餐 ！"); continue;}
		int l=choose.length();
		if (l==0) break;
		if (l==1 || l==2 || l> 2 && -1==choose.indexOf(',') ){ System.out.println("Warning：格式不对， 无效看餐 ！"); continue;}
		if ( l> 2  && choose.contains(",")) {
			String[] youstrings = choose.split(",");
			try {
				choose2 = Integer.parseInt(youstrings[0]);
				if (choose2>menuTotal) {
					System.out.println("Warning：菜品号超界， 无效看餐 ！");
					continue;
				}
				quantity = Integer.parseInt(youstrings[1]);
				myOrders[totalOrders] = choose2 + "," + quantity;
				totalOrders++;
				Food aFood=allFoods[choose2 - 1];
				System.out.println(">>> 你看了："+quantity+"份【"+aFood.toString() + "】; 总价："+aFood.getPrice()*quantity+", 总热量："+aFood.getCalorie()*quantity);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	} while (choose.length()!=0);
	if (totalOrders == 0) return null;
	System.out.println("*** 你的看餐结果清单:（共"+totalOrders+"笔）：");
	
	int calorieTotal=0; float pricTotal=0.0f;
	for (int i = 0; i < totalOrders; i++) {
		try {
			String[] yousOrders = myOrders[i].split(",");
			choose2 = Integer.parseInt(yousOrders[0].trim());
			quantity = Integer.parseInt(yousOrders[1].trim());
			Food aFood=allFoods[choose2 - 1];
			float priceSubTotal=aFood.getPrice()*quantity;
			int calorieSubTotal=aFood.getCalorie()*quantity;
			System.out.println(quantity+"份【"+aFood.toString() + "】; 总价："+priceSubTotal+", 总热量："+calorieSubTotal);

			pricTotal+=priceSubTotal;
			calorieTotal+=calorieSubTotal;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	DecimalFormat df=new DecimalFormat("0.00");
	df.setRoundingMode(RoundingMode.HALF_UP); //四舍五入
	System.out.println("总热量：" + calorieTotal + "; 总价格：" + df.format(pricTotal));//格式化小数点输出
	System.out.println("*** 看餐结束 ！");
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
