package com.weather.station.my.display.impl;

import com.weather.station.my.WeatherData;
import com.weather.station.my.display.DisplayElement;
import com.weather.station.my.observer.MyObserver;

/**
 * 统计布告板
 * @author ZCX
 *
 */
public class StatisticsDisplay implements DisplayElement, MyObserver {
	
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private int numReadings;
	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.tempSum += temp;
		this.numReadings++;
		
		if (temp > this.maxTemp) {
			this.maxTemp = temp;
		}
		
		if (temp < this.minTemp) {
			this.minTemp = temp;
		}
		
		this.display();
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
				+ "/" + maxTemp + "/" + minTemp);
	}

}
