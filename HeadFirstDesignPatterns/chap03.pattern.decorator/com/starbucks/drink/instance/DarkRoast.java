package com.starbucks.drink.instance;

import com.starbucks.drink.Beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		this.setDescription("DarkRoast");
	}
	
	public double cost() {
		return 2.99;
	}

}
