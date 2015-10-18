package com.weather.station.my.display.impl;

import com.weather.station.my.WeatherData;
import com.weather.station.my.display.DisplayElement;
import com.weather.station.my.observer.MyObserver;

/**
 * 预报布告板
 * @author ZCX
 *
 */
public class ForecastDisplay implements MyObserver, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
        this.lastPressure = currentPressure;
		this.currentPressure = pressure;

		display();
	}

	public void display() {
		System.out.print("Forecast: ");
		if (this.currentPressure > this.lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (this.currentPressure == this.lastPressure) {
			System.out.println("More of the same");
		} else if (this.currentPressure < this.lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}
