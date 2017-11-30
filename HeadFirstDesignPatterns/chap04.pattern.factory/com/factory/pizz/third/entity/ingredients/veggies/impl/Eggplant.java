package com.factory.pizz.third.entity.ingredients.veggies.impl;

import com.factory.pizz.third.entity.ingredients.Veggies;

public class Eggplant implements Veggies {

	public String toStringInfo() {
		return "Eggplant";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
