package com.io.file.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class FileUtilForByBase64Encode {
	private static Logger logger = LogManager.getLogger(FileUtilForByBase64Encode.class);
	
	
	/**
	 * 
	 * @Title: compress
	 * @Description: 压缩字节数组
	 * 
	 * @Params:
	 *   @param data
	 *   @return
	 *
	 * @Return: byte[]
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月23日 上午11:26:51
	 * @ChangeDate: 2018年3月23日 上午11:26:51
	 * @Author: ZCX
	 */
	private static byte[] compress(byte[] data) {
		
		if (data == null) {
			logger.error("压缩对象为空");
			return null;
		} else {
		
			byte[] cpmpressData = null;
			
			try {
				
				logger.info("Size Before Compress : " + data.length);
				
				ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); 
				GZIPOutputStream gzip = new GZIPOutputStream(byteArrayOut);
				
				gzip.write(data);  
	            gzip.finish();  
	            gzip.flush();  
	            
	            cpmpressData = byteArrayOut.toByteArray();
	            gzip.close();
	            byteArrayOut.close();
	            
	            logger.info("Size After Compress : " + cpmpressData.length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				logger.error("压缩字符出错 : " + e.getMessage());
				return null;
			}
			
			return cpmpressData;
		}
	}
	
	/**
	 * 
	 * @Title: unCompress
	 * @Description: 解压缩字节数组
	 * 
	 * @Params:
	 *   @param data
	 *   @return
	 *
	 * @Return: byte[]
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月23日 下午2:22:28
	 * @ChangeDate: 2018年3月23日 下午2:22:28
	 * @Author: ZCX
	 */
	private static byte[] unCompress(byte[] data) {
		
		if (data == null) {
			logger.error("解压缩对象为空");
			return null;
		} else {
			
			byte[] unCpmpressData = null;
			
	        try {
	        	
		        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(data);
				GZIPInputStream ungzip = new GZIPInputStream(byteArrayIn);
				
				ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); 
				byte[] buffer = new byte[256];
				int index = 0;
				while ((index = ungzip.read(buffer)) >= 0) { 
					byteArrayOut.write(buffer, 0, index); 
				}
				
				unCpmpressData = byteArrayOut.toByteArray();
				
				byteArrayOut.close();
				ungzip.close();
				byteArrayIn.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("解压缩字符出错 : " + e.getMessage());
				return null;
			} 
	        
	        return unCpmpressData;
		}
	}
	
	/**
	 * 
	 * @Title: getByteArrayForFile
	 * @Description: 获取文件的字节数组
	 * 
	 * @Params:
	 *   @param filePath
	 *   @return
	 *
	 * @Return: byte[]
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月23日 下午2:22:48
	 * @ChangeDate: 2018年3月23日 下午2:22:48
	 * @Author: ZCX
	 */
	private static byte[] getByteArrayForFile(String filePath) {
		
		File file = new File(filePath);
		
		try {
			FileInputStream inputFile = new FileInputStream(file);

			byte[] buffer = new byte[(int)file.length()];
			inputFile.read(buffer);
			inputFile.close();
			 
			return buffer;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("'" + filePath + "' 文件不存在!");
			return null;
		} catch (IOException e) {
			logger.error("读取文件 '" + filePath + "'出错 : " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @Title: encodeBase64File
	 * @Description: 返回文件Base64编码的字符串
	 * 
	 * @Params:
	 *   @param filePath
	 *   @param isCompress 是否压缩
	 *   @return
	 *
	 * @Return: String
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月23日 下午2:23:10
	 * @ChangeDate: 2018年3月23日 下午2:23:10
	 * @Author: ZCX
	 */
	public static String encodeBase64File(String filePath, boolean isCompress) {
		
		/*
		if (isCompress) {
			return new BASE64Encoder().encode(compress(getByteArrayForFile(filePath)));
		} else {
			return new BASE64Encoder().encode(getByteArrayForFile(filePath));
		}
		*/
		if (isCompress) {
			return new String(Base64.encodeBase64(compress(getByteArrayForFile(filePath))));
		} else {
			return new String(Base64.encodeBase64(getByteArrayForFile(filePath)));
		}
	}
	
	/**
	 * 
	 * @Title: decoderBase64File
	 * @Description: 通过文件的Base64编码, 保存文件
	 * 
	 * @Params:
	 *   @param base64Code
	 *   @param targetPath
	 *   @param isCompress 编码是否压缩过
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月23日 下午2:23:50
	 * @ChangeDate: 2018年3月23日 下午2:23:50
	 * @Author: ZCX
	 */
	public static void decoderBase64File(String base64Code, String targetPath, boolean isCompress) {
		
		try {
			//byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
			byte[] buffer = Base64.decodeBase64(base64Code.getBytes());
			
			if (isCompress) {
				buffer = unCompress(buffer);
			} 
			
			FileOutputStream outStream = new FileOutputStream(targetPath);
			outStream.write(buffer);
			outStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("解码保存文件出错 : " + e.getMessage());
		}
    }
	
	/**
	 * 
	 * @Title: writeBase64CodeToFile
	 * @Description: 把Base64字符写入文件(把一个字符串写入文件)
	 * 
	 * @Params:
	 *   @param base64Code
	 *   @param targetPath
	 *   @param isCompress
	 *   @throws Exception
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月23日 下午2:24:56
	 * @ChangeDate: 2018年3月23日 下午2:24:56
	 * @Author: ZCX
	 */
	public static void writeBase64CodeToFile(String base64Code, String targetPath) {
		//decoderBase64File(base64Code, targetPath, isCompress);
		
		try {
			byte[] buffer = base64Code.getBytes();
			
			FileOutputStream outStream = new FileOutputStream(targetPath);
			outStream.write(buffer);
			outStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("解码保存文件出错 : " + e.getMessage());
		}
    }
	
	 public static void main(String[] args) {
		 
		 String base64Code = null;
		 base64Code =encodeBase64File("D:\\Info_Pic\\123.jpg", false);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\123_noCompress_new.jpg", false);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\123_base64_noCompress_new.txt");  
         
         
         base64Code =encodeBase64File("D:\\Info_Pic\\123.jpg", true);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\123_compress_new.jpg", true);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\123_base64_compress_new.txt");  
         
         
         
         base64Code =encodeBase64File("D:\\Info_Pic\\test.jpg", false);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\test_noCompress_new.jpg", false);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\test_base64_noCompress_new.txt");  
         
         base64Code =encodeBase64File("D:\\Info_Pic\\test.jpg", true);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\test_compress_new.jpg", true);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\test_base64_compress_new.txt");  
         
         
         
         base64Code =encodeBase64File("D:\\Info_Pic\\123456.docx", false);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\123456_noCompress.docx_new", false);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\123456_base64_noCompress_new.txt");  
         
         base64Code =encodeBase64File("D:\\Info_Pic\\123456.docx", true);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\123456_compress_new.docx", true);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\123456_base64_compress_new.txt");  
         
         
		 base64Code =encodeBase64File("D:\\Info_Pic\\1.txt", false);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\111_noCompress.txt", false);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\1_txtbase64_noCompress_new.txt");  
         
         
         base64Code =encodeBase64File("D:\\Info_Pic\\1.txt", true);
         //System.out.println(base64Code);
         decoderBase64File(base64Code, "D:\\Info_Pic\\111_compress_new.jpg", true);
         writeBase64CodeToFile(base64Code, "D:\\Info_Pic\\1_txt_base64_compress_new.txt"); 
         
	 }
}
