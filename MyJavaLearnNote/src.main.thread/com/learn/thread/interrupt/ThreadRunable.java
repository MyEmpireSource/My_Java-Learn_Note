package com.learn.thread.interrupt;

public class ThreadRunable implements Runnable {

	private int id;
	private boolean flag = true;
	
	public ThreadRunable(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println();
		System.out.println("---------- " + id + " ----------");
		while (flag) {
			System.out.println();
			System.out.println("***** " + id + " ***** " + Thread.currentThread().getId() + " " +  Thread.currentThread().isInterrupted());
			System.out.println();
			try {
				//Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(this.getId() + " ^^^^^^ 线程异常 ：" + e.getMessage());
				this.stop();
			}
		}
		System.out.println("##### " + id + " ##### " + Thread.currentThread().getId() + " " +  Thread.currentThread().isInterrupted());
//		
		System.out.println();
		System.out.println();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void stop() {
		this.setFlag(false);
	}
}
