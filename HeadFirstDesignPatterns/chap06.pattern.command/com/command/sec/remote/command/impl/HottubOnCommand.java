package com.command.sec.remote.command.impl;

import com.command.sec.remote.command.Command;
import com.command.sec.remote.recevier.Hottub;

public class HottubOnCommand implements Command {

	private Hottub hottub;
	
	public HottubOnCommand(Hottub hottub) {
		this.hottub = hottub;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.hottub.on();
		hottub.heat();
		hottub.bubblesOn();
	}

}
