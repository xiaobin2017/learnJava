package com.pagoda.obj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author dell1 对象实现序列化，实现Serillizable接口，这个对象的所有方法和属性都会被序列话，但是有些敏感性的数据，不想被
 *         序列化，就可以用transient关键字，不会被持久化，只会存在内存 transient
 *
 *	transient 只能修饰变量，不能修饰方法和类，而且必须要实现serillizble接口才可以试用
 *	transient修饰的变量不能被序列化，不被持久化，static修饰的变量也是不能被序列化，同一个方法中读取到是因为jvm的中的值
 */

public class TransientTest {

	public static void main(String[] args) {
		User user = new User();
		user.setPasswd("aaaa");
		user.setUserName("TransientTes");

		System.out.println("read before Serializable");
		System.out.println("user=" + user.toString());

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/user.txt"));
			objectOutputStream.writeObject(user);

			objectOutputStream.flush();
			objectOutputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/user.txt"));
//			User user2 = (User) inputStream.readObject();
//			inputStream.close();
//			System.out.println(user2.toString());
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 

	}
}

class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7447591548680797119L;

	private static String userName;
	private transient String passwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", passwd=" + passwd + "]";
	}


}
