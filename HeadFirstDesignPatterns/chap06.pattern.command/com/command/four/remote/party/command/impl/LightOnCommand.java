package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.Light;

public class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		this.light.on();
	}

	public void undo() {
		this.light.off();
	}
}
