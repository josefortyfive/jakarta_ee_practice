package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
				
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			
			String sql = "SELECT * FROM student order by last_name";
			
			myStmt = myConn.createStatement();
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			
			while(myRs.next()) {
				
				// retrieve data from result set row
				
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, email);
				students.add(tempStudent);
			
		}
		
			return students;
	
		}
		finally {
			// close JDBC object
			close(myConn, myStmt, myRs);
		}
	
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			if(myRs != null) {
				myRs.close();
			}
			
			if(myStmt != null) {
				myStmt.close();
			}
			
			if(myConn != null) {
				myConn.close();
			}
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addStudent(Student theStudent) {
		// TODO Auto-generated method stub
		
	}
}
