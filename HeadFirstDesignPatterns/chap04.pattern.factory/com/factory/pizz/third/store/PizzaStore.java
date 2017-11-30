package com.factory.pizz.third.store;

import com.factory.pizz.third.entity.product.Pizza;

public abstract class PizzaStore {
	protected abstract Pizza createPizza(String item);
	 
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}