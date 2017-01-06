package com.learn.thread.synch.lock;

/**
 * 
 * @Package: com.learn.thread.synch.unsynch
 * @ClassName: UnsynchBankTest.java
 *
 * @Description: 非同步线程测试类
 * 				 同一时间，总金额不对
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年4月20日 下午4:37:28
 * @UpdateDate: 2016年4月20日 下午4:37:28
 * @Version: V1.0
 */
public class SynchBankWithLockTest {

	 public static final int NACCOUNTS = 100;
	 public static final double INITIAL_BALANCE = 1000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}

}
