package com.simduck.duck.particular;

import com.simduck.duck.behavior.quack.QuackBehavior;

public class FakeQuack implements QuackBehavior {
	public void quack() {
		System.out.println("Qwak");
	}
}
