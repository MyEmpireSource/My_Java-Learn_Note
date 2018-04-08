package com.templatemethod.first.barista.beverage;

import com.templatemethod.first.barista.template.CaffeineBeverage;

public class Tea extends CaffeineBeverage {

	@Override
	protected void brew() {
		// TODO Auto-generated method stub
		System.out.println("Steeping the tea");
	}

	@Override
	protected void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("Adding Lemon");
	}

}
