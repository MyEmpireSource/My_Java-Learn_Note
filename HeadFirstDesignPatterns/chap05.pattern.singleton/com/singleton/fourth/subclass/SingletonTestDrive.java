package com.singleton.fourth.subclass;

public class SingletonTestDrive {
	public static void main(String[] args) {
		Singleton foo = CoolerSingleton.getInstance();
		Singleton bar = HotterSingleton.getInstance();
		
		//单件模式中, 直接继承, 会导致所有的派生类共享同一个实例变量, 这可能不是你想要的
		System.out.println(foo);
		System.out.println(bar);
 	}
}
