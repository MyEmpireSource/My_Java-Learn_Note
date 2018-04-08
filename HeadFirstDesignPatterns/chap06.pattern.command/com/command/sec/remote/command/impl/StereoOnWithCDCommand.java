package com.command.sec.remote.command.impl;

import com.command.sec.remote.command.Command;
import com.command.sec.remote.recevier.Stereo;

public class StereoOnWithCDCommand implements Command {
	
	private Stereo stereo;
	
	public StereoOnWithCDCommand (Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.stereo.on();
		this.stereo.setCD();
		this.stereo.setVolume(11);
	}

}
