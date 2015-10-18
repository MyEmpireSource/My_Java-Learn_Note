package com.starbucks.drink;

public abstract class Beverage {
	private String description = "Unknown Beverage";
	
	public abstract double cost();
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
