package com.factory.pizz.third.entity.product.subclass;

import com.factory.pizz.third.entity.product.Pizza;
import com.factory.pizz.third.factory.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {
	//要制作Pizza, 需要工厂提供原料
	PizzaIngredientFactory ingredientFactory;
 
	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	/**
	 * 关键方法
	 */
	public void prepare() {
		
		/*
		 * 该方法利用相关的工厂生产原料, 所生产的原理依赖于所使用的工厂
		 * Pizza类不关心这些原料是什么, 之知道如何做Pizza
		 * 
		 * 如此, Pizza和区域原料之间被解耦, 无论是那个区域的原料, Pizza类都可以轻易地复用 
		 */
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
	}
}
