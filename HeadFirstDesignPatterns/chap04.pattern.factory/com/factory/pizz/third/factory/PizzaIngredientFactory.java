package com.factory.pizz.third.factory;

import com.factory.pizz.third.entity.ingredients.Cheese;
import com.factory.pizz.third.entity.ingredients.Clams;
import com.factory.pizz.third.entity.ingredients.Dough;
import com.factory.pizz.third.entity.ingredients.Pepperoni;
import com.factory.pizz.third.entity.ingredients.Sauce;
import com.factory.pizz.third.entity.ingredients.Veggies;

/**
 * 
 * @Package: com.factory.pizz.third.factory
 * @ClassName: PizzaIngredientFactory.java
 *
 * @Description: Pizza原料工厂接口, 收到请求后, 生产(返回)不同原料家族所需的原料(对象)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月15日 下午3:16:02
 * @UpdateDate: 2017年11月15日 下午3:16:02
 * @Version: V1.0
 */
public interface PizzaIngredientFactory {
	
	/**
	 * 在接口中, 每个原料都有对应的方法生产原料
	 * 
	 * 如果每个工厂实例都有某种通用的"机制"要求实现, 可以把接口改为抽象来(参照PizzaStore)
	 * 
	 */
	
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
