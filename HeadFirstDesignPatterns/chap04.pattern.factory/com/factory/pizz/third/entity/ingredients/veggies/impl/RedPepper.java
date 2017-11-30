package com.factory.pizz.third.entity.ingredients.veggies.impl;

import com.factory.pizz.third.entity.ingredients.Veggies;

public class RedPepper implements Veggies {

	public String toStringInfo() {
		return "Red Pepper";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
