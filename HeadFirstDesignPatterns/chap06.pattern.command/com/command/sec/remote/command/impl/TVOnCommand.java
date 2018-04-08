package com.command.sec.remote.command.impl;

import com.command.sec.remote.command.Command;
import com.command.sec.remote.recevier.TV;

public class TVOnCommand implements Command {

	private TV tv;
	
	public TVOnCommand(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.tv.on();
		this.tv.setInputChannel();
	}

}
