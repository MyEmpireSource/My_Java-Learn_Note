package com.base.util;

import java.util.UUID;

/**
 * 字符串操作工具类
 * @author ZCX
 *
 */
public class StringUtil {
	
	/**
	 * 
	 * @Title: isNullOrSpace
	 * @Description: 检查字符串是否是空白字符串或空内容组成，如果是返回true，否则返回false
	 * 
	 * @Params:
	 *   @param str
	 *   @return
	 *
	 * @Return: boolean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月8日 下午5:46:45
	 * @ChangeDate: 2018年2月8日 下午5:46:45
	 * @Author: ZCX
	 */
	public static boolean isNullOrSpace(String str) {
		
		return str == null || str.trim().equals("");
	}
	
	
	/**
	 * 
	 * @Title: isDigit
	 * @Description: 检查字符串是否是数字，如果是返回true，否则返回false
	 * 
	 * @Params:
	 *   @param str
	 *   @return
	 *
	 * @Return: boolean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月8日 下午5:48:59
	 * @ChangeDate: 2018年2月8日 下午5:48:59
	 * @Author: ZCX
	 */
	public static boolean isDigit(String str)
	{
		if (isNullOrSpace(str)) {
			return false;
		}
		
		try{
			//将字符串解析为数字，发生异常时说明字符串不是数字组成。
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @Title: getUUid
	 * @Description: 获取UUID
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: String
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月8日 下午5:51:28
	 * @ChangeDate: 2018年2月8日 下午5:51:28
	 * @Author: ZCX
	 */
	public static String getUUid() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
	
	
	public static void main(String[] args) {
		System.out.println(StringUtil.isNullOrSpace(null));
		System.out.println(StringUtil.isNullOrSpace(""));
		System.out.println(StringUtil.isNullOrSpace("   "));
		System.out.println(StringUtil.isNullOrSpace("  df "));
	}
	
	
}
