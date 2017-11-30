package com.factory.pizz.third.factory.impl;

import com.factory.pizz.third.entity.ingredients.Cheese;
import com.factory.pizz.third.entity.ingredients.Clams;
import com.factory.pizz.third.entity.ingredients.Dough;
import com.factory.pizz.third.entity.ingredients.Pepperoni;
import com.factory.pizz.third.entity.ingredients.Sauce;
import com.factory.pizz.third.entity.ingredients.Veggies;
import com.factory.pizz.third.entity.ingredients.cheese.impl.MozzarellaCheese;
import com.factory.pizz.third.entity.ingredients.clams.impl.FrozenClams;
import com.factory.pizz.third.entity.ingredients.dough.impl.ThickCrustDough;
import com.factory.pizz.third.entity.ingredients.pepperoni.impl.SlicedPepperoni;
import com.factory.pizz.third.entity.ingredients.sauce.impl.PlumTomatoSauce;
import com.factory.pizz.third.entity.ingredients.veggies.impl.BlackOlives;
import com.factory.pizz.third.entity.ingredients.veggies.impl.Eggplant;
import com.factory.pizz.third.entity.ingredients.veggies.impl.Spinach;
import com.factory.pizz.third.factory.PizzaIngredientFactory;

/**
 * 
 * @Package: com.factory.pizz.third.factory.impl
 * @ClassName: ChicagoPizzaIngredientFactory.java
 *
 * @Description: 具体某地区的原料工厂实现, 对于某地区的原料家族提供符合当地的原料
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月15日 下午3:32:39
 * @UpdateDate: 2017年11月15日 下午3:32:39
 * @Version: V1.0
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
