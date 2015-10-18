package com.base.util;

import java.text.DecimalFormat;

/**
 * 计算工具类
 * @author ZCX
 *
 */
public class MathUtil {
	
	public static String DEFAULT_SPLIT_STR$_ = "_";
	
	/**计算机存储单位 字 大小单位  */
	public static String UNIT_BYTE_B$b = "b";
	
	/**计算机存储单位 字节 大小单位  */
	public static String UNIT_BYTE_BYTE$byte = "byte";
	
	/**计算机存储单位 千字节 大小单位  */
	public static String UNIT_KB$kb = "kb";
	
	/**计算机存储单位 兆字节 大小单位  */
	public static String UNIT_MB$mb = "mb";
	
	/**计算机存储单位  千兆字节 大小单位  */
	public static String UNIT_GB$gb = "gb";
	
	public static String UNIT_CONVERSION_DIVISION$1 = "1";
	public static String UNIT_CONVERSION_MULTI$0 = "0";
	
	
	/**
	 * 获取 计算机存储单位 之间的做转换需要的操作(除法或乘法)及跨度值
	 * 
	 * 返回转换需要操作和操作数用MathUtil.DEFAULT_SPLIT_STR$_连接的字符串
	 * [UNIT_CONVERSION_DIVISION$1 | UNIT_CONVERSION_MULTI$0] + DEFAULT_SPLIT_STR + operand 
	 * 
	 * 传入的单位有错误，则返回null值
	 * 
	 * 支持 byte, kb, mb, gb之间的转换
	 * 
	 * @param dataUnit 转换前的单位
	 * @param conversionUnit 转换后的单位
	 * @return "[1 | 0]_operand "
	 */
	public static String unitConversion(String dataUnit, String conversionUnit) {
		
		/* 验证单位是有效字符串 */
		if (StringUtil.isNullOrSpace(dataUnit) || StringUtil.isNullOrSpace(conversionUnit)) {
			return null;
		}
		
		/* 转换为小写 */
		dataUnit = dataUnit.toLowerCase();
		conversionUnit = conversionUnit.toLowerCase();
		
		/* 字单位统一用 b 表示*/
		dataUnit = dataUnit.equals(MathUtil.UNIT_BYTE_BYTE$byte) ? MathUtil.UNIT_BYTE_B$b : dataUnit;
		conversionUnit = conversionUnit.equals(MathUtil.UNIT_BYTE_BYTE$byte) ? MathUtil.UNIT_BYTE_B$b : conversionUnit;
		
		if (dataUnit.equals(conversionUnit)) {
			/**
			 * 单位合法且相同, 返回乘法，操作数1.0
			 * 0_1.0
			 */
			return MathUtil.UNIT_CONVERSION_MULTI$0 + MathUtil.DEFAULT_SPLIT_STR$_ + 1.0;
		}
		
		/**
		 * 单位的数组, 单位在数组中的索引的值之差，为转换的倍数
		 */
		String[] unitArray = {MathUtil.UNIT_BYTE_B$b, MathUtil.UNIT_KB$kb, MathUtil.UNIT_MB$mb, MathUtil.UNIT_GB$gb};
		
		/* 单位在数组中的索引 */
		int dataUnitIndex = -1;
		int conversionUnitIndex = -1;
		
		for (int i = 0; i < unitArray.length; ++i) {
			if (dataUnit.equals(unitArray[i])) {
				dataUnitIndex = i;
				continue;
			}
			
			if (conversionUnit.equals(unitArray[i])) {
				conversionUnitIndex = i;
				continue;
			}
		}
		
		/* 合法单位验证 */
		if (dataUnitIndex == -1 || conversionUnitIndex == -1) {
			return null;
		}
		
		dataUnitIndex = dataUnitIndex - conversionUnitIndex;
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		if (dataUnitIndex < 0) {
			//小单位转大单位, 除法
			return MathUtil.UNIT_CONVERSION_DIVISION$1 + MathUtil.DEFAULT_SPLIT_STR$_ + df.format(Math.pow(1024, -dataUnitIndex));
		} else {
			//大单位转小单位, 乘法
			return MathUtil.UNIT_CONVERSION_MULTI$0 + MathUtil.DEFAULT_SPLIT_STR$_ + df.format(Math.pow(1024, dataUnitIndex));
		}
	}
	
	/**
	 * 存储单位不同单位之间值得转换
	 * 
	 * @param dataUnit 原单位
	 * @param conversionUnit 转换后的单位
	 * @param data 转换前的数值
	 * @return 转换后的值
	 */
	public static double unitConversionOperator(String dataUnit, String conversionUnit, double data) {
		
		String conversionOper = MathUtil.unitConversion(dataUnit, conversionUnit);
		//传入单位有错， 返回原始值
		if (StringUtil.isNullOrSpace(conversionOper)) {
			return data;
		}
		
		//解析操作和操作数 
		String[] operArray = conversionOper.split(MathUtil.DEFAULT_SPLIT_STR$_);
		
		/* 根据操作和操作数，将值与操作数操作 */
		if (MathUtil.UNIT_CONVERSION_DIVISION$1.equals(operArray[0])) {
			//除法， 除以操作数
			return data / Double.parseDouble(operArray[1]);
		} else if (MathUtil.UNIT_CONVERSION_MULTI$0.equals(operArray[0])) {
			//乘法，乘以操作数
			return data * Double.parseDouble(operArray[1]);
		} else {
			//发生异常，返回原始值
			return data;
		}
	}
}
