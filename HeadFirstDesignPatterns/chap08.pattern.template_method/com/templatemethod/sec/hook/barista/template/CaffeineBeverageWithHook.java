package com.templatemethod.sec.hook.barista.template;

/**
 * 
 * @Package: com.templatemethod.sec.hook.barista
 * @ClassName: CaffeineBeverageWithHook.java
 *
 * @Description: 咖啡因饮料超类, 定义了Hook(钩子)方法
 * 				   钩子是一种被声明在抽象类中的方法, 但只有空的或默认的实现
 * 				   钩子的存在可以让子类有能力对算法的不同点进行挂钩
 * 				   要不要挂钩由子类决定
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月18日 下午3:11:09
 * @UpdateDate: 2017年12月18日 下午3:11:09
 * @Version: V1.0
 */
public abstract class CaffeineBeverageWithHook {
	
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
			
			/**
			 * 钩子是一种被声明在抽象类中的方法, 但只有空的或默认的实现  
			 * 钩子的存在可以让子类有能力对算法的不同点进行挂钩 
			 * 要不要挂钩由子类决定
			 */
			if (this.customerWantsCondiments()) {
				//加调料
				this.addCondiments();
				Thread.sleep(2000);
			}
			
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
	
	/**
	 * 
	 * @Title: customerWantsCondiments
	 * @Description: hook(钩子)方法, 默认不做事的方法
	 * 				 子类可以视情况决定要不要覆盖它
	 * 
	 * 				钩子是一种被声明在抽象类中的方法, 但只有空的或默认的实现  
	 * 				钩子的存在可以让子类有能力对算法的不同点进行挂钩  
	 * 				要不要挂钩由子类决定
	 * 
	 * 				即 钩子 能够作为条件控制, 影响抽象类中的算法流程
	 * 				 
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: boolean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年12月18日 下午3:41:45
	 * @ChangeDate: 2017年12月18日 下午3:41:45
	 * @Author: ZCX
	 */
	protected boolean customerWantsCondiments() {
		return true;
	}
	
}
