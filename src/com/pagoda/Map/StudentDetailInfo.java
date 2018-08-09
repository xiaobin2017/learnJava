package com.pagoda.Map;

import java.util.Map;
import java.util.TreeMap;

public class StudentDetailInfo {
	Student s;

	public StudentDetailInfo(Student s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return s.name+"'s DetailInfo'";
	}
	
	public static void main(String[] args) {
		Map map=new TreeMap();
		
		Student student=new Student("billy",70 );
		Student student1=new Student("David",85 );
		Student student2=new Student("kite",92);
		Student student3=new Student("Cissy",68 );
		
		map.put(student, new  StudentDetailInfo(student));
		map.put(student1, new  StudentDetailInfo(student1));
		map.put(student2, new  StudentDetailInfo(student2));
		map.put(student3, new  StudentDetailInfo(student3));
		
		System.out.println(map.toString());
		
		Map map1=	((TreeMap)map).subMap(student, student2);
		System.out.println(map1.toString());
		
		System.out.println(((TreeMap)map).headMap(student).toString());
	}
}
