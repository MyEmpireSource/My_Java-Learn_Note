package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.Stereo;

public class StereoOffCommand implements Command {
	private Stereo stereo;
 
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		this.stereo.off();
	}

	public void undo() {
		this.stereo.on();
	}
}
