package com.weather.station.my.subject;

import com.weather.station.my.observer.MyObserver;

public interface MySubject {
	/**
	 * 注册个观察者
	 * @param observer
	 */
	public void registerObserver(MyObserver observer);
	
	/**
	 * 观察者取消注册
	 * @param observer
	 */
	public void removeObserver(MyObserver observer);
	
	/**
	 * 通知观察者
	 */
	public void notifyObservers();
}
