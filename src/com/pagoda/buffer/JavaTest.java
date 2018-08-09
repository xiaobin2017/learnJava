package com.pagoda.buffer;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {
	public static void main(String[] args) {

		List<TestObject> list = new ArrayList<TestObject>();

		for (int i = 0; i < 50 * 10000; i++) {
			TestObject object=new TestObject("name"+i,i,i);
			list.add(object);
		}
		for (TestObject test:list) {
			System.out.println(test.getName());
			
		}
	}
}

class TestObject {
	private String name;
	private int age;
	private int sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @param name
	 * @param age
	 * @param sex
	 */
	public TestObject(String name, int age, int sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

}
