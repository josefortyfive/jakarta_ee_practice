package com.learning.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.learning.entity.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentService {

	private Student student;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public StudentService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}
	
	public void listStudent() throws ServletException, IOException {
		List<Student> listStudent = new ArrayList<>();
		listStudent.add(new Student("Edmar", "Canin", "edmar.canin@gmail.com"));
		listStudent.add(new Student("Arlene", "Navales", "arlene.navales@gmail.com"));
		
		request.setAttribute("listStudent", listStudent);
	
		String listStudentPage = "student_info.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listStudentPage);
		requestDispatcher.forward(request, response);
		
		
	}
	
	
}
