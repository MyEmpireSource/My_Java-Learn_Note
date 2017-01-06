package com.learn.inner.statics;

public class StaticInnerClassOuter {
	private int a = 5;
	private static int b = 8;
	
	public void showInfo1() {
		System.out.println("This is Static Inner Outer Class's showInfo1() method!!");
	}
	
	public static void showInfo() {
		System.out.println("This is Static Inner Outer Class's static showInfo() method!!");
	}
	
	static class StaticInner {
		public StaticInner() {
			System.out.println("init StaticInner Object, " + StaticInnerClassOuter.b + "\n");
			
			//静态内部类不能使用外部类的非static成员变量或者方法
			//System.out.println(StaticInnerClassOuter.this.a);
		}
		
		public void showInfo() {
			System.out.println("This is Static Inner Class's showInfo() method!!");
			
			//静态内部类不能使用外部类的非static成员变量或者方法
			//StaticInnerClassOuter.this.showInfo();
			StaticInnerClassOuter.showInfo();
		}
	}
}
