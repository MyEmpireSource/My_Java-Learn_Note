package com.adapter.first.turkey.duck.adapter;

import java.util.Random;

import com.adapter.first.turkey.duck.component.Duck;
import com.adapter.first.turkey.duck.component.Turkey;

public class DuckAndTurkeyAdapter implements Duck, Turkey {
	
	private Duck duck;
	private Turkey turkey;
	
	public DuckAndTurkeyAdapter(Duck duck, Turkey turkey) {
		this.duck = duck;
		this.turkey = turkey;
	}

	@Override
	public void gobble() {
		// TODO Auto-generated method stub
		this.duck.quack();
	}

	@Override
	public void shortFly() {
		// TODO Auto-generated method stub
		if ((new Random()).nextInt(5)  == 0) {
		     this.duck.fly();
		}
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		this.turkey.gobble();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			this.turkey.shortFly();
		}
	}

}
