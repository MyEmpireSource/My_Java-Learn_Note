package com.adapter.thir.facade.hometheater.component;

public class TheaterLights {
	private String description;
	
	public TheaterLights(String description) {
		this.description = description;
	}
  
	public void on() {
		System.out.println(description + " on");
	}
  
	public void off() {
		System.out.println(description + " off");
	}
  
	public void dim(int level) {
		System.out.println(description + " dimming to " + level  + "%");
	}
   
        public String toString() {
                return description;
        }
}
