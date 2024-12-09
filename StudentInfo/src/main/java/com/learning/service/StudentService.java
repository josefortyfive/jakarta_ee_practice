package com.learning.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.learning.dao.StudentDAO;
import com.learning.entity.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentService {

	private Student student;
	private StudentDAO studentDAO;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public StudentService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		studentDAO = new StudentDAO();
	}
	
	public void listStudent() throws ServletException, IOException {
		
		List<Student> listStudent = studentDAO.listAll();
		
		
		request.setAttribute("listStudent", listStudent);
	
		String listStudentPage = "student_info.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listStudentPage);
		requestDispatcher.forward(request, response);
		
		
	}
	
	
}
