package com.weather.station.java.api.display.impl;

import java.util.Observable;
import java.util.Observer;

import com.weather.station.java.api.WeatherData;
import com.weather.station.java.api.display.DisplayElement;

/**
 * 
 * @Package: com.weather.station.java.api.display.impl 
 * @ClassName: StatisticsDisplay
 * 
 * @Description: 统计布告板
 * 
 * 实现 java.util.Observer接口, 自定义update()方法
 *
 * @Company: ZCX&Empire 
 * @Author: ZCX
 * @CreateDate: 2015年10月18日 下午12:19:30 
 * @ChangeDate: 2015年10月18日 下午12:19:30 
 *
 */
public class StatisticsDisplay implements DisplayElement, Observer {
	private Observable observable;
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private int numReadings;
	
	/**
	 * 
	 * @Description: 初始化布告板，同事将布告板注册到主题中(WeatherData)
	 * 
	 * @Params: 
	 * @param observable 主题对象
	 *
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午12:25:57 
	 * @ChangeDate: 2015年10月18日 下午12:25:57 
	 * @Author: ZCX
	 *
	 */
	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		//将该布告板注册为观察者
		this.observable.addObserver(this);
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
	 * @param o 主题对象
	 * @param arg 主题发回的数据, 该布告板实现中, 使用拉的方式, 该参数为NULL
	 *
	 * @Return 
	 * 
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午12:34:19 
	 * @ChangeDate: 2015年10月18日 下午12:34:19 
	 * @Author: ZCX
	 *
	 */
	public void update(Observable o, Object arg) {
		/**
		 * 确定主题为WeatherData
		 * 后拉取数据
		 */
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			
			float temp = weatherData.getTemperature();
			this.tempSum += temp;
			++this.numReadings;
			
			if (temp > this.maxTemp) {
				this.maxTemp = temp;
			}
			
			if (temp < this.minTemp) {
				this.minTemp = temp;
			}
			
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
	 * @CreateDate: 2015年10月18日 下午1:36:56 
	 * @ChangeDate: 2015年10月18日 下午1:36:56 
	 * @Author: ZCX
	 *
	 */
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
				+ "/" + maxTemp + "/" + minTemp);
	}

}
