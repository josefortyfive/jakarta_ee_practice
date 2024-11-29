package com.learning.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.learning.service.StudentService;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student_info")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService = new StudentService(request, response);
		studentService.listStudent();
		
	}

}
