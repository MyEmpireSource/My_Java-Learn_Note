package com.learn.thread.interrupt;

import java.util.ArrayList;
import java.util.List;

public class ListenerThreadRunnable implements Runnable {

	private static List<Thread> THREAD_LIST = new ArrayList<Thread> ();
	
	private int id;
	private boolean flag = true;
	
	public ListenerThreadRunnable(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while (this.flag) {
				showThreadInfo();
				System.out.println();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("监听线程异常 ：" + e.getMessage());
			this.stop();
		}
		
	}

	public void stop() {
		this.flag = false;
	}
	
	private void showThreadInfo() {
		
		if (ListenerThreadRunnable.THREAD_LIST == null || ListenerThreadRunnable.THREAD_LIST.size() <= 0) {
			System.out.println("No Thread To Listener!!!");
		} else {
			for (Thread t : ListenerThreadRunnable.THREAD_LIST) {
				System.out.println("T-Id : " + t.getId() + ", T-Name : " + t.getName() + ", T-IS-Interrupted : " + t.isInterrupted() + ", T-State : " + t.getState());
			}
		}
	}
	
	public static void addThread(Thread t) {
		ListenerThreadRunnable.THREAD_LIST.add(t);
	}
	
	public static List<Thread> getListeneringThread() {
		return ListenerThreadRunnable.THREAD_LIST;
	}
}
