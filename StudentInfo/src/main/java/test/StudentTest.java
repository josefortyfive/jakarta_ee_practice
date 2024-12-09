package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.learning.dao.StudentDAO;
import com.learning.entity.Student;

class StudentTest {

	private static StudentDAO studentDAO;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		studentDAO = new StudentDAO();
	}


	@Test
	public void listStudent() {
		List<Student> listStudent = studentDAO.listAll();
		
		for(Student student : listStudent) {
			System.out.println(" List of student " +student.getFirstName() + " " +student.getLastName()+ " " +student.getEmail());
		}
		
		assertTrue(listStudent.size() > 0);
	}

	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}


