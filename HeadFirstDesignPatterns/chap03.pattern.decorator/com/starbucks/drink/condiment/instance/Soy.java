package com.starbucks.drink.condiment.instance;

import com.starbucks.drink.Beverage;
import com.starbucks.drink.condiment.CondimentDecorator;

public class Soy extends CondimentDecorator {

	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return this.beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return 1.20 + this.beverage.cost();
	}

}
