package com.singleton.fourth.subclass;

/**
 * 
 * @Package: com.singleton.fourth.subclass
 * @ClassName: Singleton.java
 *
 * @Description: 单件模式中, 直接继承, 会导致所有的派生类共享同一个实例变量
 * 				   这可能不是你想要的
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月20日 下午3:45:31
 * @UpdateDate: 2017年11月20日 下午3:45:31
 * @Version: V1.0
 */
public class Singleton {
	protected static Singleton uniqueInstance;
	 
	// other useful instance variables here
 
	protected Singleton() {}
 
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
}
