package com.java.io.decorator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputTest {

	/**
	 * 
	 * @Title: getInputStreamByFileName
	 * @Description: 获取类当前目录下[fileName]文件的InputStream
	 * 
	 * @Params:
	 *   @param fileName
	 *
	 * @Return: InputStream
	 * 
	 * @Throws: FileNotFoundException
	 *
	 * @CreateDate: 2015-12-4 下午1:55:55
	 * @ChangeDate: 2015-12-4 下午1:55:55
	 * @Author: ZCX
	 */
	public static InputStream getInputStreamByFileName(String fileName) throws FileNotFoundException {
		File inputFile = new File(InputTest.class.getResource(fileName).getPath());
		return new FileInputStream(inputFile);
	}
	
	/**
	 * 
	 * @Title: getOutputStream
	 * @Description: 获取输出流, 目标文件为当前目录下的fileName, 没有则创建该文件
	 * 
	 * @Params:
	 *   @param fileName
	 *   @return
	 *   @throws IOException
	 *
	 * @Return: OutputStream
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2015-12-4 下午2:45:27
	 * @ChangeDate: 2015-12-4 下午2:45:27
	 * @Author: ZCX
	 */
	public static OutputStream getOutputStream(String fileName) throws IOException {
		File outputFile = new File(InputTest.class.getResource("").getPath() + "/" + fileName);
		
		if (outputFile.isDirectory() || !outputFile.exists()) {
			outputFile.createNewFile();
		}
		
		OutputStream out = new FileOutputStream(outputFile);
		return out;
	}
	
	public static void showInFlowDate(InputStream in) throws IOException {
		InputStream myIn = new FlowRecordInputStream(in);
		
		int c = 0;
		while ((c = myIn.read()) > 0) {
			//System.out.print((char) c);
		}
		System.out.println(myIn.available());
		
		myIn.close();
	}
	
	public static void showInFlowDate(InputStream in, byte[] b, int off, int len) throws IOException {
		InputStream myIn = new FlowRecordInputStream(in);
		
		int c = 0;
		while((c = myIn.read(b, off, len)) != -1) {
			
			/*
			//show inputStream info
			for (int i = off; i < off + c; i++) {
				System.out.print((char) b[i]);
			}
			*/
		}
		
		System.out.println(myIn.available());
		myIn.close();
	}
	
	public static void showOutFlowDate(OutputStream out) throws IOException {
		FlowRecordOutputStream myOut = new FlowRecordOutputStream(out);
		
		InputStream in = new FlowRecordInputStream(InputTest.getInputStreamByFileName("testTxt"));
		
		int c = 0;
		while((c = in.read()) > 0) {
			myOut.write(c);
		}
		
		in.close();
		myOut.close();
		System.out.println("输入流量为: " + in.available());
		System.out.println("输出流量为: " + myOut.available());
		System.out.println();
	}
	
	public static void showOutFlowDate(OutputStream out, byte[] b, int off, int len) throws IOException {
		FlowRecordOutputStream myOut = new FlowRecordOutputStream(out);
		
		InputStream in = new FlowRecordInputStream(InputTest.getInputStreamByFileName("testTxt"));
		
		int c = 0;
		while((c = in.read(b, off, len)) > 0) {
			myOut.write(b, off, c);
		}
		
		in.close();
		myOut.close();
		System.out.println("输入流量为: " + in.available());
		System.out.println("输出流量为: " + myOut.available());
		System.out.println();
	}
	
	public static void LowerCaseInputStreamShow(InputStream in) throws IOException {
		InputStream input = new LowerCaseInputStream(new BufferedInputStream(in));
		int c;
		while ((c = input.read()) >= 0) {
			System.out.print((char) c);
		}
		
		input.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		//装饰者模式 大小写转换测试
		InputTest.LowerCaseInputStreamShow(InputTest.getInputStreamByFileName("readme.txt"));
		
		System.out.println();System.out.println();
		System.out.println("装饰者模式, 输入流量记录测试");
		//装饰者模式, 输入流量记录测试
		InputTest.showInFlowDate(InputTest.getInputStreamByFileName("readme.txt"));
		InputTest.showInFlowDate(InputTest.getInputStreamByFileName("readme.txt"), new byte[30], 5, 15);
		
		System.out.println();System.out.println();
		System.out.println("装饰者模式, 输出流量记录测试");
		//装饰者模式, 输出流量记录测试
		InputTest.showOutFlowDate(InputTest.getOutputStream("outTestTxt"));
		InputTest.showOutFlowDate(InputTest.getOutputStream("outTestTxt"), new byte[150], 12, 71);
		
		System.out.println("Test Git change in Service");
		
	}

}
