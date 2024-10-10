package com.practice.code.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Step 1: set content Type
		response.setContentType("text/html");
		// Step 2: Get Printwriter
		
		PrintWriter out = response.getWriter();
		
		// Step 3: Generate HTML content
		
		out.println("<html><body>");
		
		out.println("The student is confirmed: " 
						+ request.getParameter("firstName") + " "
						+ request.getParameter("lastName"));
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
