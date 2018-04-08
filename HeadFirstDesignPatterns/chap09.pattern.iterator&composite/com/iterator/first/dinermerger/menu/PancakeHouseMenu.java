package com.iterator.first.dinermerger.menu;

import java.util.ArrayList;

import com.iterator.first.dinermerger.entity.MenuItem;
import com.iterator.first.dinermerger.iterator.Iterator;
import com.iterator.first.dinermerger.iterator.impl.PancakeHouseMenuIterator;

/**
 * 
 * @Package: com.iterator.first.dinermerger.menu
 * @ClassName: PancakeHouseMenu.java
 *
 * @Description: 煎饼屋菜单对象, 主要用于服务员展示给客户看
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月16日 下午4:02:24
 * @UpdateDate: 2018年1月16日 下午4:02:24
 * @Version: V1.0
 */
public class PancakeHouseMenu {
	ArrayList<MenuItem> menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem> ();

		addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);

		addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);

		addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);

		addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		menuItems.add(new MenuItem(name, description, vegetarian, price));
	}

	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	/**
	 * 
	 * @Title: createIterator
	 * @Description: 返回煎饼屋菜单项迭代器
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: Iterator
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年1月16日 下午4:02:59
	 * @ChangeDate: 2018年1月16日 下午4:02:59
	 * @Author: ZCX
	 */
	public Iterator createIterator() {
		return new PancakeHouseMenuIterator(menuItems);
	}

	public String toString() {
		return "Objectville Pancake House Menu";
	}

	// other menu methods here
}
