package com.practice.code.servlet.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	
	public static List<Student> getStudents(){
		List<Student> student = new ArrayList<>(); 
		
		student.add(new Student("John", "Doe", "john.doe@gmail.com"));
		student.add(new Student("Marie", "Anne", "mary.anne@gmail.com"));
		student.add(new Student("Dorothy", "Mark", "dorothy.mark@gmail.com"));
		
		return student;
		
	}

}
