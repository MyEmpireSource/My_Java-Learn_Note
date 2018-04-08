package com.modifer.two;

import com.modifer.one.Person;

public class SubPerson extends Person {
	
	
	public static void main(String[] args) {
		SubPerson subPerson = new SubPerson();
		
		subPerson.publicName = "SubPerson";
		subPerson.protectedPhoneNumber = "13555451245";
		
		subPerson.publicToString();
		subPerson.protectedToString();
	}
}
