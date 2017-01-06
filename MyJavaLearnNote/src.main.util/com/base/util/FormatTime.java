package com.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化输出类
 * 
 * @author 李立
 */
public class FormatTime {
	public static final SimpleDateFormat TIME_FMT = new SimpleDateFormat("HH:mm:ss");
	public static final SimpleDateFormat DATE_FMT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat DATETIME_FMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 返回Date对象按(yyyy-MM-dd HH:mm:ss)的格式化时间字符串 
	 * @param date Date对象
	 * 
 	 * @return 格式化时间字符串 
	 */
	public static String getFormatDateTime(Date date){
		return FormatTime.DATETIME_FMT.format(date);
	}
	
	/**
	 * 返回Date对象按(yyyy-MM-dd)的格式化时间字符串 
	 * @param date Date对象
	 * 
 	 * @return 格式化时间字符串 
	 */
	public static String getFormatDate(Date date){
		return FormatTime.DATE_FMT.format(date);
	}
	
	/**
	 * 返回Date对象按(HH:mm:ss)的格式化时间字符串 
	 * @param date Date对象
	 * 
 	 * @return 格式化时间字符串 
	 */
	public static String getFormatTime(Date date){
		return FormatTime.TIME_FMT.format(date);
	}
	
	/**
	 * 
	 * @Title: isValidDate
	 * @Description: 验证字符串是否满足某种时间格式
	 * 
	 * @Params:
	 *   @param sf
	 *   @param dateStr
	 *   @return
	 *
	 * @Return: boolean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年4月19日 下午5:24:08
	 * @ChangeDate: 2016年4月19日 下午5:24:08
	 * @Author: 李立
	 */
	public static boolean isValidDate(SimpleDateFormat sf, String dateStr) {
		boolean flag = true;
		
		if (dateStr == null || dateStr.trim().length() <= 0) {
			return false;
		}
		
		dateStr = dateStr.trim();
		if (dateStr.length() != sf.toPattern().length()) {
			return false;
		}
		
		try {
			//设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			sf.setLenient(false);
			sf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			flag = false;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
