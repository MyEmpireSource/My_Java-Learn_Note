package com.java.io.decorator;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @Package: com.java.io.decorator
 * @ClassName: FlowRecordOutPutStream.java
 *
 * @Description: 使用装饰者模式, 按字节(byte)统计输出流量
 *
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2015-12-4 下午2:38:35
 * @UpdateDate: 2015-12-4 下午2:38:35
 * @Version: V1.0
 */
public class FlowRecordOutputStream extends OutputStream {
	
	private OutputStream outputStream;
	private int outFlow = 0;
	
	/**
	 * 
	 * @Description: 构造函数，传入被装饰者对象
	 * 
	 * @Params:
	 *   @param out 
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 下午2:40:52
	 * @ChangeDate: 2015-12-4 下午2:40:52
	 * @Author: ZCX
	 */
	public FlowRecordOutputStream(OutputStream out) {
		this.outputStream = out;
	}

	@Override
	public void write(int arg0) throws IOException {
		++this.outFlow;
		//System.out.print((char) arg0);
		this.outputStream.write(arg0);
	}
	
	public void write(byte[] b) throws IOException {
		this.write(b, 0, b.length);
	}
	
	public void write(byte b[], int off, int len) throws IOException {
		this.outputStream.write(b, off, len);
		this.outFlow = this.outFlow + len;
	}
	
	public void flush() throws IOException {
		this.outputStream.flush();
    }
	
	public void close() throws IOException {
		this.outputStream.close();
    }
	
	/**
	 * 
	 * @Title: available
	 * @Description: 获取输入流量
	 * 
	 * @Params:
	 *
	 * @Return: int
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 下午2:42:41
	 * @ChangeDate: 2015-12-4 下午2:42:41
	 * @Author: ZCX
	 */
	public int available() {
		return this.outFlow;
	}

}
