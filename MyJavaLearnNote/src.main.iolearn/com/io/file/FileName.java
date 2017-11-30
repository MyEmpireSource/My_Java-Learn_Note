package com.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileName {
	
	public static int num = 0;
	public static String PIC = ".pccc";
	public static String MV = ".mvvv";
	
	//'BMP', 'PCX', 'TIFF', 'GIF', 'JPG', 'JPEG', 'TGA', 'EXIF', 'FPX', 'SVG', 'PSD', 'CDR', 'PCD', 'DXF', 'UFO', 'EPS', 'AI', 'PNG', 'HDRI', 'RAW', 'WMF', 'LIC', 'FLI', 'FLC', 'EMF'
	//'bmp', 'pcx', 'tiff', 'gif', 'jpg', 'jpeg', 'tga', 'exif', 'fpx', 'svg', 'psd', 'cdr', 'pcd', 'dxf', 'ufo', 'eps', 'ai', 'png', 'hdri', 'raw', 'wmf', 'lic', 'fli', 'flc', 'emf'

	//'AVI', 'DAT', 'MKV', 'FLV', 'VOB', 'MP4', 'M4V', 'MOV', '3GP', 'MPG', 'MPEG', 'MPE', 'RM', ' RMVB', 'WMV', 'ASF', 'ASX', ’ISO', 'M4A', 'MP3'
	//'avi', 'dat', 'mkv', 'flv', 'vob', 'mp4', 'm4v', 'mov', '3gp', 'mpg', 'mpeg', 'mpe', 'rm', ' rmvb', 'wmv', 'asf', 'asx', ’iso', 'm4a', 'mp3'
	
	public static List<String> PIC_ARRAY = Arrays.asList("jpg,bmp,pcx,tiff,gif,jpeg,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,png,hdri,raw,wmf,lic,fli,flc,emf".split(","));
	public static List<String> MV_ARRAY = Arrays.asList("avi,dat,mkv,flv,vob,mp4,m4v,mov,3gp,mpg,mpeg,mpe,rm, rmvb,wmv,asf,asx,iso,m4a,mp3".split(","));
			
	public static void main(String[] args) {
		//showFile("D:\\KanKan");
		//showFile("");
		
		//System.out.println(num);
		int i = 2;
		if (i == 1) {
		 showFileToName("E:\\迅雷下载\\DL");
		} else if (i == 2) {
			renameByFile("E:\\迅雷下载\\DL\\ZP\\DL.txt", "E:\\迅雷下载\\DL\\ZP", "/");
		} else if (i == 3) {
			for (File file : getAllFile("E:\\迅雷下载\\DL\\ZP")) {
				System.out.println(file.getName());
			}
		} else {
			System.out.println("NULL");
		}
		
		/*
		String s = "1261-170长腿文艺范美女mp4";
		System.out.println(s.substring(0, s.length()-3));
		
		test();
		*/
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
				/* */
				if (aa > 127 || aa < 0) {
					//System.out.print(aa);
					newFileName += aa + "#";
				} else {
					newFileName += aa;
				}
				/* */
				
				/* 
				//恢复
				if (aa != '#') {
					newFileName += aa;
				}
				*/
			}
			//System.out.println(newFileName + "." + fileNameStrArr[1]);
			
			//System.out.println(file.getParentFile().getAbsolutePath());
			
			//System.out.println(file.getParentFile().getAbsolutePath() + "\\" + newFileName + "." + fileNameStrArr[1]);
			
			File fileAttr = new File(file.getParentFile().getAbsolutePath() + "\\" + newFileName + "." + fileNameStrArr[fileNameStrArr.length - 1]);
			file.renameTo(fileAttr);
		}
	}
	
	public static void showFileToName(String fileName) {
		File file = new File(fileName);
		
		List<File> directList = new ArrayList<File> ();
		
		if (file.isDirectory()) {
			File[] fileArray = file.listFiles();
			//System.out.println(file.getAbsolutePath());
			for (File f : fileArray) {
				showFileToName(f.getAbsolutePath());
			}
			
		} else {
			num++;
			//System.out.println(file.getName() + " " +  file.getName().length());
			
			String myFileName = file.getName();
			String fileType = myFileName.substring(myFileName.lastIndexOf(".") + 1).toLowerCase();
			
			if (!("." + fileType).equals(PIC) && !("." + fileType).equals(MV)) {
				
				if (PIC_ARRAY.contains(fileType)) {
					myFileName = myFileName + PIC;
					//System.out.println(file.getParentFile().getAbsolutePath() + "\\" + myFileName);
				} else if (MV_ARRAY.contains(fileType)) {
					myFileName = myFileName + MV;
					//System.out.println(file.getParentFile().getAbsolutePath() + "\\" + myFileName);
				} else {
					//System.out.println(myFileName);
				}
				
				File fileAttr = new File(file.getParentFile().getAbsolutePath() + "\\" + myFileName);
				file.renameTo(fileAttr);
			} 
			
		}
	}
	
	public static void renameByFile(String filePath, String docName, String spiltStr) {
		File nameFile = new File(filePath);
		BufferedReader br = null;
		
		List<File> fileList = getAllFile(docName);
		
		
		try {
			br = new BufferedReader(new FileReader(nameFile));
			
			String strTemp = null;
			Map<String, String> newNameMap = new HashMap<String, String> ();
			int maxSize = 0;
			while ((strTemp = br.readLine()) != null) {
				//System.out.println(strTemp);
				
				String[] nameInfoArray = strTemp.split(spiltStr);
				if (nameInfoArray.length > 1) {
					newNameMap.put(nameInfoArray[0], nameInfoArray[1]);
					maxSize++;
				}
				
				if (maxSize >= 100) {
					for (String key : newNameMap.keySet()) {
						
						String value = newNameMap.get(key);
						
						for (File file : fileList) {
							
							String[] oldFileNameArray = file.getName().split(".");
							String fileType = oldFileNameArray[oldFileNameArray.length - 1];
							String oldFileName = oldFileNameArray[0];
							
							if (oldFileName.equals(key)) {
								
								File fileAttr = new File(file.getParentFile().getAbsolutePath() + "\\" + oldFileName + "-" + value + fileType);
								file.renameTo(fileAttr);
								break;
							}
						}
						
					}
					
					newNameMap.clear();
				}
			}
			
			for (String key : newNameMap.keySet()) {
				
				String value = newNameMap.get(key);
				
				for (File file : fileList) {
					System.out.println(file.toString());
					System.out.println(file.getName());
					String[] oldFileNameArray = file.getName().split("\\.");
					String fileType = oldFileNameArray[oldFileNameArray.length - 1];
					String oldFileName = oldFileNameArray[0];
					
					if (oldFileName.equals(key)) {
						
						File fileAttr = new File(file.getParentFile().getAbsolutePath() + "\\" + oldFileName + "-" + value + "." + fileType);
						file.renameTo(fileAttr);
						break;
					}
				}
				
			}
			
			System.out.println("DONE");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//new BufferedReader(new FileReader(nameFile));
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//strTemp = br.readLine()
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static List<File> getAllFile(String docFilePath) {
		File docFile = new File(docFilePath);
		List<File> fileList = new ArrayList<File> ();
		if (docFile.isDirectory()) {
			File[] fileArray = docFile.listFiles();
			
			for (File file : fileArray) {
				
				if (file.isDirectory()) {
					fileList.addAll(getAllFile(file.getAbsolutePath()));
				}
				
				fileList.add(file);
			}
			
			return fileList;
		} else {
			return new ArrayList<File> ();
		}
		
	}
	
	public static void test() {
		List<File> fileList = getAllFile("E:\\迅雷下载\\DL\\ZP");
		
		for (File f : fileList) {
			String filename = f.getName();
			
			if (filename.length() > 3) {
				System.out.println(filename);
				System.out.println(filename.substring(0, filename.length()-3));
				System.out.println(filename.substring(filename.length()-3));
				System.out.println();
				
				File fileAttr = new File(f.getParentFile().getAbsolutePath() + "\\" + filename.substring(0, filename.length()-3) + ".mp4");
				f.renameTo(fileAttr);
			}
		}
		
	}
	
}
