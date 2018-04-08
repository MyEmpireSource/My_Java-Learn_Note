package com.modifer.one;

public class ModiferTestWithSamePackage {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		
		//public, protected, friendly(no modifer) 修饰符可以在同一个包中访问到。
		person.publicName = "publicNameNew";
		person.protectedPhoneNumber = "13888565415";
		person.friendlyAddress = "China";
		
		//private修饰的只能在本类中访问
		//person.privateAge = "";
		
		person.publicToString();
		person.protectedToString();
		person.friendlyToString();
	}
	
}
