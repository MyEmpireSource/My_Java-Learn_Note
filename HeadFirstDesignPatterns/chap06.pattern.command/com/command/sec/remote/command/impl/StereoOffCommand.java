package com.command.sec.remote.command.impl;

import com.command.sec.remote.command.Command;
import com.command.sec.remote.recevier.Stereo;

public class StereoOffCommand implements Command{

	private Stereo stereo;
	
	public StereoOffCommand (Stereo stereo) {
		this.stereo = stereo;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.stereo.off();
	}
	
}
