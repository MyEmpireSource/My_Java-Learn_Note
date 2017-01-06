package com.learn.thread.synch.synchronize;

/**
 * 
 * @Package: com.learn.thread.synch.synchronize
 * @ClassName: Bank.java
 *
 * @Description: 模拟有多个账号的银行
 * 
 * @Company:
 * @Author: 李立    
 * @CreateDate: 2016年4月30日 下午4:11:06
 * @UpdateDate: 2016年4月30日 下午4:11:06
 * @Version: V1.0
 */
public class Bank {
	private final double[] accounts;
	
	/**
	 * 
	 * @Description: 初始化
	  * 
	  * @Params:
	  *   @param n 账户数量
	  *   @param initialBalance 每个账户的初始金额
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2016年4月30日 下午4:16:45
	 * @ChangeDate: 2016年4月30日 下午4:16:45
	 * @Author: 李立
	 */
	public Bank(int n, double initialBalance) {
		this.accounts = new double[n];
		for (int i = 0; i < this.accounts.length; ++i) {
			this.accounts[i] = initialBalance;
		}
	}
	
	/**
	 * 
	 * @Title: size
	 * @Description: 获取银行账户数量
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: int
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年4月30日 下午4:17:49
	 * @ChangeDate: 2016年4月30日 下午4:17:49
	 * @Author: 李立
	 */
	public int size() {
		return this.accounts.length;
	}
	
	/**
	 * 
	 * @Title: getTotalBalance
	 * @Description: 获取所有账户的总金额
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: double
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年4月30日 下午4:19:56
	 * @ChangeDate: 2016年4月30日 下午4:19:56
	 * @Author: 李立
	 */
	public synchronized double getTotalBalance() {
		double sum = 0;
		
		for (double a : this.accounts) {
			sum += a;
		}
		
		return sum;
	}
	
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
		while (this.accounts[from] < amount) {
			
			System.out.printf("synchronized --> " + Thread.currentThread() + "  " + Thread.currentThread().getState() + " ********************************* accounts[" + from + "] = " + this.accounts[from] + " < " + amount);
			
			//每一个对象有一个内部锁，并且该锁有一个内部条件
			//由锁来管理那些试图进入synchronized方法的线程，由条件来管理那些调用wait的线程
			this.wait();
		}
		
		System.out.print("synchronized --> " + Thread.currentThread());
		this.accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		this.accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		notifyAll();
		//this.notify();
	}
}
