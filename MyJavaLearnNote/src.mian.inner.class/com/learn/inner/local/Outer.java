package com.learn.inner.local;

/**
 * 
 * @Package: com.learn.inner.local
 * @ClassName: Outer.java
 *
 * @Description: 局部内部类(Local inner class)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2016年11月1日 上午11:41:18
 * @UpdateDate: 2016年11月1日 上午11:41:18
 * @Version: V1.0
 */
public class Outer {
	public static final int TOTAL_NUMBER = 5;
	
	public long id = System.currentTimeMillis();
	
	public void func() {
		final int age = 25;
		String str = "http://www.mylearn.com";
		
		//局部类不可以用 public、private、protected 修饰，只能使用缺省的
		//局部类不可以是 static 的，里边也不能定义 static 成员
		//局部类可以是 abstract 的，可以用final修饰，用来确保这个变量的值不会发生改变
		class LocalInner {
			
			private String name;
			private long id = Outer.this.id + 10;
			
			public LocalInner(String name) {
				this.name = name;
			}
			
			public void localInnerShowInfo() {
				System.out.println("Local Inner Class's name : " + this.name);
				System.out.println("Local Inner Class's id ： " + this.id);
				
				//局部类可以访问外部类的所有成员，包括成员变量
				System.out.println("Outer Class's Outer.TOTAL_NUMBER: " + Outer.TOTAL_NUMBER);
				//但是局部类可以访问外部类的所有成员，包括成员变量
				System.out.println("Outer Class's id ： " + Outer.this.id);
				
				//可以使用定义它们的代码块中的任何局部 final 变量
				System.out.println("Locale  age ： " + age);
				//System.out.println(str); //不合法，只能访问本地方法的final变量
			}
		}
		
		//仅在定义了它们的代码块中是可见的
		//无法在外部类中实例化和调用的
		new LocalInner("LocaleInner_01").localInnerShowInfo();
	}
}
