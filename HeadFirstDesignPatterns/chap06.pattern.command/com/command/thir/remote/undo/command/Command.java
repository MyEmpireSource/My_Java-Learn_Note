package com.command.thir.remote.undo.command;

public interface Command {
	public void execute();
	
	//加入撤销按钮事件
	public void undo();
}