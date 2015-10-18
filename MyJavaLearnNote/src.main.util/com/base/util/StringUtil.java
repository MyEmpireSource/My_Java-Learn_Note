package com.base.util;

/**
 * 字符串操作工具类
 * @author ZCX
 *
 */
public class StringUtil {
	
	public static boolean isNullOrSpace(String str) {
		if (str == null || str.length() == 0 || str.trim().length() == 0) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtil.isNullOrSpace(null));
		System.out.println(StringUtil.isNullOrSpace(""));
		System.out.println(StringUtil.isNullOrSpace("   "));
		System.out.println(StringUtil.isNullOrSpace("  df "));
	}
}
