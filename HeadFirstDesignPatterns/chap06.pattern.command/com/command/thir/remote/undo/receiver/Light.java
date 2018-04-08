package com.command.thir.remote.undo.receiver;

public class Light {
	private String location;
	private int level;

	public Light(String location) {
		this.location = location;
	}

	public void on() {
		this.level = 100;
		System.out.println("Light is on");
	}

	public void off() {
		level = 0;
		System.out.println("Light is off");
	}

	public void dim(int level) {
		this.level = level;
		if (level == 0) {
			this.off();
		}
		else {
			System.out.println("Light is dimmed to " + level + "%");
		}
	}

	public int getLevel() {
		return level;
	}
}
