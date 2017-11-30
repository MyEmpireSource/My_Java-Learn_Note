package com.factory.pizz.third.entity.ingredients.cheese.impl;

import com.factory.pizz.third.entity.ingredients.Cheese;

public class ReggianoCheese implements Cheese {

	public String toStringInfo() {
		return "Reggiano Cheese";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
