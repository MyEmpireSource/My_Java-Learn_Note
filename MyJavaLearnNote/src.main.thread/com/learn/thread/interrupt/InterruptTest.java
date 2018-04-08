package com.learn.thread.interrupt;

/**
 * 
 * @Package: com.learn.thread.interrupt
 * @ClassName: InterruptTest.java
 *
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年4月12日 下午5:38:42
 * @UpdateDate: 2016年4月12日 下午5:38:42
 * @Version: V1.0
 */
public class InterruptTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread listenerThread = new Thread(new ListenerThreadRunnable(-1));
		//listenerThread.start();
		
		
		for (int i = 0; i < 20; ++i) {
			ListenerThreadRunnable.addThread(new Thread(new ThreadRunable(i)));
		}
		
		listenerThread.start();
		
		for (Thread t : ListenerThreadRunnable.getListeneringThread()) {
			t.start();
		}
		
		Thread.sleep(2000);
		for (Thread t : ListenerThreadRunnable.getListeneringThread()) {
			t.interrupt();
			
		}
		
		Thread.sleep(3000);
		
		System.out.println("000000000000000000000000000000000000000000000000000000000000000");
	}

}
