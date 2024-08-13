package edu.btbu.exception;

public class MealTooMoreException extends Exception{
  String ExceptionMessage;
  public MealTooMoreException(){
    ExceptionMessage="Exception: 你点的数量太多了！";
  }
  @Override
  public String getMessage()
  {
    return(ExceptionMessage);
  }
}
