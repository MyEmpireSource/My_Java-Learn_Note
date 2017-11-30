package com.factory.pizz.second.simple.store;

import com.factory.pizz.second.simple.entity.Pizza;

/**
 * 
 * @Package: com.factory.pizz.second.simple.store
 * @ClassName: PizzaStore.java
 *
 * @Description: Pizza加盟店抽象类, 让子类决定如何创建Pizza
 * 				   该做法让Pizza的制作活动局限于PizzaStore, 
 * 				   同时又能让加盟店依然可以自由制作各种风味的Pizza
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月13日 下午4:17:12
 * @UpdateDate: 2017年11月13日 下午4:17:12
 * @Version: V1.0
 */
public abstract class PizzaStore {
	
	/**
	 * 
	 * @Title: createPizza
	 * @Description: 抽象的工厂方法, 让子类决定如何做Pizza
	 * 				   实例化Pizza的责任被移到一个 '方法'中
	 * 				   此方法就如同一个'工厂'
	 * 
	 * @Params:
	 *   @param item
	 *   @return
	 *
	 * @Return: Pizza
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月13日 下午4:17:18
	 * @ChangeDate: 2017年11月13日 下午4:17:18
	 * @Author: ZCX
	 */
	abstract Pizza createPizza(String item);
 
	public Pizza orderPizza(String type) {
		
		//orderPizza() 在抽象的PizzaStore类中定义而非子类, 
		//所以该方法将不知道是那个子类实际上制作Pizza
		Pizza pizza = createPizza(type);
		
		System.out.println("--- Making a " + pizza.getName() + " ---");
		
		//进一步, orderPizza()方法对Pizza对象做了许多事情(准备, 烘烤, 切片, 装盒)
		//由于Pizza是抽象的, orderPizza()不知道那些具体的类参与进来,
		//换句话说, 这就是解耦(decouple)
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

