package com.weather.station.my.display.impl;

import com.weather.station.my.display.DisplayElement;
import com.weather.station.my.observer.MyObserver;
import com.weather.station.my.subject.MySubject;

/**
 * 当前状况布告板
 * 此布告板实现了MyObserver接口， 可以从WeatherData中获取改变
 * 此布告板实现了DisplayElement接口,
 * @author ZCX
 *
 */
public class CurrentConditionsDisplay implements MyObserver, DisplayElement {
	
	private float temperature;
	private float humidity;
	//引入Subject对象，方便以后用到，比如注销
	private MySubject weatherData;
	
	/**
	 * 
	 * @param weatherDate 用主题对象作为注册之用
	 */
	public CurrentConditionsDisplay(MySubject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + this.temperature + "F degrees and " + this.humidity + "% humidity...");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.display();
	}

}
