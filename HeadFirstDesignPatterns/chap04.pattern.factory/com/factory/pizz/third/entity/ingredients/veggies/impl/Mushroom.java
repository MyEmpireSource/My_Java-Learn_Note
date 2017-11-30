package com.factory.pizz.third.entity.ingredients.veggies.impl;

import com.factory.pizz.third.entity.ingredients.Veggies;

public class Mushroom implements Veggies {

	public String toStringInfo() {
		return "Mushrooms";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
