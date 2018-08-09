package com.pagoda.Map;

import java.util.HashMap;

public class Student implements Comparable<Student> {
	
	 String name;
	 int score;
	
	public Student(String name,int score){
		this.name=name;
		this.score=score;
	}

	public int compareTo(Student student) {
		if(student.score>this.score){
			return -1;
		}else if (student.score<this.score) {
			return 1;
		}
		
		return 0;
		
	}
	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("name:");
		buffer.append(name);
		buffer.append(" ");
		buffer.append("score:");
		buffer.append(score);
		return buffer.toString();
	}
	


}
