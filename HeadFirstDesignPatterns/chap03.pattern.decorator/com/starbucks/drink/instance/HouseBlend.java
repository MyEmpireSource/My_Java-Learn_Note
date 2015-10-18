package com.starbucks.drink.instance;

import com.starbucks.drink.Beverage;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		this.setDescription("HouseBlend");
	}
	
	public double cost() {
		return 0.89;
	}
	
}
