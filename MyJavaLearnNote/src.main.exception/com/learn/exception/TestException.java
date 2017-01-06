package com.learn.exception;

public class TestException {
	
	public static void main(String[] args) throws Exception {
		
		try {
			System.out.println("KKKKKKKKKKKKKKKKK");
			int i = 2/0;
		} catch (Exception e) {
			
			System.out.println("Exception .......");
			e.printStackTrace();
			System.out.println("  \nFFFFFException .......");
			return;
		} finally {
			
			System.out.println("11111FFFFFFFFFFFFFFFF");
			System.out.println("FFFFFFFFFFFFFFFF");
		}
		
		System.out.println("HHHHHHHHHHHHHHHHHHHHHH");
		
	}
	
}
