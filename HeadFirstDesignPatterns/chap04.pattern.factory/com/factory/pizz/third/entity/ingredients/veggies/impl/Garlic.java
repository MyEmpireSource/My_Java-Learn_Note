package com.factory.pizz.third.entity.ingredients.veggies.impl;

import com.factory.pizz.third.entity.ingredients.Veggies;

public class Garlic implements Veggies {

	public String toStringInfo() {
		return "Garlic";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
