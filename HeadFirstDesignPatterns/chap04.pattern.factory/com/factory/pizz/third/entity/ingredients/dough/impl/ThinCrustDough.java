package com.factory.pizz.third.entity.ingredients.dough.impl;

import com.factory.pizz.third.entity.ingredients.Dough;

public class ThinCrustDough implements Dough {
	public String toStringInfo() {
		return "Thin Crust Dough";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
