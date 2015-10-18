package com.weather.station.java.api;

import java.util.Observable;

/**
 * 
 * @Package: com.weather.station.java.api 
 * @ClassName: WeatherData
 * 
 * @Description: 使用JAVA内置的观察者模式(java api)实现气象站
 * 
 * 主题需要继承 java.util.Observable
 * 观察者实现接口 java.util.Observer
 * 该API支持 推(push)或拉(pull)的方式
 * 
 * Observable追踪所用观察者并通知它们
 * 
 * java.util.Observable 使用方法：
 * 1，先调用setChanged()方法， 标记状态已经改变
 * 2，然后调用两种notifyObservers()方法中的一个
 * 
 * @Company: ZCX&Empire 
 * @Author: ZCX
 * @CreateDate: 2015年10月18日 上午3:22:20 
 * @ChangeDate: 2015年10月18日 上午3:22:20 
 *
 */
public class WeatherData extends Observable {

	private float temperature;
	private float humidity;
	private float pressure;
	
	/**
	 * 
	 * @Description: 
	 * 使用JAVA内置的模式，不需要专门建立数据机构来记录观察者
	 * 在父类Observale中有记录
	 * 
	 * @Param: 
	 *
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午12:03:57 
	 * @ChangeDate: 2015年10月18日 下午12:03:57 
	 * @Author: ZCX
	 *
	 */
	public WeatherData() {
	}
	
	/**
	 * 
	 * @Title: measurementsChanged
	 * @Description: 气象站得到更新气象值时，将调用 该方法
	 * 
	 * @Param: 
	 *
	 * @Return void
	 * 
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午12:10:23 
	 * @ChangeDate: 2015年10月18日 下午12:10:23 
	 * @Author: ZCX
	 *
	 */
	public void measurementsChanged() {
		this.setChanged();
		/**
		 * 通知方法没有参数(没有推送(push)数据)， 表示观察者采用拉(pull)的方式获取数据
		 */
		this.notifyObservers();
	}

	/**
	 * 
	 * @Title: setMeasurements
	 * @Description: 
	 * 模拟气象站抓取数据, 数据发生变化是, 将调用measurementsChanged方法
	 * 
	 * @Param: @param temperature
	 * @Param: @param humidity
	 * @Param: @param pressure
	 *
	 * @Return void
	 * 
	 * @Throws
	 *
	 * @CreateDate: 2015年10月18日 下午12:07:47 
	 * @ChangeDate: 2015年10月18日 下午12:07:47 
	 * @Author: ZCX
	 *
	 */
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
}