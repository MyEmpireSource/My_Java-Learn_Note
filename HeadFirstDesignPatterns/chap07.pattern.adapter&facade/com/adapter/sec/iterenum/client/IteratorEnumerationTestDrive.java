package com.adapter.sec.iterenum.client;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import com.adapter.sec.iterenum.adapter.IteratorEnumerationAdapter;

public class IteratorEnumerationTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> strList = Arrays.asList("15,78,l,kl,jk".split(","));
		
		Enumeration<String> iteratorEnumerationAdapter = new IteratorEnumerationAdapter<String>(strList.iterator());
		
		while (iteratorEnumerationAdapter.hasMoreElements()) {
			System.out.println(iteratorEnumerationAdapter.nextElement());
		}
		
	}

}
