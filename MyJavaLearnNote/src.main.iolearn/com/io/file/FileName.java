package com.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileName {
	
	public static int num = 0;
	
	public static void main(String[] args) {
		showFile("D:\\KanKan");
		//showFile("");
		
		System.out.println(num);
	}
	
	public static void showFile(String fileName) {
		File file = new File(fileName);
		
		List<File> directList = new ArrayList<File> ();
		
		if (file.isDirectory()) {
			File[] fileArray = file.listFiles();
			//System.out.println(file.getAbsolutePath());
			for (File f : fileArray) {
				showFile(f.getAbsolutePath());
			}
			
		} else {
			num++;
			//System.out.println(file.getName() + " " +  file.getName().length());
			
			String[] fileNameStrArr = file.getName().split("\\.");	
			
			char[] a = fileNameStrArr[0].toCharArray();
			
			String newFileName = "";
			
			for (char aa : a) {
				
				//if (!(aa >= 65 && aa <= 90) && !(aa >= 97 && aa <= 122) && !(aa >= 48 && aa <= 57) && aa !=45 && aa != 95) {
				
				if (aa > 127 || aa < 0) {
					//System.out.print(aa);
					newFileName += aa + "#";
				} else {
					newFileName += aa;
				}
				
				/*
				if (aa != '#') {
					newFileName += aa;
				}
				*/
			}
			//System.out.println(newFileName + "." + fileNameStrArr[1]);
			
			//System.out.println(file.getParentFile().getAbsolutePath());
			
			//System.out.println(file.getParentFile().getAbsolutePath() + "\\" + newFileName + "." + fileNameStrArr[1]);
			
			File fileAttr = new File(file.getParentFile().getAbsolutePath() + "\\" + newFileName + "." + fileNameStrArr[1]);
			file.renameTo(fileAttr);
		}
	}
	
}
