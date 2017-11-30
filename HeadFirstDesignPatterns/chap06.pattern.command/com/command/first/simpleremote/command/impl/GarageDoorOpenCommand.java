package com.command.first.simpleremote.command.impl;

import com.command.first.simpleremote.command.Command;
import com.command.first.simpleremote.receiver.GarageDoor;

/**
 * 
 * @Package: com.command.first.simpleremote.command.impl
 * @ClassName: GarageDoorOpenCommand.java
 *
 * @Description: 命令对象(command object)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 上午10:47:01
 * @UpdateDate: 2017年11月22日 上午10:47:01
 * @Version: V1.0
 */
public class GarageDoorOpenCommand implements Command {

	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.garageDoor.up();
	}

}
