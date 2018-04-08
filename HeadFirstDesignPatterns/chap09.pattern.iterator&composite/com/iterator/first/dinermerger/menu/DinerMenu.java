package com.iterator.first.dinermerger.menu;

import com.iterator.first.dinermerger.entity.MenuItem;
import com.iterator.first.dinermerger.iterator.Iterator;
import com.iterator.first.dinermerger.iterator.impl.DinerMenuIterator;

/**
 * 
 * @Package: com.iterator.first.dinermerger.menu
 * @ClassName: DinerMenu.java
 *
 * @Description: 餐厅菜单对象， 主要 服务员展示给客户看
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月16日 下午4:01:46
 * @UpdateDate: 2018年1月16日 下午4:01:46
 * @Version: V1.0
 */
public class DinerMenu {

	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];

		addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
		addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
		addItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99);
		addItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, menu is full!  Can't add item to menu");
		} else {
			MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}

	public MenuItem[] getMenuItems() {
		return menuItems;
	}

	/**
	 * 
	 * @Title: createIterator
	 * @Description: 返回菜单项迭代器
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: Iterator
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年1月16日 下午4:02:03
	 * @ChangeDate: 2018年1月16日 下午4:02:03
	 * @Author: ZCX
	 */
	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}

	// other menu methods here

}
