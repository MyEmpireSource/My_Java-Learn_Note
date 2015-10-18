package com.starbucks.drink.product;

import org.xml.sax.HandlerBase;

import com.starbucks.drink.Beverage;
import com.starbucks.drink.condiment.instance.Mocha;
import com.starbucks.drink.condiment.instance.Soy;
import com.starbucks.drink.condiment.instance.Whip;
import com.starbucks.drink.instance.DarkRoast;
import com.starbucks.drink.instance.Espresso;
import com.starbucks.drink.instance.HouseBlend;

public class StarbuzzCoffee {

	public static void main(String[] args) {
		Beverage espresso = new Espresso();
		showStarbuzzCoffee(espresso);
		
		Beverage darkRoast = new DarkRoast();
		darkRoast = new Mocha(darkRoast);
		darkRoast = new Mocha(darkRoast);
		darkRoast = new Whip(darkRoast);
		showStarbuzzCoffee(darkRoast);
		
		Beverage houseBlend = new HouseBlend();
		houseBlend = new Soy(houseBlend);
		houseBlend = new Mocha(houseBlend);
		houseBlend = new Whip(houseBlend);
		showStarbuzzCoffee(houseBlend);
	}
	
	private static void showStarbuzzCoffee(Beverage beverage) {
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		System.out.println();
	}
}
