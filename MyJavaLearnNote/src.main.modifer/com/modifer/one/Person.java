package com.modifer.one;

/**
 * 
 * @Package: com.modifer.publicmodifer
 * @ClassName: Person.java
 *
 * @Description: 
 * 			作用域		 当前类		同一package		子孙类		其他package 
 * 		   public		   √		    √			  √              √ 
 *         protected	   √		    √             √              × 
 *         friendly	       √            √			  ×              × 
 *         private		   √            ×			  ×              × 
 * 		
 * 		   friendly(不写时默认为friendly)
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月8日 上午10:43:13
 * @UpdateDate: 2017年12月8日 上午10:43:13
 * @Version: V1.0
 */
public class Person {
	
	public String publicName;
	
	protected String protectedPhoneNumber;
	
	String friendlyAddress;
	
	private String privateAge;

	
	
	
	
	private String personToString() {
		return "Person [publicName=" + publicName + ", protectedPhoneNumber=" + protectedPhoneNumber
				+ ", friendlyAddress=" + friendlyAddress + ", privateAge=" + privateAge + "]";
	}
	
	public void publicToString() {
		System.out.println("publicToString :	" + personToString());
	}
	
	protected void protectedToString() {
		System.out.println("protectedToString :	" + personToString());
	}
	
	private void privateToString() {
		
		System.out.println("privateToString :	" + personToString());
	}
	
	void friendlyToString() {
		System.out.println("friendlyToString :	" + personToString());
	}
}
