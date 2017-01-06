package com.learn.thread.queue.blocking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

/**
 * 
 * @Package: com.learn.thread.queue.blocking
 * @ClassName: SearchTask.java
 *
 * @Description: This task searches files for a given keyword
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2016年5月25日 下午2:45:26
 * @UpdateDate: 2016年5月25日 下午2:45:26
 * @Version: V1.0
 */
public class SearchTask implements Runnable {

	public static Logger logger = Logger.getLogger(SearchTask.class.getName());
	
	private BlockingQueue<File> queue;
	private String keyWord;
	
	public SearchTask(BlockingQueue<File> queue, String keyWord) {
		this.queue = queue;
		this.keyWord = keyWord;
	}
	
	public void search(File file) throws IOException {
		
		//System.out.println("*** " + file.getPath());
		
		Scanner in = new Scanner(new FileInputStream(file));
		
		int lineNumber = 0;
		while (in.hasNextLine()) {
			lineNumber++;
			String line = in.nextLine();
			if (line.contains(keyWord)) {
				System.out.printf(Thread.currentThread().getName() + " %s:%d:%s%n", file.getPath(), lineNumber, line);
			}
		}
		in.close();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			boolean done = false;
			
			while (!done) {
				File file = this.queue.take();
				System.out.println("###### <-- " + file.getPath());
				if (file == FileEnumerationTask.DUMMY) {
					this.queue.put(file);
					done = true;
				} else {
					this.search(file);
				}
			}
		} catch (IOException e) {
			this.logger.severe("IO Error : " + e.getMessage());
		} catch (InterruptedException e) {
			this.logger.severe("InterruptedException Error : " + e.getMessage());
		}
	}

}
