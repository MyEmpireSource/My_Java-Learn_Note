package com.command.thir.remote.undo.command.impl;

import com.command.thir.remote.undo.command.Command;
import com.command.thir.remote.undo.receiver.Light;

public class DimmerLightOnCommand implements Command {
	private Light light;
	private int prevLevel;

	public DimmerLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		//改变电灯状态之前, 把状态记录下来, 以便撤销时使用
		this.prevLevel = this.light.getLevel();
		this.light.dim(75);
	}

	public void undo() {
		//撤销, 返回上一状态
		this.light.dim(prevLevel);
	}
}
