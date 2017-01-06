package com.learn.thread.synch.lock;

/**
 * 
 * @Package: com.learn.thread.synch.unsynch
 * @ClassName: TransferRunnable.java
 *
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年4月20日 下午4:23:36
 * @UpdateDate: 2016年4月20日 下午4:23:36
 * @Version: V1.0
 */
public class TransferRunnable implements Runnable {

	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
	
	/**
	 * 
	 * @Description: TODO(用一句话描述该文件做什么)
	 * 
	 * @Params:
	 * @param bank
	 * @param fromAccount 转出账户
	 * @param 每次转账最大的金额
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2016年4月20日 下午4:34:34
	 * @ChangeDate: 2016年4月20日 下午4:34:34
	 * @Author: 李立
	 */
	public TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
		super();
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			 while (true) {
				//转入账户随机
				int toAccount = (int) (bank.size() * Math.random());
				double amount = this.maxAmount * Math.random();
				this.bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
				//Thread.sleep(10000);
			 }
		} catch (InterruptedException e) {
			
		}
	}

}

















