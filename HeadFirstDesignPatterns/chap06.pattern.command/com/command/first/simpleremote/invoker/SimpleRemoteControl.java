package com.command.first.simpleremote.invoker;

import com.command.first.simpleremote.command.Command;

/**
 * 
 * @Package: com.command.first.simpleremote.invoker
 * @ClassName: SimpleRemoteControl.java
 *
 * @Description: This is the invoker
 * 				 简单遥控器(调用者)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 上午10:42:17
 * @UpdateDate: 2017年11月22日 上午10:42:17
 * @Version: V1.0
 */
public class SimpleRemoteControl {
	Command slot;
	 
	public SimpleRemoteControl() {}
 
	public void setCommand(Command command) {
		slot = command;
	}
 
	public void buttonWasPressed() {
		slot.execute();
	}
}
