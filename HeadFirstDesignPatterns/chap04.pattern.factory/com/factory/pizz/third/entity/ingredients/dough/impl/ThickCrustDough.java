package com.factory.pizz.third.entity.ingredients.dough.impl;

import com.factory.pizz.third.entity.ingredients.Dough;

public class ThickCrustDough implements Dough {
	public String toStringInfo() {
		return "ThickCrust style extra thick crust dough";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
