package edu.btbu.model;

import edu.btbu.model.catalog.Meal;

public class Meals {
  final int MAX_MEALS = 100;
  private Meal[] meals = null;
  private int lastIndex = 0;
  public Meals() {
    meals = new Meal[MAX_MEALS];
    lastIndex = 0;
  }

  public Meals(Meal[] aMeals) {

    meals = new Meal[MAX_MEALS];
    lastIndex = 0;
    for (int i = 0; i < aMeals.length; i++) {
      if (aMeals[i] != null)
        meals[i] = aMeals[i];
      lastIndex++;
      if (lastIndex == MAX_MEALS)
        System.out.println("WARNING[Meals::Meals(Meal[] aMeals)] full !");
      return;
    }
  }

  public Meal[] getAllMeals() {
    return meals;
  }
  public void add(Meal meal) {
    if (lastIndex == MAX_MEALS) {
      System.out.println("Error[Meals::add()]: No space ! 没地方啦 ！");
      return;
    }
    int idx = find(meal);
    if (idx != -1 && idx!=0) {
      System.out.println("Error[Meals::add()]: Exist ! 已存在 ！");
      return;
    }
    try {
      meals[lastIndex] = meal;
      lastIndex++;
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  public Meal remove(int index) {
    if (lastIndex == 0 && (index < 0 || index >= lastIndex)) return null;
    Meal aMeal = meals[index];
    for (int i = index; i < lastIndex; i++) {
      meals[i] = meals[i + 1];
    }
    meals[lastIndex] = null;
    lastIndex--;
    return aMeal;
  }

  public Meal modify(Meal meal) {
    final int idx = find(meal);
    if (idx == -1) {
      System.out.println("Error[Meals::modify()]: Not Exist ! 已存在 ！");
      return null;
    }
    Meal oldMeal = meals[idx];
    meals[idx] = meal;
    return oldMeal;
  }

  public Meal RetrieveById(String id) {
    int idx = find(id);
    if (idx == -1)
      return null;
    return meals[idx];
  }
  private int find(String id) {
    if (lastIndex == 0) return 0;
    for (int i = 0; i < lastIndex; i++) {
//      if (meals[i].getId().equals(id))
      if (meals[i].getId() == id)
        return i;
    }
    return -1;//没找到
  }
  private int find(Meal meal) {
    return (find(meal.getId()));
  }
}
