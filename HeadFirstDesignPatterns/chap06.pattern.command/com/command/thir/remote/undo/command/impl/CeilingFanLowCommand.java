package com.command.thir.remote.undo.command.impl;

import com.command.thir.remote.undo.command.Command;
import com.command.thir.remote.undo.receiver.CeilingFan;

public class CeilingFanLowCommand implements Command {
	private CeilingFan ceilingFan;
	private int prevSpeed;
  
	public CeilingFanLowCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
 
	public void execute() {
		//改变吊扇速度之前, 先将它的速度记录下来, 以便需要撤销使使用
		this.prevSpeed = this.ceilingFan.getSpeed();
		this.ceilingFan.low();
	}
 
	public void undo() {
		//将吊扇撤销回以前的值
		if (this.prevSpeed == CeilingFan.HIGH) {
			this.ceilingFan.high();
		} else if (this.prevSpeed == CeilingFan.MEDIUM) {
			this.ceilingFan.medium();
		} else if (this.prevSpeed == CeilingFan.LOW) {
			this.ceilingFan.low();
		} else if (this.prevSpeed == CeilingFan.OFF) {
			this.ceilingFan.off();
		}
	}
}
