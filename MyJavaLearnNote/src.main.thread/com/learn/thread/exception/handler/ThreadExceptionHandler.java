package com.learn.thread.exception.handler;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("Error ......");
		System.out.println("UncaughtExceptionHandler T-Id : " + thread.getId() + ", T-Name : " + thread.getName() + ", T-IS-Interrupted : " + thread.isInterrupted() + ", T-State : " + thread.getState());
		System.out.println("Error Message : " + e.getMessage());
		
		//
		thread = new Thread(new ThreadRunable());
		thread.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		thread.start();
		System.out.println("### T-Id : " + thread.getId() + ", T-Name : " + thread.getName() + ", T-IS-Interrupted : " + thread.isInterrupted() + ", T-State : " + thread.getState());
	}

}
