package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.TV;

public class TVOnCommand implements Command {
	private TV tv;

	public TVOnCommand(TV tv) {
		this.tv= tv;
	}

	public void execute() {
		this.tv.on();
		this.tv.setInputChannel();
	}

	public void undo() {
		this.tv.off();
	}
}
