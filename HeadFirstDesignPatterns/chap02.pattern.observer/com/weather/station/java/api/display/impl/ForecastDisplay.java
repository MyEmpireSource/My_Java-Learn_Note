package com.weather.station.java.api.display.impl;

import java.util.Observable;
import java.util.Observer;

import com.weather.station.java.api.WeatherData;
import com.weather.station.java.api.display.DisplayElement;

/**
 * 
 * @Package: com.weather.station.java.api.display.impl 
 * @ClassName: ForecastDisplay
 * 
 * @Description: 预报布告板
 * 实现 java.util.Observer接口, 自定义update()方法
 *
 * @Company: ZCX&Empire 
 * @Author: ZCX
 * @CreateDate: 2015年10月18日 下午1:55:57 
 * @ChangeDate: 2015年10月18日 下午1:55:57 
 *
 */
public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;

	/**
	 * 
	 * @Description: 初始化布告板，同事将布告板注册到主题中(WeatherData)
	 * 观察者可以不存储主题对象
	 * 
	 * @Params: 
	 * @param observable 主题对象
	 *
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午1:56:35 
	 * @ChangeDate: 2015年10月18日 下午1:56:35 
	 * @Author: ZCX
	 *
	 */
	public ForecastDisplay(Observable observable) {
		//将该布告板注册为观察者
		observable.addObserver(this);
	}

	/**
	 * 
	 * @Override
	 * @Title: update
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 *
	 * @Description: 主题发生变化时, 会调用观察者对象的该方法
	 * 
	 * @Params:
	 * @param observable 主题对象
	 * @param arg 主题发回的数据, 该布告板实现中, 使用拉的方式, 该参数为NULL
	 *
	 * @Return 
	 * 
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午1:57:50 
	 * @ChangeDate: 2015年10月18日 下午1:57:50 
	 * @Author: ZCX
	 *
	 */
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			this.lastPressure = this.currentPressure;
			this.currentPressure = weatherData.getPressure();
			this.display();
		}
	}

	/**
	 * 
	 * @Override
	 * @Title: display
	 * @see com.weather.station.java.api.display.DisplayElement#display()
	 *
	 * @Description: 
	 * 
	 * @Params:
	 *
	 * @Return 
	 * 
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午1:59:08 
	 * @ChangeDate: 2015年10月18日 下午1:59:08 
	 * @Author: ZCX
	 *
	 */
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}
