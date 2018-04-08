package com.templatemethod.first.barista.beverage;

import com.templatemethod.first.barista.template.CaffeineBeverage;

public class Coffee extends CaffeineBeverage {

	@Override
	protected void brew() {
		// TODO Auto-generated method stub
		System.out.println("Dripping Coffee through filter");
	}

	@Override
	protected void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("Adding Sugar and Milk");
	}

}
