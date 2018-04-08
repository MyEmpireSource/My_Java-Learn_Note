package com.adapter.first.turkey.duck.adapter;

import com.adapter.first.turkey.duck.component.Duck;
import com.adapter.first.turkey.duck.component.Turkey;

/**
 * 
 * @Package: com.adapter.first.turkey.duck.adapter
 * @ClassName: TurkeyAdapter.java
 *
 * @Description: 火鸡适配器, 把火鸡转成鸭子
 * 				  
 * 				   首先, 需要实现想转换成的类型接口, 也就是你的客户所期望看到的接口
 * 				   接着, 需要取得要适配的对象引用, 这里我们用构造器取得这个引用现在, 
 * 				   第三, 我们需要实现接口中所有的方法:
 * 					  quack()在类之间的转换很简单 只要调用gooble()就可以了
 * 					      
 * 					      虽然两个接口都具备了fly()方法, 火鸡的飞行距离很短不像鸭子可以长途飞行。
 *                    要让火鸡的飞行能够和鸭子的飞行能够对应。必须连续 5 次调用火鸡的fly()来完成
 * 
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月7日 下午2:24:08
 * @UpdateDate: 2017年12月7日 下午2:24:08
 * @Version: V1.0
 */
public class TurkeyAdapter implements Duck {

	private Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		this.turkey.gobble();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		//要让火鸡的飞行能够和鸭子的飞行能够对应。必须连续 5 次调用火鸡的fly()来完成
		//根据需要来实现逻辑
		for (int i = 0; i < 5; i++) {
			this.turkey.shortFly();
		}
	}

}
