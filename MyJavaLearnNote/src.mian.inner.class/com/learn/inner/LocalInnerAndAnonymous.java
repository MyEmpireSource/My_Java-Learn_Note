package com.learn.inner;

/**
 * 
 * @Package: com.learn.inner
 * @ClassName: LocalInnerAndAnonymous.java
 *
 * @Description: 局部内部类和匿名内部类的区别详解
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2016年11月1日 下午5:24:53
 * @UpdateDate: 2016年11月1日 下午5:24:53
 * @Version: V1.0
 */
public class LocalInnerAndAnonymous {
	private int count = 0;
	
	public Counter getCounterByLocalInner(final String name) {
		
		class LocalCounter implements Counter {
			
			public LocalCounter() {
				System.out.println("Local Inner Class : LocalCounter...");
			}

			@Override
			public int next() {
				// TODO Auto-generated method stub
				System.out.print(name);
				
				return ++count;
			}
			
		}
		
		return new LocalCounter();
	}
	
	public Counter getCounterByAnonymousInner(final String name) {
		
		{
			System.out.println("Anonymous Inner Class...");
		}
		
		return new Counter() {
			
			@Override
			public int next() {
				// TODO Auto-generated method stub
				System.out.print(name);
				return ++count;
			}
		};
	}
}
