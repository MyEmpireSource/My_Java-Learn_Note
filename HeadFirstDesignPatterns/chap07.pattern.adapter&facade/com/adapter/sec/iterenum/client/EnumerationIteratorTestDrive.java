package com.adapter.sec.iterenum.client;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import com.adapter.sec.iterenum.adapter.EnumerationIteratorAdapter;

public class EnumerationIteratorTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v = new Vector<String>(Arrays.asList("15,45,j,kl,mn".split(",")));
		
		Iterator<String> enumerationIteratorAdapter = new EnumerationIteratorAdapter<String> (v.elements());
		
		while (enumerationIteratorAdapter.hasNext()) {
			System.out.println(enumerationIteratorAdapter.next());
		}
		System.out.println();
		System.out.println();
		//抛出异常
		enumerationIteratorAdapter.remove();
	}

}
