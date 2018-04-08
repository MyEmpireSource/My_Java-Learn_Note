package com.command.sec.remote.recevier;

public class TV {
	String location;
	int channel;

	public TV(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(this.location + " TV is on");
	}

	public void off() {
		System.out.println(this.location + "TV is off");
	}

	public void setInputChannel() {
		this.channel = 3;
		System.out.println(this.channel + " Channel is set for VCR");
	}
}
