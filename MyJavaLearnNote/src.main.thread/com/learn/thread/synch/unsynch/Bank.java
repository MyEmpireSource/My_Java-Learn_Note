package com.learn.thread.synch.unsynch;

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
	 public double getTotalBalance(){
		 double sum = 0;

		 for (double a : accounts) {
			 sum += a;
		 }
		 return sum;
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
		 if (accounts[from] < amount) {
			 return;
		 }
		 
		 System.out.println(Thread.currentThread());
		 accounts[from] -= amount;
		 System.out.printf(" %10.2f from %d to %d", amount, from, to);
	     accounts[to] += amount;
	     System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
	 }
	 
}





















