package com.command.sec.remote.invoker;

import com.command.sec.remote.command.Command;
import com.command.sec.remote.command.impl.NoCommand;

/**
 * 
 * @Package: com.command.sec.remote.invoker
 * @ClassName: RemoteControl.java
 *
 * @Description: 调用者
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月5日 上午10:24:42
 * @UpdateDate: 2017年12月5日 上午10:24:42
 * @Version: V1.0
 */
public class RemoteControl {
	// 遥控器要处理 7 个开与关的命令
	// 用相应数组记录这些命令
	private Command[] onCommands;
	private Command[] offCommands;
	
	public RemoteControl() {
		this.onCommands = new Command[7];
		this.offCommands = new Command[7];
		
		Command noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			this.offCommands[i] = noCommand;
			this.onCommands[i] = noCommand;
		}
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
	 * @CreateDate: 2017年12月5日 上午10:30:58
	 * @ChangeDate: 2017年12月5日 上午10:30:58
	 * @Author: ZCX
	 */
	public void setCommand(int solt, Command onCommand, Command offCommand) {
		this.onCommands[solt] = onCommand;
		this.offCommands[solt] = offCommand;
	}
	
	public void onButtonWasPushed(int solt) {
		this.onCommands[solt].execute();
	}
	
	public void offButtonWasPushed(int slot) {
		this.offCommands[slot].execute();
	}
  
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}
	
}
