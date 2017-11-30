package com.singleton.third.threadsalfe.dcl;

/**
 * 
 * @Package: com.singleton.third.threadsalfe.dcl
 * @ClassName: Singleton.java
 *
 * @Description: 多线程安全处理 : "双重检查加锁(double-checked locking)(dcl)"
 * 							  最多只进行一次同步, 比起直接线程同步大大减少资源消耗
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月20日 下午3:31:17
 * @UpdateDate: 2017年11月20日 下午3:31:17
 * @Version: V1.0
 */
public class Singleton {
	
	// volatile 关键字确保 ： 当 uniqueInstance 变量被初始化为Singleton实例时
	// 					  多个线程正确地处理 uniqueInstance 变量
	private volatile static Singleton uniqueInstance;
	 
	private Singleton() {}
 
	public static Singleton getInstance() {
		
		// 检查实例, 如果不存在, 就进入同步区块
		if (uniqueInstance == null) {
			
			// 只有第一次才执行下面代码 (同步代码只执行一次)
			
			synchronized (Singleton.class) {
				
				// 进入 同步区块后再检查一次, 如果仍是 null, 才创建实例
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}
