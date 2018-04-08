package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.TV;

public class TVOffCommand implements Command {
	private TV tv;

	public TVOffCommand(TV tv) {
		this.tv= tv;
	}

	public void execute() {
		this.tv.off();
	}

	public void undo() {
		this.tv.on();
	}
}
