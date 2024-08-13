package edu.btbu.model.catalog;


public class Ingredient {
	private String type;
	private float amount;

public Ingredient(String type, float amount) {
	this.type = type;
	this.amount = amount;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public float getAmount() {
	return amount;
}

public void setAmount(float amount) {
	this.amount = amount;
}

@Override
public String toString() {
//	return "Ingredient{type='" + type + '\'' + ", weight=" + weight + '}';
	return "\t 【Ingredient】食材类{类型='" + type + '\'' + ", 重量=" + amount + '}';
}
}
