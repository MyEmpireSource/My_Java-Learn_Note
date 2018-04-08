package com.iterator.first.dinermerger.test;

import com.iterator.first.dinermerger.menu.DinerMenu;
import com.iterator.first.dinermerger.menu.PancakeHouseMenu;
import com.iterator.first.dinermerger.waitress.Waitress;

public class MenuTestDrive {
	
	public static void main(String[] args) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
	    DinerMenu dinerMenu = new DinerMenu();
	
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
	
		waitress.printMenu();
	}
}
