package com.test.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

public class MD5Utils {
	 public static String getMd5ByFile(File file) throws FileNotFoundException {
	        String value = null;
	        FileInputStream in = new FileInputStream(file);
		try {
		    MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		    MessageDigest md5 = MessageDigest.getInstance("MD5");
		    md5.update(byteBuffer);
		    BigInteger bi = new BigInteger(1, md5.digest());
		    value = bi.toString(16);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
	            if(null != in) {
		            try {
			        in.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		    }
		}
		return value;
	    }
	 
	public static void main(String[] args) throws IOException {
		
		String path="E:\\ideaIU-15.0.2.exe";
		
		String v = getMd5ByFile(new File(path));
		System.out.println("MD5:"+v.toUpperCase());
		
		FileInputStream fis= new FileInputStream(path);  
		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));  
		IOUtils.closeQuietly(fis);  
		System.out.println("MD5:"+md5); 
		
		String path1="D:\\1.exe";
		
		String v1 = getMd5ByFile(new File(path1));
		System.out.println("MD5:"+v1.toUpperCase());
		
		FileInputStream fis1= new FileInputStream(path1);  
		String md51 = DigestUtils.md5Hex(IOUtils.toByteArray(fis1));  
		IOUtils.closeQuietly(fis1);  
		System.out.println("MD5:"+md51); 
		//fc936ee62985ee1130bc5096af394276
		//System.out.println("MD5:"+DigestUtils.md5Hex("WANGQIUYUN"));
	}
}
