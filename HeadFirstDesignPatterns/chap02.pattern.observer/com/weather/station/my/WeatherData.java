package com.weather.station.my;

import java.util.ArrayList;
import java.util.List;

import com.weather.station.my.observer.MyObserver;
import com.weather.station.my.subject.MySubject;

public class WeatherData implements MySubject {
	
	private List<MyObserver> observerList;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		this.observerList = new ArrayList<MyObserver> ();
	}
	
	private boolean isRegister(MyObserver observer) {
		
		if (this.observerList == null || this.observerList.size() <= 0) {
			return false;
		} else {
			return this.observerList.contains(observer);
		}
		
	}

	/**
	 * 注册个观察者
	 */
	public void registerObserver(MyObserver observer) {
		if (this.observerList != null && !this.isRegister(observer)) {
			this.observerList.add(observer);
		}
	}

	/**
	 * 注销观察者
	 */
	public void removeObserver(MyObserver observer) {
		if (this.observerList != null && this.observerList.size() > 0) {
			int i = this.observerList.indexOf(observer);
			if (i >= 0) {
				this.observerList.remove(i);
			}
		}
	}

	/**
	 * 通知观察者
	 */
	public void notifyObservers() {
		if (this.observerList != null && this.observerList.size() > 0) {
			for (MyObserver o : this.observerList) {
				o.update(this.temperature, this.humidity, this.pressure);
			}
		}
	}
	
	/**
	 * 气象站得到更新气象值时，将调用 该方法
	 * 在该方法中调用方法通知观察者
	 */
	public void measurementsChanged() {
		this.notifyObservers();
	}
	
	/**
	 * 模拟气象站抓取数据
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
		this.measurementsChanged();
	}

}
