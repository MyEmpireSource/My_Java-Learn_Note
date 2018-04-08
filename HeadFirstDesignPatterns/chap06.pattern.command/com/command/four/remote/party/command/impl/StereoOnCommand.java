package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.Stereo;

public class StereoOnCommand implements Command {
	private Stereo stereo;

	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		this.stereo.on();
	}

	public void undo() {
		this.stereo.off();
	}
}
