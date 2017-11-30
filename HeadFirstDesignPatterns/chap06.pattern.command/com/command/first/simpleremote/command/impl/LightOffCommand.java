package com.command.first.simpleremote.command.impl;

import com.command.first.simpleremote.command.Command;
import com.command.first.simpleremote.receiver.Light;

/**
 * 
 * @Package: com.command.first.simpleremote.command.impl
 * @ClassName: LightOffCommand.java
 *
 * @Description: 命令对象(command object)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 上午10:47:24
 * @UpdateDate: 2017年11月22日 上午10:47:24
 * @Version: V1.0
 */
public class LightOffCommand implements Command {
	Light light;
 
	public LightOffCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.off();
	}
}
