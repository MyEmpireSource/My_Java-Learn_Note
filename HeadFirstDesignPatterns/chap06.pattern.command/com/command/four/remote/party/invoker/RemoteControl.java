package com.command.four.remote.party.invoker;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.command.impl.NoCommand;

public class RemoteControl {
	
	private Command[] onCommands;
	private Command[] offCommands;
	
	private Command undoCommand;
	
	public RemoteControl() {
		this.onCommands = new Command[7];
		this.offCommands = new Command[7];
		
		Command noCommand = new NoCommand();
		
		for (int i = 0; i < 7; i++) {
			this.offCommands[i] = noCommand;
			this.onCommands[i] = noCommand;
		}
		
		this.undoCommand = noCommand;
		
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
 
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}
 
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}

	public void undoButtonWasPushed() {
		undoCommand.undo();
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
