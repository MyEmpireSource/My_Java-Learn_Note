package com.learn.thread.exception.handler;

public class ThreadRunable implements Runnable {

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int i = 0;
		String time = System.currentTimeMillis() + "";
		
		while (true) {
			System.out.println(time + " " + i);
			
			if (i == 10) {
				i = 7 / 0;
			}
			
			++i;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Sleep Error : " + e);
			}
		}
		
	}

}
