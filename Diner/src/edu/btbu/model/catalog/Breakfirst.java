package edu.btbu.model.catalog;

import java.lang.reflect.Array;
import java.util.Arrays;
//派生&组合类
public class Breakfirst extends Meal {
  private Meal compMeal[] = new Meal[10];

  public Breakfirst() {

  }
  void setCompMeal(Meal[] meals) {
    for (int i = 0; i < meals.length; i++) {
      try {
        compMeal[i] = meals[i];
      } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
      }
    }
    int i = 0;
    for (Meal aMeal : meals)
      if (aMeal != null) compMeal[i++] = aMeal;

    System.arraycopy(meals, 0, compMeal, 0, 10);
    compMeal=Arrays.copyOfRange(meals, 0, 10 );
  }
}
