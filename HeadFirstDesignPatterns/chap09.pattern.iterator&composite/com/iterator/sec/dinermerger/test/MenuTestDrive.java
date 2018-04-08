package com.iterator.sec.dinermerger.test;

import java.util.Iterator;

import com.iterator.sec.dinermerger.entity.MenuItem;
import com.iterator.sec.dinermerger.menu.Menu;
import com.iterator.sec.dinermerger.menu.impl.DinerMenu;
import com.iterator.sec.dinermerger.menu.impl.PancakeHouseMenu;
import com.iterator.sec.dinermerger.waitress.Waitress;

public class MenuTestDrive {
	
	public static void main(String[] args) {
		Menu pancakeHouseMenu = new PancakeHouseMenu();
	    Menu dinerMenu = new DinerMenu();
	
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
	
		waitress.printMenu();
		
		Iterator<MenuItem> iter = dinerMenu.createIterator();
		System.out.println(iter.toString());
		
		while (iter.hasNext()) {
			
			iter.remove();
			System.out.println(iter.toString());
		}
	}
}
