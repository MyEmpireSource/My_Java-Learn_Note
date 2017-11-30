package com.command.first.simpleremote.receiver;

/**
 * 
 * @Package: com.command.first.simpleremote.receiver
 * @ClassName: GarageDoor.java
 *
 * @Description: 车库门 (接收者)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 下午3:52:11
 * @UpdateDate: 2017年11月22日 下午3:52:11
 * @Version: V1.0
 */
public class GarageDoor {
	
	public GarageDoor() {
	}

	public void up() {
		System.out.println("Garage Door is Open");
	}

	public void down() {
		System.out.println("Garage Door is Closed");
	}

	public void stop() {
		System.out.println("Garage Door is Stopped");
	}

	public void lightOn() {
		System.out.println("Garage light is on");
	}

	public void lightOff() {
		System.out.println("Garage light is off");
	}
}
