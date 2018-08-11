package com.pagoda.obj;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 	static修饰的变量也是不能被序列化，同一个方法中读取到是因为jvm的中的值
 */

public class TransientStatic {

	public static void main(String[] args) {

		try {
//			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/user.txt"));
//			User user2 = (User) inputStream.readObject();
//			inputStream.close();
//			System.out.println(user2.toString());
//			
			
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/userTest.txt"));
			UserTest user2 = (UserTest) inputStream.readObject();
			inputStream.close();
			System.out.println(user2.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
