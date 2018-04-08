package com.command.thir.remote.undo.command.impl;

import com.command.thir.remote.undo.command.Command;
import com.command.thir.remote.undo.receiver.Light;

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
