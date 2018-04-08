package com.command.sec.remote.recevier;

/**
 * 
 * @Package: com.command.sec.remote.recevier
 * @ClassName: GarageDoor.java
 *
 * @Description: 车库门
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月5日 上午9:42:29
 * @UpdateDate: 2017年12月5日 上午9:42:29
 * @Version: V1.0
 */
public class GarageDoor {
	String location;

	public GarageDoor(String location) {
		this.location = location;
	}

	public void up() {
		System.out.println(location + " garage Door is Up");
	}

	public void down() {
		System.out.println(location + " garage Door is Down");
	}

	public void stop() {
		System.out.println(location + " garage Door is Stopped");
	}

	public void lightOn() {
		System.out.println(location + " garage light is on");
	}

	public void lightOff() {
		System.out.println(location + " garage light is off");
	}
}
