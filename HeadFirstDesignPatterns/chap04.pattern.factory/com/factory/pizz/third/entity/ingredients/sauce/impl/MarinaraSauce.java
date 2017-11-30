package com.factory.pizz.third.entity.ingredients.sauce.impl;

import com.factory.pizz.third.entity.ingredients.Sauce;

public class MarinaraSauce implements Sauce {
	public String toStringInfo() {
		return "Marinara Sauce";
	}
	
	@Override
	public String toString() {
		return this.toStringInfo();
	}
}
