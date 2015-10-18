package com.weather.station.java.api.display.impl;

import java.util.Observable;
import java.util.Observer;

import com.weather.station.java.api.WeatherData;
import com.weather.station.java.api.display.DisplayElement;

/**
 * 
 * @Package: com.weather.station.java.api.display.impl 
 * @ClassName: HeatIndexDisplay
 * 
 * @Description: 酷热指数布告板
 * 实现 java.util.Observer接口, 自定义update()方法
 *
 * @Company: ZCX&Empire 
 * @Author: ZCX
 * @CreateDate: 2015年10月18日 下午1:59:46 
 * @ChangeDate: 2015年10月18日 下午1:59:46 
 *
 */
public class HeatIndexDisplay implements Observer, DisplayElement {
	float heatIndex = 0.0f;

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
	 * @CreateDate: 2015年10月18日 下午2:00:03 
	 * @ChangeDate: 2015年10月18日 下午2:00:03 
	 * @Author: ZCX
	 *
	 */
	public HeatIndexDisplay(Observable observable) {
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
	 * @CreateDate: 2015年10月18日 下午2:00:24 
	 * @ChangeDate: 2015年10月18日 下午2:00:24 
	 * @Author: ZCX
	 *
	 */
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			float t = weatherData.getTemperature();
			float rh = weatherData.getHumidity();
			this.heatIndex = (float)
				(
				(16.923 + (0.185212 * t)) + 
				(5.37941 * rh) - 
				(0.100254 * t * rh) + 
				(0.00941695 * (t * t)) + 
				(0.00728898 * (rh * rh)) + 
				(0.000345372 * (t * t * rh)) - 
				(0.000814971 * (t * rh * rh)) +
				(0.0000102102 * (t * t * rh * rh)) - 
				(0.000038646 * (t * t * t)) + 
				(0.0000291583 * (rh * rh * rh)) +
				(0.00000142721 * (t * t * t * rh)) + 
				(0.000000197483 * (t * rh * rh * rh)) - 
				(0.0000000218429 * (t * t * t * rh * rh)) +
				(0.000000000843296 * (t * t * rh * rh * rh)) -
				(0.0000000000481975 * (t * t * t * rh * rh * rh)));
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
	 * @CreateDate: 2015年10月18日 下午2:01:01 
	 * @ChangeDate: 2015年10月18日 下午2:01:01 
	 * @Author: ZCX
	 *
	 */
	public void display() {
		System.out.println("Heat index is " + heatIndex);
	}
}
