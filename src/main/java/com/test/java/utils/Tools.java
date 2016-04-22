package com.test.java.utils;

public class Tools {
	public static String converFirstCharToLower(String name){
		char[] charArray = name.toCharArray();
		charArray[0]=Character.toLowerCase(charArray[0]);
		return new String(charArray);
	}
}
