package com.simduck.duck;

import com.simduck.duck.behavior.fly.FlyBehavior;
import com.simduck.duck.behavior.quack.QuackBehavior;

/**
 * SuperType 鸭子的超类型
 * @author ZCX
 *
 */
public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public Duck() {
	}
	
	public abstract void display();
	
	public void performFly() {
		this.flyBehavior.fly();
	}
	
	public void performQuack() {
		this.quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
}
