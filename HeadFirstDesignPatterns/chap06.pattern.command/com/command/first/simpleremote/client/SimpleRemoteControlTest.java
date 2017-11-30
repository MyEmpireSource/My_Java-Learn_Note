package com.command.first.simpleremote.client;

import com.command.first.simpleremote.command.impl.GarageDoorOpenCommand;
import com.command.first.simpleremote.command.impl.LightOnCommand;
import com.command.first.simpleremote.invoker.SimpleRemoteControl;
import com.command.first.simpleremote.receiver.GarageDoor;
import com.command.first.simpleremote.receiver.Light;

/**
 * 
 * @Package: com.command.first.simpleremote
 * @ClassName: SimpleRemoteControlTest.java
 *
 * @Description: 客户(client)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年11月22日 上午10:49:44
 * @UpdateDate: 2017年11月22日 上午10:49:44
 * @Version: V1.0
 */
public class SimpleRemoteControlTest {

	public static void main(String[] args) {
		// 遥控器, 调用者
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		// 接收者
		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();
		
		// 命令对象
		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoorOpenCommand garageOpen = 
		    new GarageDoorOpenCommand(garageDoor);
 
		// 调用者设置命令对象
		remote.setCommand(lightOn);
		// 模拟按下按钮, 调用者调用应用
		remote.buttonWasPressed();
		
		
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
    }

}
