package com.learn.thread.queue.blocking;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

/**
 * 
 * @Package: com.learn.thread.queue.blocking
 * @ClassName: FileEnumerationTask.java
 *
 * @Description: This task enumerates all files in a directory and its subdirectories.
 * 				  这个任务，列举了一个目录下的所有文件和子目录。
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2016年5月25日 上午10:58:19
 * @UpdateDate: 2016年5月25日 上午10:58:19
 * @Version: V1.0
 */
public class FileEnumerationTask implements Runnable {
	
	public static File DUMMY = new File("");
	public static Logger logger = Logger.getLogger(FileEnumerationTask.class.getName());
	
	private BlockingQueue<File> queue; 
	private File startingDirectory;
	
	public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}
	
	/**
	 * 
	 * @Title: enumerate
	 * @Description: Recursively enumerates all files in a given directory and its subdirectories
	 * 
	 * @Params:
	 *   @param directory the directory in which to start
	 *   @throws InterruptedException
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年5月25日 上午11:28:06
	 * @ChangeDate: 2016年5月25日 上午11:28:06
	 * @Author: ZCX
	 */
	public void enumerate(File directory) throws InterruptedException {
		
		if (directory.isFile()) {
			logger.severe("The File Not a directory!!");
			queue.put(directory);
		} else {
		
			File[] files = directory.listFiles();
			
			for (File file : files) {
				if (file.isDirectory()) {
					this.enumerate(file);
				} else {
					//添加一个元素, 如果队列满, 则阻塞
					queue.put(file);
					System.out.println("****** --> " + file.getPath());
				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			logger.info("Start......");
			this.enumerate(this.startingDirectory);
			queue.put(DUMMY);
			logger.info("End......");
		} catch (InterruptedException e) {
			logger.severe("Error : " + e.getMessage());
		}
	}

}
