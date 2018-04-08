package com.command.sec.remote.command.impl;

import com.command.sec.remote.command.Command;
import com.command.sec.remote.recevier.Light;

public class LivingroomLightOnCommand implements Command {
	private Light light;

	public LivingroomLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
}
