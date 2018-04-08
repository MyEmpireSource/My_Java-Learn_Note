package com.command.sec.remote.client;

import com.command.sec.remote.command.impl.CeilingFanOffCommand;
import com.command.sec.remote.command.impl.CeilingFanOnCommand;
import com.command.sec.remote.command.impl.GarageDoorDownCommand;
import com.command.sec.remote.command.impl.GarageDoorUpCommand;
import com.command.sec.remote.command.impl.HottubOffCommand;
import com.command.sec.remote.command.impl.HottubOnCommand;
import com.command.sec.remote.command.impl.LightOffCommand;
import com.command.sec.remote.command.impl.LightOnCommand;
import com.command.sec.remote.command.impl.StereoOffCommand;
import com.command.sec.remote.command.impl.StereoOnWithCDCommand;
import com.command.sec.remote.command.impl.TVOffCommand;
import com.command.sec.remote.command.impl.TVOnCommand;
import com.command.sec.remote.invoker.RemoteControl;
import com.command.sec.remote.recevier.CeilingFan;
import com.command.sec.remote.recevier.GarageDoor;
import com.command.sec.remote.recevier.Hottub;
import com.command.sec.remote.recevier.Light;
import com.command.sec.remote.recevier.Stereo;
import com.command.sec.remote.recevier.TV;

public class RemoteLoader {
	
	public static void main(String[] args) throws InterruptedException {
		RemoteControl remoteControl = new RemoteControl();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan= new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();
		TV rootTv = new TV("Room TV");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		
		CeilingFanOnCommand ceilingFanOn =  new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff =  new CeilingFanOffCommand(ceilingFan);
 
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
 
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand  stereoOff = new StereoOffCommand(stereo);
		
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);
		
		TVOnCommand roomTvOn = new TVOnCommand(rootTv);
		TVOffCommand roomTvOff = new TVOffCommand(rootTv);
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
		remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
		remoteControl.setCommand(4, hottubOn, hottubOff);
		remoteControl.setCommand(5, roomTvOn, roomTvOff);
  
		System.out.println(remoteControl);
 
		remoteControl.onButtonWasPushed(0);
		Thread.sleep(1000);
		remoteControl.offButtonWasPushed(0);
		Thread.sleep(1000);
		
		remoteControl.onButtonWasPushed(1);
		Thread.sleep(1000);
		remoteControl.offButtonWasPushed(1);
		Thread.sleep(1000);
		
		remoteControl.onButtonWasPushed(2);
		Thread.sleep(1000);
		remoteControl.offButtonWasPushed(2);
		Thread.sleep(1000);
		
		remoteControl.onButtonWasPushed(3);
		Thread.sleep(1000);
		remoteControl.offButtonWasPushed(3);
		
		Thread.sleep(1000);
		remoteControl.onButtonWasPushed(4);
		Thread.sleep(1000);
		remoteControl.onButtonWasPushed(5);
		Thread.sleep(1000);
		remoteControl.offButtonWasPushed(5);
		Thread.sleep(1000);
		remoteControl.offButtonWasPushed(4);
	}
	
}
