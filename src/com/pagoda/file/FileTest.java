package com.pagoda.file;

import java.io.File;
import java.io.FileInputStream;



public class FileTest {
public static void main(String[] args) throws Exception {
	File file=new File("C:\\Users\\dell1\\Desktop\\test.txt");
	FileInputStream fileInputStream=new FileInputStream(file);
	
	byte[] bytes=new byte[1024];
	fileInputStream.read(bytes);
	
	String string=new String(bytes);
	
	
}
}
