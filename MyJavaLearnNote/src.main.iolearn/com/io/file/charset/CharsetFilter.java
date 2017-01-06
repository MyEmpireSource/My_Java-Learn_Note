package com.io.file.charset;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Package: com.io.file.charset
 * @ClassName: CharsetFilter.java
 *
 * @Description: 判断文件的编码格式
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年6月23日 下午2:15:28
 * @UpdateDate: 2016年6月23日 下午2:15:28
 * @Version: V1.0
 */
public class CharsetFilter {
	
	public static String codeString(FileInputStream in) throws IOException {
		
		BufferedInputStream bin = new BufferedInputStream(in);
		
		int p = (bin.read() << 8) + bin.read();
		
		String code = null;
		
		switch (p) {
			case 0XEFBB : 
				code = "UFT-8";
				break;
			case 0XFFFE : 
				code = "UNICODE";
				break;
			case 0XFEFF : 
				code = "UTF-16BE";
				break;
			case 0X5C75 : 
				code = "ANSI|ASCII";
				break;
			default :  
				code = "GBK";
		}
		bin.close();
		in.close();
		return code;
	}
	
	//public 
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//System.out.println(Character.);
		
		File document = new File("F:\\Char");
		
		File[] fileArray = document.listFiles();
		Map<File, String> record = new HashMap<File, String>();
		
		for (File f : fileArray) {
			record.put(f, CharsetFilter.codeString(new FileInputStream(f)));
		}
		
		for (File f : record.keySet()) {
			System.out.println(f.getName() + " " + record.get(f));
		}
		
	}
}
