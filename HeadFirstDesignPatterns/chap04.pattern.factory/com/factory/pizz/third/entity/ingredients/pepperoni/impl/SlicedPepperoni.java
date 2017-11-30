package com.factory.pizz.third.entity.ingredients.pepperoni.impl;

import com.factory.pizz.third.entity.ingredients.Pepperoni;

public class SlicedPepperoni implements Pepperoni {

	public String toStringInfo() {
		return "Sliced Pepperoni";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
