package com.factory.pizz.second.simple.store;

import com.factory.pizz.second.simple.entity.ChicagoStyleCheesePizza;
import com.factory.pizz.second.simple.entity.ChicagoStyleClamPizza;
import com.factory.pizz.second.simple.entity.ChicagoStylePepperoniPizza;
import com.factory.pizz.second.simple.entity.ChicagoStyleVeggiePizza;
import com.factory.pizz.second.simple.entity.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
