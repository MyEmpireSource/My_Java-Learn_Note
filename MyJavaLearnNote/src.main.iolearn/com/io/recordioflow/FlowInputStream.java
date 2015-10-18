package com.io.recordioflow;

import java.io.IOException;
import java.io.InputStream;

public class FlowInputStream extends InputStream {

	private InputStream inputStream;
	private int inFlow = 0;

	public FlowInputStream(InputStream in) {
		this.inputStream = in;
	}

	@Override
	public int read() throws IOException {
		
		int i = this.inputStream.read();
		if (i != -1) {
			this.inFlow++;
		}
		return i;
	}

	public int read(byte b[]) throws IOException {
		return read(b, 0, b.length);
	}

	public int read(byte b[], int off, int len) throws IOException {

		int result = this.inputStream.read(b, off, len);
		if (result != -1) {
			this.inFlow = this.inFlow + result;
		}
		return result;
	}

	public int available() {
		return this.inFlow;
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
