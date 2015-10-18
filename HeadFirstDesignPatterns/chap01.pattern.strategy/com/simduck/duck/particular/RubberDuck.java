package com.simduck.duck.particular;

import com.simduck.duck.Duck;
import com.simduck.duck.behavior.fly.impl.FlyNoWay;
import com.simduck.duck.behavior.quack.impl.Squeak;

public class RubberDuck extends Duck {
 
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
