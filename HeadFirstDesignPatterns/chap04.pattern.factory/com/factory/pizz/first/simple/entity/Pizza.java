package com.factory.pizz.first.simple.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Package: com.factory.pizz.first.simple.entity
 * @ClassName: Pizza.java
 *
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月13日 上午11:43:29
 * @UpdateDate: 2017年11月13日 上午11:43:29
 * @Version: V1.0
 */
public abstract class Pizza {
	protected String name;
	protected String dough;
	protected String sauce;
	
	protected List<String> toppings = new ArrayList<String>();
	
	public String getName() {
		return name;
	}

	public void prepare() {
		System.out.println("Preparing " + this.name);
	}

	public void bake() {
		System.out.println("Baking " + this.name);
	}

	public void cut() {
		System.out.println("Cutting " + this.name);
	}

	public void box() {
		System.out.println("Boxing " + this.name);
	}

	public String toString() {
		// code to display pizza name and ingredients
		StringBuffer display = new StringBuffer();
		display.append("---- " + this.name + " ----\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (int i = 0; i < this.toppings.size(); i++) {
			display.append(this.toppings.get(i) + "\n");
		}
		return display.toString();
	}
}
