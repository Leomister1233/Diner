package edu.btbu.model;
public class Cart {
  LineItem[] lineItems=new LineItem[100];
  float total;
  //TODO:
  void add(LineItem lineItem){};
  void delete(String id){};
  void get(String id){};
  void modify(LineItem lineItem){};
}
