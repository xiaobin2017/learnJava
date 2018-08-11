package com.pagoda.obj;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 
 * @author dell1 对象实现序列化，实现Serillizable接口，这个对象的所有方法和属性都会被序列话，但是有些敏感性的数据，不想被
 *         序列化，就可以用transient关键字，不会被持久化，只会存在内存 transient
 *
 *	transient 只能修饰变量，不能修饰方法和类，而且必须要实现serillizble接口才可以试用
 *	transient修饰的变量不能被序列化，不被持久化，static修饰的变量也是不能被序列化，同一个方法中读取到是因为jvm的中的值
 */

public class TransientTest02 {

	public static void main(String[] args) {
		UserTest user = new UserTest();
		user.setPasswd("aaaa");
		user.setUserName("TransientTes");

		System.out.println("read before Serializable");
		System.out.println("user=" + user.toString());

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/userTest.txt"));
			objectOutputStream.writeObject(user);

			objectOutputStream.flush();
			objectOutputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
//			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/userTest.txt"));
//			UserTest user2 = (UserTest) inputStream.readObject();
//			inputStream.close();
//			System.out.println(user2.toString());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}

class UserTest implements Externalizable {


	public UserTest() {
		super();
	}

	private static String userName ;
	private transient String passwd ="不管是否有关键字transient，我是一定会被序列化的";

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

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(passwd);
		out.writeObject(userName);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		passwd=(String) in.readObject();
		userName=(String) in.readObject();
		
	}


}
