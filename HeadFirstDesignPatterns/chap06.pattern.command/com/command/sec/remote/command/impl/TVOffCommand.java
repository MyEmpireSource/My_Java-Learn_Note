package com.command.sec.remote.command.impl;

import com.command.sec.remote.command.Command;
import com.command.sec.remote.recevier.TV;

public class TVOffCommand implements Command {

	private TV tv;
	
	public TVOffCommand(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.tv.off();
	}

}
