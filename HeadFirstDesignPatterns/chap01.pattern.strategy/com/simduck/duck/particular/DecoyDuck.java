package com.simduck.duck.particular;

import com.simduck.duck.Duck;
import com.simduck.duck.behavior.fly.impl.FlyNoWay;
import com.simduck.duck.behavior.quack.impl.MuteQuack;


public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
