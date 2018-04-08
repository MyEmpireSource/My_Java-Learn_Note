package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.Hottub;

public class HottubOffCommand implements Command {
	private Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		this.hottub.setTemperature(98);
		this.hottub.off();
	}
	public void undo() {
		this.hottub.on();
	}
}
