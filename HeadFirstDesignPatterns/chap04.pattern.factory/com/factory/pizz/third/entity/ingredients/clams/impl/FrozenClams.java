package com.factory.pizz.third.entity.ingredients.clams.impl;

import com.factory.pizz.third.entity.ingredients.Clams;

public class FrozenClams implements Clams {

	public String toStringInfo() {
		return "Frozen Clams from Chesapeake Bay";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
