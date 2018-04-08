package com.io.file.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;


public class FileCode {
	
	/**
     * <p>将文件转成base64 字符串</p>
     * @param path 文件路径
     */
    public static String encodeBase64File(String path) throws Exception {
        File  file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        
        
        
        //return new BASE64Encoder().encode(compress(buffer));
        //return new BASE64Encoder().encode(buffer);
        return new String(Base64.encodeBase64(buffer));
    }
    /**
     * <p>将base64字符解码保存文件</p>
     */
    public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
        //byte[] buffer = uncompress(new BASE64Decoder().decodeBuffer(base64Code));
    	byte[] buffer = Base64.decodeBase64(base64Code.getBytes());
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
    /**
     * <p>将base64字符保存文本文件</p>
     */
    public static void toFile(String base64Code,String targetPath) throws Exception {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
    /*
    public static byte[] compress(byte[] data) { 
    	
    	GZIPOutputStream gzip = null ;  
        ByteArrayOutputStream baos = null ;  
        byte[] newData = null ;  
          
        try {  
            baos = new ByteArrayOutputStream() ;  
            gzip = new GZIPOutputStream(baos);  
            
              
            gzip.write(data);  
            gzip.finish();  
            gzip.flush();  
              
            newData = baos.toByteArray() ;  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                gzip.close();  
                baos.close() ;  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
        System.out.println("after:" + newData.length);  
        return newData ;  
    }
    
    public static byte[] uncompress(byte[] bytes) {  
        if (bytes == null || bytes.length == 0) {  
            return null;  
        }  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);  
        try {  
            GZIPInputStream ungzip = new GZIPInputStream(in);  
            byte[] buffer = new byte[256];  
            int n;  
            while ((n = ungzip.read(buffer)) >= 0) {  
                out.write(buffer, 0, n);  
            }  
        } catch (IOException e) {  
        	e.printStackTrace();    
        }  
  
        return out.toByteArray();  
    }  
    */
    public static void main(String[] args) {
        try {
        	
        	String base64Code = null;
            base64Code = encodeBase64File("D:\\Info_Pic\\123.jpg");
            System.out.println(base64Code);
            decoderBase64File(base64Code, "D:\\Info_Pic\\12333.jpg");
            toFile(base64Code, "D:\\Info_Pic\\124444.txt");  
            
        	
        	base64Code =encodeBase64File("D:\\Info_Pic\\123456.docx");
            System.out.println(base64Code);
            
            System.out.println(base64Code);
            
            decoderBase64File(base64Code, "D:\\Info_Pic\\643212.docx");
            toFile(base64Code, "D:\\Info_Pic\\126.txt"); 
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

	
}
