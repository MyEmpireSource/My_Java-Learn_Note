package com.modifer;

import com.modifer.one.Person;

public class ModiferTestWithDifferentPackage {
	
	public static void main(String[] args) {
		Person person = new Person();
		
		//不同包中，person对象引用只能访问public修饰的成员变量
		person.publicName = "publicName";
		
		person.publicToString();
	}
	
}
