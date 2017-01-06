package com.learn.thread.exception.handler;

public class Test {
	
	public static void main(String[] args) {
		
		Thread test = new Thread(new ThreadRunable());
		test.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		test.start();
		System.out.println("*** T-Id : " + test.getId() + ", T-Name : " + test.getName() + ", T-IS-Interrupted : " + test.isInterrupted() + ", T-State : " + test.getState());
	}
	
}
