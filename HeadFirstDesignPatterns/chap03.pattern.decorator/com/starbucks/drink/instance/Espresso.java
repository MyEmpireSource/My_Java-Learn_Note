package com.starbucks.drink.instance;

import com.starbucks.drink.Beverage;

public class Espresso extends Beverage {

	public Espresso() {
		this.setDescription("Espresso");
	}
	
	public double cost() {
		return 1.99;
	}

}
