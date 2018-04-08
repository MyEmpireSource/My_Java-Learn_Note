package com.modifer.two.sub;

import com.modifer.two.SubPerson;

public class OtherPerson extends SubPerson {
	
	public static void main(String[] args) {
		
		OtherPerson otherPerson = new OtherPerson();
		
		otherPerson.publicName = "OtherPerson";
		otherPerson.protectedPhoneNumber = "13555451245";
		
		otherPerson.publicToString();
		otherPerson.protectedToString();
		
		
		
		//与父类在不同包中, 只有在自己实例内能访问父类的  protected
		SubPerson subPerson = new SubPerson();
		
		subPerson.publicName = "SubPerson";
		subPerson.publicToString();
		
		//subPerson.protectedPhoneNumber = "13555451245";
		//subPerson.protectedToString();
		
	}
	
}
