package com.weather.station.java.api;

import java.util.Random;

import com.weather.station.java.api.display.impl.CurrentConditionsDisplay;
import com.weather.station.java.api.display.impl.ForecastDisplay;
import com.weather.station.java.api.display.impl.HeatIndexDisplay;
import com.weather.station.java.api.display.impl.StatisticsDisplay;

/**
 * 
 * @Package: com.weather.station.java.api 
 * @ClassName: WeatherStation
 * 
 * @Description: 气象站类 
 *
 * @Company: ZCX&Empire 
 * @Author: ZCX
 * @CreateDate: 2015年10月18日 下午2:03:27 
 * @ChangeDate: 2015年10月18日 下午2:03:27 
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
