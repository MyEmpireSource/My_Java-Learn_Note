package com.learn.thread.synch.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Package: com.learn.thread.synch.unsynch
 * @ClassName: Bank.java
 *
 * @Description: 模拟有多个账号的银行
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年4月20日 下午3:45:30
 * @UpdateDate: 2016年4月20日 下午3:45:30
 * @Version: V1.0
 */
public class Bank {
	
	 private final double[] accounts;
	 private Lock bankLock;	//ReentrantLock实现了Lock接口
	 private Condition sufficientFunds; //条件对象
	 
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
	  * @CreateDate: 2016年4月20日 下午3:49:38
	  * @ChangeDate: 2016年4月20日 下午3:49:38
	  * @Author: 李立
	  */
	 public Bank(int n, double initialBalance) {
		 accounts = new double[n];
		 for (int i = 0; i < accounts.length; ++i) {
			 accounts[i] = initialBalance;
		 }
		 this.bankLock = new ReentrantLock();	//ReentrantLock实现了Lock接口;
		 this.sufficientFunds = this.bankLock.newCondition();
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
	  * @CreateDate: 2016年4月20日 下午3:54:20
	  * @ChangeDate: 2016年4月20日 下午3:54:20
	  * @Author: 李立
	  */
	 public double getTotalBalance() {
		 
		 //锁是可重入的，因为线程可以重复地获得已经持有的锁。
		 //锁保持一个持有计数（hold count）来跟踪对lock方法的嵌套调用。
		 //线程在每一次调用lock都要调用unlock来释放锁。
		 //由于这一特性，被一个锁保护的代码可以调用另一个使用相同的锁的方法
		 
		 //transfer方法调用getTotalBalance方法，这也会封锁bankLock对象，此时bankLock对象的持有计数为2。
		 //当getTotalBalance方法退出的时候，持有计数变回1。当transfer方法退出的时候，持有计数变为0。线程释放锁
		 this.bankLock.lock();
		 try {
			 double sum = 0;
	
			 for (double a : accounts) {
				 sum += a;
			 }
			 return sum;
		 } finally {
			 this.bankLock.unlock();
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
	  * @CreateDate: 2016年4月20日 下午4:04:35
	  * @ChangeDate: 2016年4月20日 下午4:04:35
	  * @Author: 李立
	  */
	 public int size() {
		 return this.accounts.length;
	 }
	 
	 /**
	  * 
	  * @Title: transfer
	  * @Description: 账户之间转账入账
	  * 
	  * @Params:
	  *   @param from 转出账户
	  *   @param to	    入账账户
	  *   @param amount 转账金额
	  *
	  * @Return: void
	  * 
	  * @Throws:
	  *
	  * @CreateDate: 2016年4月20日 下午3:55:11
	  * @ChangeDate: 2016年4月20日 下午3:55:11
	  * @Author: 李立
	  */
	 public void transfer(int from, int to, double amount) {
		 
		 this.bankLock.lock();
		 try {
			 while (accounts[from] < amount) {
				 System.out.printf(Thread.currentThread() + "  " + Thread.currentThread().getState() + " ********************************* accounts[" + from + "] = " + this.accounts[from] + " < " + amount);
				 this.sufficientFunds.await();
				 System.out.println("");
			 }
			 
			 System.out.println(Thread.currentThread());
			 this.accounts[from] -= amount;
			 System.out.printf(" %10.2f from %d to %d", amount, from, to);
			 this.accounts[to] += amount;
		     System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		     this.sufficientFunds.signalAll();
		     //this.sufficientFunds.signal();
		 } catch (InterruptedException e) {
			 System.out.println("Condition Exception : " + e.getMessage());
		 } finally {
			 this.bankLock.unlock();
		 }
	 }
	 
}
