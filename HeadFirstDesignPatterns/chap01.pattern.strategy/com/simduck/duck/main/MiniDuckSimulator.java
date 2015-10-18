package com.simduck.duck.main;

import com.simduck.duck.behavior.fly.impl.FlyRocketPowered;
import com.simduck.duck.particular.DecoyDuck;
import com.simduck.duck.particular.MallardDuck;
import com.simduck.duck.particular.ModelDuck;
import com.simduck.duck.particular.RubberDuck;

public class MiniDuckSimulator {
 
	public static void main(String[] args) {
 
		MallardDuck	mallard = new MallardDuck();
		RubberDuck	rubberDuckie = new RubberDuck();
		DecoyDuck	decoy = new DecoyDuck();
 
		ModelDuck	model = new ModelDuck();

		mallard.performQuack();
		rubberDuckie.performQuack();
		decoy.performQuack();
   
		model.performFly();	
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
