package com.factory.pizz.third.entity.ingredients.veggies.impl;

import com.factory.pizz.third.entity.ingredients.Veggies;

public class Spinach implements Veggies {

	public String toStringInfo() {
		return "Spinach";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
