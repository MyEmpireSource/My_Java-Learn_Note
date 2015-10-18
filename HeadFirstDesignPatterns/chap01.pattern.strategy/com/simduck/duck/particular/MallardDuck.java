package com.simduck.duck.particular;

import com.simduck.duck.Duck;
import com.simduck.duck.behavior.fly.impl.FlyWithWings;
import com.simduck.duck.behavior.quack.impl.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {
		this.quackBehavior = new Quack();
		this.flyBehavior = new FlyWithWings();
	}
	
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
