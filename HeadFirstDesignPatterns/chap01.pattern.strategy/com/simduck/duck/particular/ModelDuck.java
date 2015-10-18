package com.simduck.duck.particular;

import com.simduck.duck.Duck;
import com.simduck.duck.behavior.fly.impl.FlyNoWay;
import com.simduck.duck.behavior.quack.impl.Quack;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}
