package com.practice.code.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestParamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: set Content Type
		response.setContentType("text/html");
		
		// step 2 : get Printwriter
		
		PrintWriter out = response.getWriter();
		// step 3: read configuration params
		
		ServletContext context = getServletContext();
		
		String maxCartSize = context.getInitParameter("max-shopping-cart-size");
		String teamName = context.getInitParameter("project-team-name");
		
		// step 4: generate HTML content
		out.println("<html><body>");
		
		out.println("Max cart: " +maxCartSize);
		out.println("<br/><br/>");
		out.println("Team name: " +teamName);
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
