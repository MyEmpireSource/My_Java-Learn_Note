package com.singleton.first.classic;

/**
 * 
 * @Package: com.singleton.first.classic
 * @ClassName: Singleton.java
 *
 * @Description: 基本(经典)单件模式, 非线程安全
 * 				   在Java中, 实现单件模式需要私有的构造器, 一个静态方法和一个静态变量
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月20日 上午11:16:21
 * @UpdateDate: 2017年11月20日 上午11:16:21
 * @Version: V1.0
 */
public class Singleton {
	
	//在Java中, 实现单件模式需要私有的构造器, 一个静态方法和一个静态变量
	
	private static Singleton uniqueInstance;
	
	// other useful instance variables here
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if (Singleton.uniqueInstance == null) {
			Singleton.uniqueInstance = new Singleton();
		}
		
		return Singleton.uniqueInstance;
	}

	// other useful methods here
}
