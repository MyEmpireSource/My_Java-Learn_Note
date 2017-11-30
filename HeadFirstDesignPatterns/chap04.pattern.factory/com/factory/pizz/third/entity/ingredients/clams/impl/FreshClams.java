package com.factory.pizz.third.entity.ingredients.clams.impl;

import com.factory.pizz.third.entity.ingredients.Clams;

public class FreshClams implements Clams {

	public String toStringInfo() {
		return "Fresh Clams from Long Island Sound";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
