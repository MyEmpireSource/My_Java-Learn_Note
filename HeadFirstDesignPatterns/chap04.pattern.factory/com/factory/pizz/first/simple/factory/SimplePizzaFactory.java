package com.factory.pizz.first.simple.factory;

import com.factory.pizz.first.simple.entity.CheesePizza;
import com.factory.pizz.first.simple.entity.ClamPizza;
import com.factory.pizz.first.simple.entity.PepperoniPizza;
import com.factory.pizz.first.simple.entity.Pizza;
import com.factory.pizz.first.simple.entity.VeggiePizza;

public class SimplePizzaFactory {
	
	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}
}
