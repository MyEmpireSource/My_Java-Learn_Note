package com.factory.pizz.second.simple.store;

import com.factory.pizz.second.simple.entity.NYStyleCheesePizza;
import com.factory.pizz.second.simple.entity.NYStyleClamPizza;
import com.factory.pizz.second.simple.entity.NYStylePepperoniPizza;
import com.factory.pizz.second.simple.entity.NYStyleVeggiePizza;
import com.factory.pizz.second.simple.entity.Pizza;

public class NYPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}
