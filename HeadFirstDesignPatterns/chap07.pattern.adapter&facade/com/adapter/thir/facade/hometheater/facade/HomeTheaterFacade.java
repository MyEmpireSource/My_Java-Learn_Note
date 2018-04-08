package com.adapter.thir.facade.hometheater.facade;

import com.adapter.thir.facade.hometheater.component.Amplifier;
import com.adapter.thir.facade.hometheater.component.CdPlayer;
import com.adapter.thir.facade.hometheater.component.DvdPlayer;
import com.adapter.thir.facade.hometheater.component.PopcornPopper;
import com.adapter.thir.facade.hometheater.component.Projector;
import com.adapter.thir.facade.hometheater.component.Screen;
import com.adapter.thir.facade.hometheater.component.TheaterLights;
import com.adapter.thir.facade.hometheater.component.Tuner;

public class HomeTheaterFacade {
	private Amplifier amp;
	private Tuner tuner;
	private DvdPlayer dvd;
	private CdPlayer cd;
	private Projector projector;
	private TheaterLights lights;
	private Screen screen;
	private PopcornPopper popper;
 
	public HomeTheaterFacade(Amplifier amp, 
				 Tuner tuner, 
				 DvdPlayer dvd, 
				 CdPlayer cd, 
				 Projector projector, 
				 Screen screen,
				 TheaterLights lights,
				 PopcornPopper popper) {
 
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.screen = screen;
		this.lights = lights;
		this.popper = popper;
	}
 
	public void watchMovie(String movie) throws InterruptedException {
		System.out.println("Get ready to watch a movie...");
		popper.on();
		Thread.sleep(600);
		
		popper.pop();
		Thread.sleep(600);
		
		lights.dim(10);
		Thread.sleep(600);
		
		screen.down();
		Thread.sleep(600);
		
		projector.on();
		Thread.sleep(600);
		
		projector.wideScreenMode();
		Thread.sleep(600);
		
		amp.on();
		Thread.sleep(600);
		
		amp.setDvd(dvd);
		Thread.sleep(600);
		
		amp.setSurroundSound();
		Thread.sleep(600);
		
		amp.setVolume(5);
		Thread.sleep(600);
		
		dvd.on();
		Thread.sleep(600);
		
		dvd.play(movie);
	}
 
 
	public void endMovie() throws InterruptedException {
		System.out.println("Shutting movie theater down...");
		popper.off();
		Thread.sleep(600);
		
		lights.on();
		Thread.sleep(600);
		
		screen.up();
		Thread.sleep(600);
		
		projector.off();
		Thread.sleep(600);
		
		amp.off();
		Thread.sleep(600);
		
		dvd.stop();
		Thread.sleep(600);
		
		dvd.eject();
		Thread.sleep(600);
		
		dvd.off();
	}

	public void listenToCd(String cdTitle) {
		System.out.println("Get ready for an audiopile experence...");
		lights.on();
		amp.on();
		amp.setVolume(5);
		amp.setCd(cd);
		amp.setStereoSound();
		cd.on();
		cd.play(cdTitle);
	}

	public void endCd() {
		System.out.println("Shutting down CD...");
		amp.off();
		amp.setCd(cd);
		cd.eject();
		cd.off();
	}

	public void listenToRadio(double frequency) {
		System.out.println("Tuning in the airwaves...");
		tuner.on();
		tuner.setFrequency(frequency);
		amp.on();
		amp.setVolume(5);
		amp.setTuner(tuner);
	}

	public void endRadio() {
		System.out.println("Shutting down the tuner...");
		tuner.off();
		amp.off();
	}
}