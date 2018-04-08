package com.adapter.first.turkey.duck.adapter;
import java.util.Random;

import com.adapter.first.turkey.duck.component.Duck;
import com.adapter.first.turkey.duck.component.Turkey;

/**
 * 
 * @Package: com.adapter.first.turkey.duck.adapter
 * @ClassName: DuckAdapter.java
 *
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月7日 下午2:31:52
 * @UpdateDate: 2017年12月7日 下午2:31:52
 * @Version: V1.0
 */
public class DuckAdapter implements Turkey {
	private Duck duck;
	private Random rand;
 
	public DuckAdapter(Duck duck) {
		this.duck = duck;
		this.rand = new Random();
	}
    
	public void gobble() {
		this.duck.quack();
	}
  
	public void shortFly() {
		//根据需要来实现逻辑
		if (this.rand.nextInt(5)  == 0) {
		     this.duck.fly();
		}
	}
}
