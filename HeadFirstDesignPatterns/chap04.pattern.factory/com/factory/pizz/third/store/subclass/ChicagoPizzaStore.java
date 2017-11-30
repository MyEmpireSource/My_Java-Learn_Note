package com.factory.pizz.third.store.subclass;

import com.factory.pizz.third.entity.product.Pizza;
import com.factory.pizz.third.entity.product.subclass.CheesePizza;
import com.factory.pizz.third.entity.product.subclass.ClamPizza;
import com.factory.pizz.third.entity.product.subclass.PepperoniPizza;
import com.factory.pizz.third.entity.product.subclass.VeggiePizza;
import com.factory.pizz.third.factory.PizzaIngredientFactory;
import com.factory.pizz.third.factory.impl.ChicagoPizzaIngredientFactory;
import com.factory.pizz.third.store.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			//把工厂传递给Pizza, 以便Pizza获取原料
			//各区域店根据自己需要实例化自己的Pizza, 并传递所需的原料工厂
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
}
