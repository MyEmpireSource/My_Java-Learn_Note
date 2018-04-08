package com.base.util.log;

public class ServiceDaoLog {
	
	/**
	 * 返回带参数的日志信息
	 * @param params 参数, 结构为 paramname:paramvalue, paramname:paramvalue
	 * @param message 信息
	 * @return 日志信息
	 */
	public static String serviceDaoLog(String params, String message){
		return "[Method:" + new Exception().getStackTrace()[1].getMethodName() 
				+ "]-[Params:{" + params + "}]-[Info:'" + message + "']";
	}
	
	/**
	 * 返回不带参数信息的日志信息
	 * @param message 信息
	 * @return 日志信息
	 */
	public static String serviceDaoLog(String message){
		return "[Method:" + new Exception().getStackTrace()[1].getMethodName() + "]-[Info:'" + message + "']";
	}
	
	public static String serviceDaoLogWithMethod(String methodName, String message){
		return "[Method:" + methodName + "]-[Info:'" + message + "']";
	}
	
	public static void main(String[] args){
		System.out.println(serviceDaoLog("name:LILI, age:18", "Add user LILI!"));
		System.out.println(serviceDaoLog("Get LILI info Success!"));
	}
	
}
