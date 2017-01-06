package com.learn.inner.member;

/**
 * 
 * @Package: com.learn.inner.member
 * @ClassName: Circle.java
 *
 * @Description: 成员内部类(member inner class)
 * 				   成员内部类是最普通的内部类，它的定义为位于另一个类的内部
 * 
 * @Company:
 * @Author: ZCX 
 * @CreateDate: 2016年10月26日 上午11:43:56
 * @UpdateDate: 2016年10月26日 上午11:43:56
 * @Version: V1.0
 */
public class Circle {
	
	public static int count = 1;
	
	private double radius = 0;
	private String name = "";
	private Draw draw  = null;
	
	public Circle(double radius) {
		this.radius = radius;
		this.draw = this.getDrawInstance();	//必须先创建成员内部类的对象，再进行访问
	}
	
	public Circle(double radius, String name) {
		this.radius = radius;
		this.name = name;
		this.draw = this.getDrawInstance();	//必须先创建成员内部类的对象，再进行访问
	}
	
	public Draw getDrawInstance() {
		return new Draw("Inner Class Draw_" + System.currentTimeMillis());
	}
	
	public void saySome(String info) {
		System.out.println(info);
	}
	
	/**
	 * 
	 * @Title: showNameInfo
	 * @Description: 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，
	 *               即默认情况下访问的是成员内部类的成员。
	 *               如果要访问外部类的同名成员，需要以下面的形式进行访问：外部类.this.成员变量、外部类.this.成员方法
	 * 
	 * @Params:
	 *   @param info
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年10月26日 下午3:48:31
	 * @ChangeDate: 2016年10月26日 下午3:48:31
	 * @Author: ZCX
	 */
	public void showNameInfo(String info) {
		System.out.println("Call Circle's showNameInfo() method : " + info);
	}
	
	/**
	 * 
	 * @Title: testInfo
	 * @Description: 虽然成员内部类可以无条件地访问外部类的成员，
	 * 				   而外部类想访问成员内部类的成员却不是这么随心所欲了。
	 * 				   在外部类中如果要访问成员内部类的成员，
	 * 				   必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年10月26日 下午3:47:43
	 * @ChangeDate: 2016年10月26日 下午3:47:43
	 * @Author: ZCX
	 */
	public void testInfo() {
		if (this.draw == null) {
			this.draw = this.getDrawInstance();
		}
		
		//必须先创建成员内部类的对象，再进行访问
		this.draw.drawSahpe();
	}
	
	/**
	 * 
	 * @Package: com.learn.inner.member
	 * @ClassName: Circle.java
	 *
	 * @Description: 成员内部类(member inner class)
	 * 				   成员内部类是最普通的内部类，它的定义为位于另一个类的内部
	 * 				   成员内部类可以无条件访问外部类的所有成员属性和成员方法(包括private成员和静态成员)。
	 * 
	 * @Company:
	 * @Author: 李立  
	 * @CreateDate: 2016年10月26日 上午11:47:49
	 * @UpdateDate: 2016年10月26日 上午11:47:49
	 * @Version: V1.0
	 */
	class Draw {
		
		private String name;
		
		//private static int num3=30;//在成员内部类中不能声明静态成员和静态方法, static final形式的常量定义除外
		private static final int NUM = 9;//static final形式的常量定义除外
		
		public Draw(String name) {
			this.name = name;
		}
		
		public void showNameInfo(String info) {
			System.out.println("Call Circle.Draw's showNameInfo() method : " + info);
		}
		
		public void drawSahpe() {
			System.out.println("drawSahpe ");
			
			//成员内部类可以无条件访问外部类的所有成员属性和成员方法(包括private成员和静态成员)
			System.out.println("外部类的private成员 radius: " + radius);	//外部类的private成员
			System.out.println("外部类的静态成员 count: " + radius);		//外部类的静态成员
			
			saySome("Call By Inner Class!!");	//外部类的成员方法
			
			//当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，
			//即默认情况下访问的是成员内部类的成员
			//如果要访问外部类的同名成员，需要以下面的形式进行访问：外部类.this.成员变量、外部类.this.成员方法
			System.out.println("inner name : " + name + ", outter name : " + Circle.this.name);
			showNameInfo("Test The same name of inner and outter method!");
			Circle.this.showNameInfo("Test The same name of inner and outter method!");
		}
	}
}
