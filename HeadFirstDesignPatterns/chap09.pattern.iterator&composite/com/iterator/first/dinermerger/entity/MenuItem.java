package com.iterator.first.dinermerger.entity;

/**
 * 
 * @Package: com.iterator.first.dinermerger.entity
 * @ClassName: MenuItem.java
 *
 * @Description: 菜单对象
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月11日 下午3:37:46
 * @UpdateDate: 2018年1月11日 下午3:37:46
 * @Version: V1.0
 */
public class MenuItem {
	
	private String name;
	private String description; // 描述
	private boolean vegetarian; // 是否是素食
	private double price;		// 价格
	
	
	public MenuItem(String name, String description, boolean vegetarian, double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isVegetarian() {
		return vegetarian;
	}


	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return (name + ", $" + price + "\n   " + description + ", and it " + (this.isVegetarian() ? "" : " not ") + "vegetarian");
	}
	
	
	
}
