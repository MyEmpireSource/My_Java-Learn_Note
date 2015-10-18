package com.starbucks.drink.condiment.instance;

import com.starbucks.drink.Beverage;
import com.starbucks.drink.condiment.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return this.beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return 0.20 + this.beverage.cost();
	}

}
