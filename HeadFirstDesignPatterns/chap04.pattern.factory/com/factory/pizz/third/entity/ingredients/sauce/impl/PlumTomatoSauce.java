package com.factory.pizz.third.entity.ingredients.sauce.impl;

import com.factory.pizz.third.entity.ingredients.Sauce;

public class PlumTomatoSauce implements Sauce {
	public String toStringInfo() {
		return "Tomato sauce with plum tomatoes";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
