package com.java.io.decorator;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @Package: com.java.io.decorator
 * @ClassName: FlowRecordInputStream.java
 *
 * @Description: 使用装饰者模式, 按字节(byte)统计输入流量
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2015-12-4 上午11:11:08
 * @UpdateDate: 2015-12-4 上午11:11:08
 * @Version: V1.0
 */
public class FlowRecordInputStream extends InputStream {
	
	private InputStream inputStream;
	private long inFlow;
	
	/**
	 * 
	 * @Description: 构造函数，传入被装饰者对象
	 * 
	 * @Params:
	 *   @param in 被装饰者对象
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 上午11:14:16
	 * @ChangeDate: 2015-12-4 上午11:14:16
	 * @Author: ZCX
	 */
	public FlowRecordInputStream(InputStream in) {
		this.inputStream = in;
	}

	/**
	 * 
	 * @Override
	 * (non-Javadoc)
	 * @see java.io.InputStream#read()
	 *
	 * @Title: read
	 * @Description: TODO 重写read()方法, 不影响原输入流操作, 自动记录读取的字节数, 返回 -1则是读到末尾
	 * 
	 * @Params:
	 *   @throws IOException
	 *   
	 * @Return: 被装饰着读取的字节
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 上午11:25:09
	 * @ChangeDate: 2015-12-4 上午11:25:09
	 * @Author: ZCX
	 */
	@Override
	public int read() throws IOException {
		int i = this.inputStream.read();
		
		if (i != -1) {
			//每读取一个字节,则记录+1
			++this.inFlow;
		}
		//只做流量统计, 不影响原输入流的逻辑
		return i;
	}
	
	/**
	 * 
	 * @Override
	 * (non-Javadoc)
	 * @see java.io.InputStream#read(byte[])
	 *
	 * @Title: read
	 * @Description: 重写read(byte[])方法, 不影响原输入流操作, 自动记录读取的字节数, 返回 -1则是读到末尾
	 * 
	 * @Params:
	 *   @param b 缓存数组
	 *   @throws IOException
	 *   
	 * @Return: 读入到 b[]中的字节数
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 上午11:27:14
	 * @ChangeDate: 2015-12-4 上午11:27:14
	 * @Author: ZCX
	 */
	@Override
	public int read(byte b[]) throws IOException {
		return this.read(b, 0, b.length);
	}
	
	/**
	 * 
	 * @Override
	 * (non-Javadoc)
	 * @see java.io.InputStream#read(byte[], int, int)
	 *
	 * @Title: read
	 * @Description: 重写read(byte[], int, int)方法, 不影响原输入流操作, 自动记录读取的字节数, 返回 -1则是读到末尾
	 * 
	 * @Params:
	 *   @param b 缓存数组
	 *   @param off 缓存数组起始索引
	 *   @param len 读取到缓存数组中的长度
	 *   
	 *   @throws IOException
	 *
	 * @Return:
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 上午11:29:44
	 * @ChangeDate: 2015-12-4 上午11:29:44
	 * @Author: ZCX
	 */
	@Override
	public int read(byte b[], int off, int len) throws IOException {

		int result = this.inputStream.read(b, off, len);
		if (result != -1) {
			this.inFlow = this.inFlow + result;
		}
		return result;
	}
	
	/**
	 * 
	 * @Title: getInFlowRecord
	 * @Description: TODO 获取输入流量值(字节(byte))
	 * 
	 * @Params:
	 *
	 * @Return: long, 按字节统计的输入流量值
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 上午11:34:22
	 * @ChangeDate: 2015-12-4 上午11:34:22
	 * @Author: ZCX
	 */
	public long getInFlowRecord() {
		return this.inFlow;
	}
	
	public int available() {
		return (int) this.inFlow;
	}
	
	public long skip(long n) throws IOException {
		return this.inputStream.skip(n);
	}

	public void close() throws IOException {
		this.inputStream.close();
	}

	public synchronized void mark(int readlimit) {
		this.inputStream.mark(readlimit);
	}

	public synchronized void reset() throws IOException {
		this.inputStream.reset();
	}

	public boolean markSupported() {
		return this.inputStream.markSupported();
	}
}
