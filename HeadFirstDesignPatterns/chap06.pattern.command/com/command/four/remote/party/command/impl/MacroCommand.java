package com.command.four.remote.party.command.impl;

import com.command.four.remote.party.command.Command;

/**
 * 
 * @Package: com.command.four.remote.party.command.impl
 * @ClassName: MacroCommand.java
 *
 * @Description: 宏命令对象
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月6日 下午2:52:29
 * @UpdateDate: 2017年12月6日 下午2:52:29
 * @Version: V1.0
 */
public class MacroCommand implements Command {
	
	//命令数组, 用于存放命令
	private Command[] commands;
	
	public MacroCommand (Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		// 当宏命令执行时, 一次性执行数组里的所有命令
		for (Command command : this.commands) {
			command.execute();
		}

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for (Command command : this.commands) {
			command.undo();
		}
	}

}
