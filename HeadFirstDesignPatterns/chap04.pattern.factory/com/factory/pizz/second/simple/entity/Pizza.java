package com.factory.pizz.second.simple.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Package: com.factory.pizz.second.simple.entity
 * @ClassName: Pizza.java
 *
 * @Description: Pizza抽象类， 所有具体Pizza都必须派生自这个类
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月13日 下午3:27:18
 * @UpdateDate: 2017年11月13日 下午3:27:18
 * @Version: V1.0
 */
public abstract class Pizza {
	protected String name;
	protected String dough;
	protected String sauce;
	protected List<String> toppings = new ArrayList<String> ();
 
	/**
	 * 
	 * @Title: prepare
	 * @Description: 准备工作, 需要以特定的顺序, 有一连串的步骤
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月13日 下午3:28:55
	 * @ChangeDate: 2017年11月13日 下午3:28:55
	 * @Author: ZCX
	 */
	public void prepare() {
		System.out.println("Preparing " + this.name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings: ");
		for (int i = 0; i < this.toppings.size(); i++) {
			System.out.println("   " + this.toppings.get(i));
		}
	}
  
	/**
	 * 
	 * @Title: bake
	 * @Description: 抽象类提供了某些默认的基本做法, 用来进行烘焙, 切片, 和装盒
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月13日 下午3:30:26
	 * @ChangeDate: 2017年11月13日 下午3:30:26
	 * @Author: ZCX
	 */
	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
 
	/**
	 * 
	 * @Title: bake
	 * @Description: 抽象类提供了某些默认的基本做法, 用来进行烘焙, 切片, 和装盒
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月13日 下午3:30:26
	 * @ChangeDate: 2017年11月13日 下午3:30:26
	 * @Author: ZCX
	 */
	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
  
	/**
	 * 
	 * @Title: bake
	 * @Description: 抽象类提供了某些默认的基本做法, 用来进行烘焙, 切片, 和装盒
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月13日 下午3:30:26
	 * @ChangeDate: 2017年11月13日 下午3:30:26
	 * @Author: ZCX
	 */
	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
 
	public String getName() {
		return this.name;
	}

	public String toString() {
		StringBuffer display = new StringBuffer();
		display.append("---- " + this.name + " ----\n");
		display.append(this.dough + "\n");
		display.append(this.sauce + "\n");
		for (int i = 0; i < this.toppings.size(); i++) {
			display.append(this.toppings.get(i) + "\n");
		}
		return display.toString();
	}
}