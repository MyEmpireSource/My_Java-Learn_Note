package com.simduck.duck.main;

import com.simduck.duck.Duck;
import com.simduck.duck.behavior.fly.impl.FlyRocketPowered;
import com.simduck.duck.particular.MallardDuck;
import com.simduck.duck.particular.ModelDuck;

public class MiniDuckSimulator1 {
 
	public static void main(String[] args) {
 
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
   
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

	}
}
