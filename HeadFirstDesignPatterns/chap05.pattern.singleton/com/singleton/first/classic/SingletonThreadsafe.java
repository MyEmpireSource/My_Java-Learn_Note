package com.singleton.first.classic;

/**
 * 
 * @Package: com.singleton.first.classic
 * @ClassName: SingletonThreadsafe.java
 *
 * @Description: 基本(经典)单件模式, 线程安全, 但会影响性能
 * 				   在Java中, 实现单件模式需要私有的构造器, 一个静态方法和一个静态变量
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月20日 上午11:40:33
 * @UpdateDate: 2017年11月20日 上午11:40:33
 * @Version: V1.0
 */
public class SingletonThreadsafe {
	private static SingletonThreadsafe uniqueInstance;
	 
	// other useful instance variables here
 
	private SingletonThreadsafe() {}
 
	/**
	 * 
	 * @Title: getInstance
	 * @Description: synchronized 关键字保证不会有两个线程同时访问方法, 但会影响性能
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: SingletonThreadsafe
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月20日 上午11:41:05
	 * @ChangeDate: 2017年11月20日 上午11:41:05
	 * @Author: ZCX
	 */
	public static synchronized SingletonThreadsafe getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SingletonThreadsafe();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
}
