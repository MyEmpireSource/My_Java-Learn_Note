package com.command.four.remote.party.client;

import com.command.four.remote.party.command.Command;
import com.command.four.remote.party.command.impl.HottubOffCommand;
import com.command.four.remote.party.command.impl.HottubOnCommand;
import com.command.four.remote.party.command.impl.LightOffCommand;
import com.command.four.remote.party.command.impl.LightOnCommand;
import com.command.four.remote.party.command.impl.MacroCommand;
import com.command.four.remote.party.command.impl.StereoOffCommand;
import com.command.four.remote.party.command.impl.StereoOnCommand;
import com.command.four.remote.party.command.impl.TVOffCommand;
import com.command.four.remote.party.command.impl.TVOnCommand;
import com.command.four.remote.party.invoker.RemoteControl;
import com.command.four.remote.party.receiver.Hottub;
import com.command.four.remote.party.receiver.Light;
import com.command.four.remote.party.receiver.Stereo;
import com.command.four.remote.party.receiver.TV;

public class RemoteLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoteControl remoteControl = new RemoteControl();
		
		Light light = new Light("Living Room");
		TV tv = new TV("Living Room");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();
		
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		TVOnCommand tvOn = new TVOnCommand(tv);
		TVOffCommand tvOff = new TVOffCommand(tv);
		
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);
		
		Command[] partyOn = {lightOn, stereoOn, tvOn, hottubOn};
		Command[] partyOff = { lightOff, stereoOff, tvOff, hottubOff};
		
		Command partyOnMacro = new MacroCommand(partyOn);
		Command partyOffMacro = new MacroCommand(partyOff);
		
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
		
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
		
		System.out.println("--- Pushing undo On---");
		remoteControl.undoButtonWasPushed();
		System.out.println("--- Pushing undo On---");
		remoteControl.undoButtonWasPushed();
	}

}
