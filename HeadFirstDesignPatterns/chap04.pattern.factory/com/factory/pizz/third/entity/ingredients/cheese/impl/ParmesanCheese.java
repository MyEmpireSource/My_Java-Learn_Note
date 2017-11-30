package com.factory.pizz.third.entity.ingredients.cheese.impl;

import com.factory.pizz.third.entity.ingredients.Cheese;

public class ParmesanCheese implements Cheese {

	public String toStringInfo() {
		return "Shredded Parmesan";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
