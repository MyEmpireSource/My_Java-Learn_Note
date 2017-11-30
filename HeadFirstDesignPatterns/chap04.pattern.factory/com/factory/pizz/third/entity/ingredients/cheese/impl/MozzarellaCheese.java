package com.factory.pizz.third.entity.ingredients.cheese.impl;

import com.factory.pizz.third.entity.ingredients.Cheese;

public class MozzarellaCheese implements Cheese {

	public String toStringInfo() {
		return "Shredded Mozzarella";
	}

	@Override
	public String toString() {
		return this.toStringInfo();
	}
	
	
}
