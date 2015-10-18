package com.starbucks.drink.condiment.instance;

import com.starbucks.drink.Beverage;
import com.starbucks.drink.condiment.CondimentDecorator;

public class Whip extends CondimentDecorator {

	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return this.beverage.getDescription() + ", Whip";
	}

	public double cost() {
		return 2.30 + this.beverage.cost();
	}

}
