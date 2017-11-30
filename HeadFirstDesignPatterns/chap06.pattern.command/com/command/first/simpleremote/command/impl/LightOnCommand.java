package com.command.first.simpleremote.command.impl;

import com.command.first.simpleremote.command.Command;
import com.command.first.simpleremote.receiver.Light;

/**
 * 
 * @Package: com.command.first.simpleremote.command.impl
 * @ClassName: LightOnCommand.java
 *
 * @Description: 命令对象(command object)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 上午10:47:31
 * @UpdateDate: 2017年11月22日 上午10:47:31
 * @Version: V1.0
 */
public class LightOnCommand implements Command {
	Light light;
  
	public LightOnCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.on();
	}
}
