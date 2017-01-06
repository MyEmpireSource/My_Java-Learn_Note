package com.learn.inner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalInnerAndAnonymous inner = new LocalInnerAndAnonymous();
		
		Counter c1 = inner.getCounterByLocalInner("Local Inner--> ");
		Counter c2 = inner.getCounterByAnonymousInner("Anonymous Inner--> ");
		System.out.println();
		
		for (int i = 0; i <5; i++) {
			System.out.println(c1.next());
		}
		
		System.out.println();
		for (int i = 0; i <5; i++) {
			System.out.println(c2.next());
		}
		
	}

}
