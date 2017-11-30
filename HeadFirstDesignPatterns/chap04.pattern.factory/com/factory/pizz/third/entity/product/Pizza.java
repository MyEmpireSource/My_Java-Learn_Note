package com.factory.pizz.third.entity.product;

import com.factory.pizz.third.entity.ingredients.Cheese;
import com.factory.pizz.third.entity.ingredients.Clams;
import com.factory.pizz.third.entity.ingredients.Dough;
import com.factory.pizz.third.entity.ingredients.Pepperoni;
import com.factory.pizz.third.entity.ingredients.Sauce;
import com.factory.pizz.third.entity.ingredients.Veggies;

public abstract class Pizza {
	protected String name;

	/**
	 * 每个Pizza都持有一组在准备时会用到的原料
	 */
	protected Dough dough;
	protected Sauce sauce;
	protected Veggies veggies[];
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;

	/**
	 * 
	 * @Title: prepare
	 * @Description: 抽象方法, 
	 * 				   该方法用于收集(实例化)Pizza所需的原料
	 *               原料来自于原料工厂
	 * 
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月15日 下午4:08:02
	 * @ChangeDate: 2017年11月15日 下午4:08:02
	 * @Author: ZCX
	 */
	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (sauce != null) {
			result.append(sauce);
			result.append("\n");
		}
		if (cheese != null) {
			result.append(cheese);
			result.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				result.append(veggies[i]);
				if (i < veggies.length-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (clam != null) {
			result.append(clam);
			result.append("\n");
		}
		if (pepperoni != null) {
			result.append(pepperoni);
			result.append("\n");
		}
		return result.toString();
	}
}
