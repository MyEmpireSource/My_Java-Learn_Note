package com.command.thir.remote.undo.client;

import com.command.thir.remote.undo.command.impl.CeilingFanHighCommand;
import com.command.thir.remote.undo.command.impl.CeilingFanMediumCommand;
import com.command.thir.remote.undo.command.impl.CeilingFanOffCommand;
import com.command.thir.remote.undo.command.impl.LightOffCommand;
import com.command.thir.remote.undo.command.impl.LightOnCommand;
import com.command.thir.remote.undo.invoker.RemoteControlWithUndo;
import com.command.thir.remote.undo.receiver.CeilingFan;
import com.command.thir.remote.undo.receiver.Light;

public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
 
		Light livingRoomLight = new Light("Living Room");
 
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
 
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
 
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.undoButtonWasPushed();
		remoteControl.undoButtonWasPushed();

		
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		//一下三个命令都是针对同一个吊扇对象
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
  
		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
   
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
  
		remoteControl.onButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}
}
