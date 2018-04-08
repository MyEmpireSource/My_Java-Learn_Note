package com.adapter.sec.iterenum.client;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class BaseEI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 普通情况下, 为了兼容 新旧接口, 需要修改代码, 支持两种接口
		Vector<String> v = new Vector<String> (Arrays.asList("15,45,j,kl,mn".split(",")));
		Enumeration<String> enumeration = v.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		
		System.out.println();
		Iterator<String> iterator = v.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
