package com.command.thir.remote.undo.invoker;

import com.command.thir.remote.undo.command.Command;
import com.command.thir.remote.undo.command.impl.NoCommand;

public class RemoteControlWithUndo {
	
	private Command[] onCommands;
	private Command[] offCommands;
	
	//记录前一个命令
	private Command undoCommand;
	
	
	public RemoteControlWithUndo() {
		this.onCommands = new Command[7];
		this.offCommands = new Command[7];
 
		Command noCommand = new NoCommand();
		for(int i=0;i<7;i++) {
			this.onCommands[i] = noCommand;
			this.offCommands[i] = noCommand;
		}
		this.undoCommand = noCommand;
	}
	
	/**
	 * 
	 * @Title: setCommand
	 * @Description: TODO(用一句话描述该文件做什么)
	 * 
	 * @Params:
	 *   @param solt 		插槽位置
	 *   @param onCommand 	开的命令
	 *   @param offCommand 	关的命令
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年12月5日 下午3:48:32
	 * @ChangeDate: 2017年12月5日 下午3:48:32
	 * @Author: ZCX
	 */
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		this.onCommands[slot] = onCommand;
		this.offCommands[slot] = offCommand;
	}
	
	public void onButtonWasPushed(int slot) {
		
		// 按下按钮, 优先执行命令
		this.onCommands[slot].execute();
		// 执行后, 将命令记录在 undoCommand 实例变量中
		this.undoCommand = this.onCommands[slot];
	}
 
	public void offButtonWasPushed(int slot) {
		// 按下按钮, 优先执行命令
		this.offCommands[slot].execute();
		
		// 执行后, 将命令记录在 undoCommand 实例变量中
		this.undoCommand = this.offCommands[slot];
	}
 
	public void undoButtonWasPushed() {
		this.undoCommand.undo();
	}
  
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
		return stringBuff.toString();
	}
}
