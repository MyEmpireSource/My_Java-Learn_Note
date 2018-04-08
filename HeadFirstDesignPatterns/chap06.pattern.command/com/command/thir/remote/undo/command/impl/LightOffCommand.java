package com.command.thir.remote.undo.command.impl;

import com.command.thir.remote.undo.command.Command;
import com.command.thir.remote.undo.receiver.Light;

public class LightOffCommand implements Command {
	private Light light;
 
	public LightOffCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		this.light.off();
	}
 
	public void undo() {
		this.light.on();
	}
}
