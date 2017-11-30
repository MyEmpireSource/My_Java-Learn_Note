package com.factory.pizz.first.simple.entity;

public class ClamPizza extends Pizza {
	public ClamPizza() {
		this.name = "Clam Pizza";
		this.dough = "Thin crust";
		this.sauce = "White garlic sauce";
		
		this.toppings.add("Clams");
		this.toppings.add("Grated parmesan cheese");
	}
}
