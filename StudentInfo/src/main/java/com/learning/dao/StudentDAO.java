package com.learning.dao;

import java.util.List;

import com.learning.entity.Student;

public class StudentDAO extends JpaDAO<Student> implements GenericDAO<Student> {

	@Override
	public List<Student> listAll() {
		return super.findWithNamedQuery("Student.findAll");
	}

}
