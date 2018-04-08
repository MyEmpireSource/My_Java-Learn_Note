package com.command.sec.remote.recevier;

/**
 * 
 * @Package: com.command.sec.remote.recevier
 * @ClassName: Stereo.java
 *
 * @Description: 音响
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月5日 上午9:39:35
 * @UpdateDate: 2017年12月5日 上午9:39:35
 * @Version: V1.0
 */
public class Stereo {
	String location;

	public Stereo(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " stereo is on");
	}

	public void off() {
		System.out.println(location + " stereo is off");
	}

	public void setCD() {
		System.out.println(location + " stereo is set for CD input");
	}

	public void setDVD() {
		System.out.println(location + " stereo is set for DVD input");
	}

	public void setRadio() {
		System.out.println(location + " stereo is set for Radio");
	}

	public void setVolume(int volume) {
		// code to set the volume
		// valid range: 1-11 (after all 11 is better than 10, right?)
		System.out.println(location + " Stereo volume set to " + volume);
	}
}
