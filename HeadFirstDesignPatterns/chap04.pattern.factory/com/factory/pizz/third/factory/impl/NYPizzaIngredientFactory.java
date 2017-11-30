package com.factory.pizz.third.factory.impl;

import com.factory.pizz.third.entity.ingredients.Cheese;
import com.factory.pizz.third.entity.ingredients.Clams;
import com.factory.pizz.third.entity.ingredients.Dough;
import com.factory.pizz.third.entity.ingredients.Pepperoni;
import com.factory.pizz.third.entity.ingredients.Sauce;
import com.factory.pizz.third.entity.ingredients.Veggies;
import com.factory.pizz.third.entity.ingredients.cheese.impl.ReggianoCheese;
import com.factory.pizz.third.entity.ingredients.clams.impl.FreshClams;
import com.factory.pizz.third.entity.ingredients.dough.impl.ThinCrustDough;
import com.factory.pizz.third.entity.ingredients.pepperoni.impl.SlicedPepperoni;
import com.factory.pizz.third.entity.ingredients.sauce.impl.MarinaraSauce;
import com.factory.pizz.third.entity.ingredients.veggies.impl.Garlic;
import com.factory.pizz.third.entity.ingredients.veggies.impl.Mushroom;
import com.factory.pizz.third.entity.ingredients.veggies.impl.Onion;
import com.factory.pizz.third.entity.ingredients.veggies.impl.RedPepper;
import com.factory.pizz.third.factory.PizzaIngredientFactory;

/**
 * 
 * @Package: com.factory.pizz.third.factory.impl
 * @ClassName: NYPizzaIngredientFactory.java
 *
 * @Description: 具体某地区的原料工厂实现, 对于某地区的原料家族提供符合当地的原料
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月15日 下午3:29:15
 * @UpdateDate: 2017年11月15日 下午3:29:15
 * @Version: V1.0
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
