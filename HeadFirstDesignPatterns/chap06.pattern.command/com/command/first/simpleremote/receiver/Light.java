package com.command.first.simpleremote.receiver;

/**
 * 
 * @Package: com.command.first.simpleremote.receiver
 * @ClassName: Light.java
 *
 * @Description: 电灯 (接收者)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 下午3:52:36
 * @UpdateDate: 2017年11月22日 下午3:52:36
 * @Version: V1.0
 */
public class Light {
	public Light() {
	}

	public void on() {
		System.out.println("Light is on");
	}

	public void off() {
		System.out.println("Light is off");
	}
}
