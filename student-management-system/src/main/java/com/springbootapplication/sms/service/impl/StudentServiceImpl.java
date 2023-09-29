package com.springbootapplication.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootapplication.sms.entity.Student;
import com.springbootapplication.sms.repository.StudentRepository;
import com.springbootapplication.sms.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	// using constructor based dependency injection
		private StudentRepository studentRepository;
		
		public StudentServiceImpl(StudentRepository studentRepository) {
			super();
			this.studentRepository = studentRepository;
		}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		 studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentbyId(Long id) {
		return studentRepository.findById(id).get();
	}

}
