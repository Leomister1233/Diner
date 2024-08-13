package edu.btbu.model.catalog;

public class Recipe {
private String delicacy;
private String steps;

public Recipe(String delicacy, String steps) {
	this.delicacy = delicacy;
	this.steps = steps;
}

public String getDelicacy() {
	return delicacy;
}

public void setDelicacy(String delicacy) {
	this.delicacy = delicacy;
}

public String getSteps() {
	return steps;
}

public void setSteps(String steps) {
	this.steps = steps;
}

@Override
public String toString() {
//	return "Recipe{delicacy='" + delicacy + '\'' + ", steps='" + steps + '\'' + '}';
	return "菜谱{菜名='" + delicacy + '\'' + ", 步骤='" + steps + '\'' + '}';
}
}
