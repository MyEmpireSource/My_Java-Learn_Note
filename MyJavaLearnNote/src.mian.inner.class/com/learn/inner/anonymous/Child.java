package com.learn.inner.anonymous;

public class Child {

	public Person eatSome() {
		return new Person() {
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("Child eat sometings!!");
			}
		};
	}
	
}
