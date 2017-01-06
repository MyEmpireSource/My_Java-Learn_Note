package com.learn.inner.member;

/**
 * 
 * @Package: com.learn.inner.member
 * @ClassName: TestMemberInnerClass.java
 *
 * @Description: 成员内部类
 * 				   成员内部类是依附外部类而存在的，
 * 				   也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2016年10月26日 下午3:53:29
 * @UpdateDate: 2016年10月26日 下午3:53:29
 * @Version: V1.0
 */
public class TestMemberInnerClass {

	public static void main(String[] args) {
		
		//创建成员内部类对象的第一种方式：
		Circle circle = new Circle(10, "Circle name_" + 1);
		Circle.Draw draw = circle.new Draw("New Inner Draw name_" + 1);
		draw.drawSahpe();
		
		System.out.println();
		System.out.println("##################################");
		System.out.println();
		
		//创建成员内部类对象的第二种方式：
		Circle.Draw draw1 = circle.getDrawInstance();
		draw1.drawSahpe();
		
		
		///////////////////////////////
		System.out.println();
		System.out.println("##################################");
		System.out.println();
		
		circle.testInfo();

	}

}
