package com.templatemethod.first.barista.template;

/**
 * 
 * @Package: com.templatemethod.first.barista.template
 * @ClassName: CaffeineBeverage.java
 *
 * @Description: 咖啡因饮料超类
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月18日 下午2:52:44
 * @UpdateDate: 2017年12月18日 下午2:52:44
 * @Version: V1.0
 */
public abstract class CaffeineBeverage {
	
	/**
	 * 
	 * @Title: prepareRecipe
	 * @Description: 模板方法, 定义冲泡咖啡因饮料的算法(步骤)
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年12月18日 下午2:55:33
	 * @ChangeDate: 2017年12月18日 下午2:55:33
	 * @Author: ZCX
	 */
	public final void prepareRecipe() {
		try {
			//烧水
			this.boilWater();
			Thread.sleep(2000);
			
			//冲泡
			this.brew();
			Thread.sleep(2000);
			
			//把饮料倒进杯子
			this.pourInCup();
			Thread.sleep(2000);
			
			//加调料
			this.addCondiments();
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//冲泡, 子类自己实现
	protected abstract void brew();
	
	//加调料, 子类根据实际自己实现
	protected abstract void addCondiments();
	
	//烧水
	protected void boilWater() {
		System.out.println("Boiling water");
	}
  
	//把饮料倒进杯子
	protected void pourInCup() {
		System.out.println("Pouring into cup");
	}
	
}
