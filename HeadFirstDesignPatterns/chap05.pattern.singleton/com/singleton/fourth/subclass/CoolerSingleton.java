package com.singleton.fourth.subclass;

/**
 * 
 * @Package: com.singleton.fourth.subclass
 * @ClassName: CoolerSingleton.java
 *
 * @Description: 单件模式中, 直接继承, 会导致所有的派生类共享同一个实例变量
 * 				   这可能不是你想要的
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月20日 下午3:47:10
 * @UpdateDate: 2017年11月20日 下午3:47:10
 * @Version: V1.0
 */
public class CoolerSingleton extends Singleton {
	// useful instance variables here
	protected static Singleton uniqueInstance;
 
	private CoolerSingleton() {
		super();
	}
 
	// useful methods here
}
