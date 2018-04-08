package com.templatemethod.sec.hook.barista.test;

import com.templatemethod.sec.hook.barista.beverage.CoffeeWithHook;
import com.templatemethod.sec.hook.barista.beverage.TeaWithHook;
import com.templatemethod.sec.hook.barista.template.CaffeineBeverageWithHook;

public class BeverageWithHookTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaffeineBeverageWithHook tea = new TeaWithHook();
		CaffeineBeverageWithHook coffeeHook = new CoffeeWithHook();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe();
		
		
	}

}
