package com.practice.code.servlet.mvctwo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MvcDemoServletTwo")
public class MvcDemoServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MvcDemoServletTwo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> students = StudentDataUtil.getStudents();
		
		
		request.setAttribute("student_list_two", students);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_students_two.jsp");
		
		dispatcher.forward(request, response);
		
	}


}
