package com.springbootapplication.sms.service;

import java.util.List;

import com.springbootapplication.sms.entity.Student;

public interface StudentService {
	
	// add all features of this application here
		/*
		 * List all student
		 * Add 
		 * delete
		 * update
		 */
		
		List<Student> getAllStudents();
		
		Student saveStudent(Student student);

		Student getStudentbyId(Long id);
		
		Student updateStudent(Student student);
		
		void deleteStudent(Long id);

}
