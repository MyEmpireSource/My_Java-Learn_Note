package com.singleton.fourth.subclass;

/**
 * 
 * @Package: com.singleton.fourth.subclass
 * @ClassName: HotterSingleton.java
 *
 * @Description: 单件模式中, 直接继承, 会导致所有的派生类共享同一个实例变量
 * 				   这可能不是你想要的
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月20日 下午3:47:21
 * @UpdateDate: 2017年11月20日 下午3:47:21
 * @Version: V1.0
 */
public class HotterSingleton extends Singleton {
	// useful instance variables here
 
	private HotterSingleton() {
		super();
	}
 
	// useful methods here
}
