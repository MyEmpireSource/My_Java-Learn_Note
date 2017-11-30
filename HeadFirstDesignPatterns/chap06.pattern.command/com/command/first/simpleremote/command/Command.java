package com.command.first.simpleremote.command;

/**
 * 
 * @Package: com.command.first.simpleremote.command
 * @ClassName: Command.java
 *
 * @Description: 命令对象(command object)接口
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 上午10:43:50
 * @UpdateDate: 2017年11月22日 上午10:43:50
 * @Version: V1.0
 */
public interface Command {
	
	/**
	 * 
	 * @Title: execute
	 * @Description: 所有命令对象将实现的方法
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年11月22日 上午10:53:15
	 * @ChangeDate: 2017年11月22日 上午10:53:15
	 * @Author: ZCX
	 */
	public void execute();
}
