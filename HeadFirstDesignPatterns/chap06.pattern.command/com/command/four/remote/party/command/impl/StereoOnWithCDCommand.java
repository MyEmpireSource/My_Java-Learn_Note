package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.Stereo;

public class StereoOnWithCDCommand implements Command {
	private Stereo stereo;
 
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		this.stereo.on();
		this.stereo.setCD();
		this.stereo.setVolume(11);
	}

	public void undo() {
		this.stereo.off();
	}
}
