package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.receiver.CeilingFan;

public class CeilingFanOffCommand implements Command {
	private CeilingFan ceilingFan;
	private int prevSpeed;

	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	public void execute() {
		this.prevSpeed = ceilingFan.getSpeed();
		this.ceilingFan.off();
	}
	public void undo() {
		switch (this.prevSpeed) {
			case CeilingFan.HIGH: 	this.ceilingFan.high(); break;
			case CeilingFan.MEDIUM: this.ceilingFan.medium(); break;
			case CeilingFan.LOW: 	this.ceilingFan.low(); break;
			default: 				this.ceilingFan.off(); break;
		}
	}
}
