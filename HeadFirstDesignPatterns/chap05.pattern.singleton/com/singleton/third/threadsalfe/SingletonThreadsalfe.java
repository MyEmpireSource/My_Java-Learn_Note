package com.singleton.third.threadsalfe;


/**
 * 
 * @Package: com.singleton.third.threadsalfe
 * @ClassName: SingletonThreadsalfe.java
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
public class SingletonThreadsalfe {
	private static SingletonThreadsalfe uniqueInstance;
	 
	// other useful instance variables here
 
	private SingletonThreadsalfe() {}
 
	/**
	 * 
	 * @Title: getInstance
	 * @Description: 多线程安全处理 : 线程同步, synchronized 关键字保证不会有两个线程同时访问方法, 但会影响性能
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: SingletonThreadsalfe
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月20日 上午11:41:05
	 * @ChangeDate: 2017年11月20日 上午11:41:05
	 * @Author: ZCX
	 */
	public static synchronized SingletonThreadsalfe getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SingletonThreadsalfe();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
}