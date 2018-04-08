package com.modifer.two;

import com.modifer.one.Person;

public class SubPersonTwo extends Person {

	/**
	 * 
	 * @Title: main
	 * @Description: 
	 * 
	 * @Params:
	 *   @param args
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年12月8日 上午11:45:15
	 * @ChangeDate: 2017年12月8日 上午11:45:15
	 * @Author: ZCX
	 */
	public static void main(String[] args) {
		
		// public, protected, friendly(no modifer) 修饰符可以在同一个包中访问到,
		// SubPersonTwo的实例能够访问protected修饰的成员变量或者方法, 而 SubPerson类实例访问不到,
		// 说明当与父类不在同一包中时, 子类 只能在自己的实例内访问父类的protected修饰的成员变量或者方法
		SubPersonTwo subPersonTwo = new SubPersonTwo();
		
		subPersonTwo.publicName = "SubPerson";
		subPersonTwo.publicToString();
		
		subPersonTwo.protectedPhoneNumber = "13555451245";
		subPersonTwo.protectedToString();
		
		
		SubPerson subPerson = new SubPerson();
		
		subPerson.publicName = "SubPerson";
		subPerson.publicToString();
		
		//subPerson.protectedPhoneNumber = "13555451245";
		//subPerson.protectedToString();
		
	}
	
}
