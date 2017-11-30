package com.factory.pizz.first.simple.store;

import com.factory.pizz.first.simple.entity.Pizza;
import com.factory.pizz.first.simple.factory.SimplePizzaFactory;

public class PizzaStore {
	SimplePizzaFactory factory;
 
	public PizzaStore(SimplePizzaFactory factory) { 
		this.factory = factory;
	}
 
	public Pizza orderPizza(String type) {
		Pizza pizza;
 
		pizza = factory.createPizza(type);
 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}

