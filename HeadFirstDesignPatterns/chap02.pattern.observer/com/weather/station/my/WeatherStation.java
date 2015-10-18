package com.weather.station.my;

import java.util.Random;

import com.weather.station.my.display.impl.CurrentConditionsDisplay;
import com.weather.station.my.display.impl.ForecastDisplay;
import com.weather.station.my.display.impl.HeatIndexDisplay;
import com.weather.station.my.display.impl.StatisticsDisplay;

/**
 * 气象站类
 * @author ZCX
 *
 */
public class WeatherStation {
	
	public static void main(String[] args) throws InterruptedException {
		
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDispla = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDispaly = new HeatIndexDisplay(weatherData);
		/*
		weatherData.setMeasurements(80, 65, 30.4f);
		Thread.sleep(1000);
		weatherData.setMeasurements(82, 70, 29.2f);
		Thread.sleep(5000);
		weatherData.setMeasurements(78, 90, 29.2f);
		*/
		
		while (true) {
			Random random = new Random(System.currentTimeMillis());
			int i = random.nextInt(10);
			
			weatherData.setMeasurements(78.0f + i, 63.0f + i, 24.2f + i);
			System.out.println(); 
			System.out.println("Will sleep " + i + "'s.....");
			System.out.println();
			Thread.sleep(i * 1000);
		}
		
	}
}
