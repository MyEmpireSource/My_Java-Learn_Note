package com.factory.pizz.first.simple.test;

import com.factory.pizz.first.simple.entity.Pizza;
import com.factory.pizz.first.simple.factory.SimplePizzaFactory;
import com.factory.pizz.first.simple.store.PizzaStore;

public class PizzaTestDrive {
	 
	public static void main(String[] args) {
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);

		// 把new操作符替换为Factory对象的操作方法, 不再使用具体实例化
		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
	}
}
