package com.simduck.duck.behavior.quack.impl;

import com.simduck.duck.behavior.quack.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	public void quack() {
		System.out.println("<< Silence >>");
	}

}
