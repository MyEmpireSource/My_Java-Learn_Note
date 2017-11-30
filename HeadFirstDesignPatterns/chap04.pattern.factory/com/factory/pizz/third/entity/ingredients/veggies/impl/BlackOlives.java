package com.factory.pizz.third.entity.ingredients.veggies.impl;

import com.factory.pizz.third.entity.ingredients.Veggies;

public class BlackOlives implements Veggies {

	public String toStringInfo() {
		return "Black Olives";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
