package com.learning.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentTest {
	
	public static void main(String args[]) {
		Student student = new Student();
		student.setFirstName("Jenny");
		student.setLastName("Mike");
		student.setEmail("jenny@email.com");
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StudentInfo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(student);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A Student object was persisted");
		
	}

}