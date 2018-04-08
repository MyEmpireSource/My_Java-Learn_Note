package com.io.recordioflow;

import java.io.IOException;
import java.io.OutputStream;

public class FlowOutputStream extends OutputStream {

	private OutputStream outputStream;
	private int outFlow = 0;
	
	
	public FlowOutputStream(OutputStream out) {
		this.outputStream = out;
	}
	
	@Override
	public void write(int arg0) throws IOException {
		this.outFlow++;
		//System.out.print((char) arg0);
		this.outputStream.write(arg0);
	}
	
	public void write(byte[] b) throws IOException {
		this.write(b, 0, b.length);
	}
	
	public void write(byte b[], int off, int len) throws IOException {
		this.outputStream.write(b, off, len);
		
		/*
		for (int i = off; i < len + off; i++) {
			System.out.print((char) b[i]);
		}
		*/
		
		this.outFlow = this.outFlow + len;
	}
	
	public void flush() throws IOException {
		this.outputStream.flush();
    }
	
	public void close() throws IOException {
		this.outputStream.close();
    }
	
	public int available() {
		return this.outFlow;
	}

}
