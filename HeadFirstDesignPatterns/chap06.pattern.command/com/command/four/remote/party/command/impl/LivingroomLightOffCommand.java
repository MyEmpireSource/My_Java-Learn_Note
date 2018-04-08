package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.Light;

public class LivingroomLightOffCommand implements Command {
	private Light light;

	public LivingroomLightOffCommand(Light light) {
		this.light = light;
	}
	public void execute() {
		this.light.off();
	}
	public void undo() {
		this.light.on();
	}
}
