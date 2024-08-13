package edu.btbu.model.catalog;

import edu.btbu.model.catalog.Food;

public class Catalog {
  final int MAX_FOODS = 100;
  //存放Food类对象的容器
  private Food[] allFoods = null;
  private int total = 0;
  public Catalog() {
    allFoods = new Food[MAX_FOODS];
    total = 0;
  }
  public Catalog(Food[] aFoods) {

    allFoods = new Food[MAX_FOODS];
    total = 0;
    for (int i = 0; i < aFoods.length; i++) {
      if (aFoods[i] != null)
        allFoods[i] = aFoods[i];
      total++;
      if (total == MAX_FOODS)
        System.out.println("WARNING[Foods::Foods(Meal[] aFoods)] full !");
      return;
    }
  }
  public Food[] retrieveForSale() {
    Food[] aryFoods=new Food[total];
    int nForSale=0;
    for (int i = 0; i < total; i++) {
      Food aFood=allFoods[i];
      if (aFood==null) continue;
      if (aFood.getForSale()) aryFoods[i] = aFood;
      nForSale++;
    }
    //生成有效数组（数组长度===元素格式）返回
    Food[] saleFoods=new Food[nForSale];
    for (int i = 0; i < nForSale; i++) {
      saleFoods[i]=aryFoods[i];
    }
    return saleFoods;//返回有效数组（数组.length===元素个数）
  }
  public Food[] retrieveAll() {
    return allFoods;//返回有效数组（数组.length===元素个数）
  }
  public void add(Food food) {
    if (total == MAX_FOODS) {
      System.out.println("Error[Foods::add()]: No space ! 没地方啦 ！");
      return;
    }
    int idx = search(food);
    if (idx != -1 && idx!=0) {
      System.out.println("Error[Foods::add()]: Exist ! 已存在 ！");
      return;
    }
    try {
//      Foods[idx] = food;
      allFoods[total] = food;
      total++;
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }


  public Food remove(int index) {
    if (total == 0 && (index < 0 || index >= total)) return null;
    Food aFood = allFoods[index];
    for (int i = index; i < total; i++) {
      allFoods[i] = allFoods[i + 1];
    }
    allFoods[total] = null;
    total--;
    return aFood;
  }


  public Food update(Food food) {
    final int idx = search(food);
    if (idx == -1) {
      System.out.println("Error[Foods::modify()]: Not Exist ! 已存在 ！");
      return null;
    }
    Food oldFood = allFoods[idx];
    allFoods[idx] = food;
    return oldFood;
  }

  public Food find(String id) {
    int idx = search(id);
    if (idx == -1)
      return null;
    return allFoods[idx];
  }
  private int search(String id) {
    if (total == 0) return 0;
    for (int i = 0; i < total; i++) {
      if (allFoods[i].getName() == id)
        return i;
    }
    return -1;
  }

  private int search(Food food) {
    return (search(food.getName()));
  }
}
