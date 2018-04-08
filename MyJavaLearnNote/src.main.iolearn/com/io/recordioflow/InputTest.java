package com.io.recordioflow;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * test 
 */ 
public class InputTest {
	
	public static InputStream getTestInputStream(String fileName) throws FileNotFoundException   {
		File inputFile = new File(InputTest.class.getResource(fileName).getPath());
		
		InputStream in = new BufferedInputStream(
				new FileInputStream(inputFile)
		);
		
		return in;
	}
	
	public static void showInFlowDate(InputStream in) throws IOException {
		InputStream myIn = new FlowInputStream(in);
		
		int c = 0;
		while ((c = myIn.read()) > 0) {
			//System.out.print((char) c);
		}
		System.out.println(myIn.available());
		
		myIn.close();
	}
	
	public static void showInFlowDate(InputStream in, byte[] b, int off, int len) throws IOException {
		InputStream myIn = new FlowInputStream(in);
		
		int c = 0;
		while((c = myIn.read(b, off, len)) != -1) {
			for (int i = off; i < off + len; i++) {
				//System.out.print((char) c);
			}
		}
		
		System.out.println(myIn.available());
		myIn.close();
	}
	
	public static OutputStream getTestOutputStream(String fileName) throws IOException {
		File outputFile = new File(InputTest.class.getResource("").getPath() + "/" + fileName);
		
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		
		OutputStream out = new FileOutputStream(outputFile);
		return out;
	}
	
	public static void showOutFlowDate(OutputStream out) throws IOException {
		OutputStream myOut = new FlowOutputStream(out);
		
		InputStream in = new FlowInputStream(InputTest.getTestInputStream("testTxt"));
		
		int c = 0;
		while((c = in.read()) > 0) {
			myOut.write(c);
		}
		
		in.close();
		myOut.close();
		System.out.println(((FlowOutputStream) myOut).available());
	}
	
	public static void showOutFlowDate(OutputStream out, byte[] b, int off, int len) throws IOException {
		OutputStream myOut = new FlowOutputStream(out);
		
		InputStream in = new FlowInputStream(InputTest.getTestInputStream("testTxt"));
		
		int c = 0;
		while((c = in.read(b, off, len)) > 0) {
			myOut.write(b, off, c);
		}
		
		in.close();
		myOut.close();
		System.out.println(((FlowOutputStream) myOut).available());
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
		InputTest.showInFlowDate(InputTest.getTestInputStream("testTxt"));
		
		InputTest.showInFlowDate(InputTest.getTestInputStream("testTxt"), new byte[100], 10, 20);
		
		/*
		OutputStream out = getTestOutputStream("outTestTxt");
		String outTestStr = "This is a outputStream test";
		
		byte[] byteArray = outTestStr.getBytes();
		out.write(byteArray);
		out.flush();
		out.close();
		
		outTestStr = "This is another outputStream test";
		out = getTestOutputStream("outTestTxt");
		byteArray = outTestStr.getBytes();
		for (byte b : byteArray) {
			out.write(b);
		}
		out.flush();
		out.close();
		*/
		System.out.println();
		InputTest.showOutFlowDate(InputTest.getTestOutputStream("outTestTxt"));
		InputTest.showOutFlowDate(InputTest.getTestOutputStream("outTestTxt"), new byte[150], 12, 71);
		
		System.out.println("Test Git change in Service");
	}
	
}
