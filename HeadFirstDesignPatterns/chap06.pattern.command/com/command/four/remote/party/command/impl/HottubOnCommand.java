package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.Hottub;

public class HottubOnCommand implements Command {
	private Hottub hottub;

	public HottubOnCommand(Hottub hottub) {
		this.hottub = hottub;
	}
	public void execute() {
		this.hottub.on();
		this.hottub.setTemperature(104);
		this.hottub.circulate();
	}
	public void undo() {
		this.hottub.off();
	}
}
