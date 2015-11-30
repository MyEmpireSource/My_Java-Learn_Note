package com.java.io.decorator;

import java.io.CharConversionException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @Package: com.java.io.decorator 
 * @ClassName: LowerCaseInputStream
 * 
 * @Description: 编写一个装饰者，把输入流内的所有大写字符转成小写 
 *
 * @Company: ZCX&Empire 
 * @Author: ZCX
 * @CreateDate: 2015年11月25日 上午1:48:17 
 * @ChangeDate: 2015年11月25日 上午1:48:17 
 *
 */
public class LowerCaseInputStream extends FilterInputStream {

	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char) c));
	}
	
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		
		for (int i = offset; i < offset + result; ++i) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		
		return result;
	}

}
