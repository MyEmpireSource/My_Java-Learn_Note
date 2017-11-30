package com.singleton.third.threadsalfe.stat;

/**
 * 
 * @Package: com.singleton.third.threadsalfe.stat
 * @ClassName: Singleton.java
 *
 * @Description: 多线程安全处理 : 相对于 延迟实例化, 急切实例化 可以避免多线程实例出多个对象的问题
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月20日 上午11:50:56
 * @UpdateDate: 2017年11月20日 上午11:50:56
 * @Version: V1.0
 */
public class Singleton {
	
	// 急切实例化 可以避免多线程实例出多个对象的问题
	// 但如果实例化很耗资源, 启动时会占用资源
	private static Singleton uniqueInstance = new Singleton();
 
	private Singleton() {}
 
	public static Singleton getInstance() {
		return uniqueInstance;
	}
}
