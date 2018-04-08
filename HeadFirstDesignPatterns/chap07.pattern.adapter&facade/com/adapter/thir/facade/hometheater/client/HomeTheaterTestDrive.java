package com.adapter.thir.facade.hometheater.client;

import com.adapter.thir.facade.hometheater.component.Amplifier;
import com.adapter.thir.facade.hometheater.component.CdPlayer;
import com.adapter.thir.facade.hometheater.component.DvdPlayer;
import com.adapter.thir.facade.hometheater.component.PopcornPopper;
import com.adapter.thir.facade.hometheater.component.Projector;
import com.adapter.thir.facade.hometheater.component.Screen;
import com.adapter.thir.facade.hometheater.component.TheaterLights;
import com.adapter.thir.facade.hometheater.component.Tuner;
import com.adapter.thir.facade.hometheater.facade.HomeTheaterFacade;

public class HomeTheaterTestDrive {
	public static void main(String[] args) throws InterruptedException {
		Amplifier amp = new Amplifier("Top-O-Line Amplifier");
		Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
		DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
		CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
		Projector projector = new Projector("Top-O-Line Projector", dvd);
		TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
		Screen screen = new Screen("Theater Screen");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");
 
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
 
		homeTheater.watchMovie("Raiders of the Lost Ark");
		
		Thread.sleep(3000);
		homeTheater.endMovie();
	}
}
