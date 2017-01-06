package com.learn.inner.local;

/**
 * 
 * @Package: com.learn.inner.local
 * @ClassName: LocalInnerClassApplicationScenarios.java
 *
 * @Description: 局部内部类应用场景-局部内部类的使用
 * 				  常常使用一个方法，使其返回值为某个类或接口的对象。而这个类或接口在方法内部创建
 * 				 java代理模式中有用到局部内部类，在方法中直接实现接口，返回代理对象，简单而又方便
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2016年11月1日 下午4:25:26
 * @UpdateDate: 2016年11月1日 下午4:25:26
 * @Version: V1.0
 */
public class LocalInnerClassApplicationScenarios {
	
	//如下的使用方式较少
	public void method1() {
		
		class LocalInner {
			
		}
	}
	
	//常常使用一个方法，使其返回值为某个类或接口的对象。而这个类或接口在方法内部创建
	//使用方式一(局部内部类)
	public Comparable getComparable(final String name) {
		
		//1.创建一个实现Comparable接口的类:局部内部类
		class MyComparable implements Comparable {
			
			public MyComparable() {
				System.out.println("");
			}

			@Override
			public int compareTo(Object arg0) {
				// TODO Auto-generated method stub
				System.out.println(name);
				return 0;
			}
			
		}
		//2.返回一个实现类的对象
		return new MyComparable();
	}
	
	//使用方式二 (匿名内部类(匿名内部类是局部内部类的一种特殊形式))
	public Comparable getComparable1(final String name) {
		
		{
			System.out.println("");
		}
		
		//返回一个实现Comparable接口的匿名内部类的对象
		return new Comparable () {
			
			@Override
			public int compareTo(Object arg0) {
				// TODO Auto-generated method stub
				System.out.println(name);
				return 0;
			}
		};
	}
}
