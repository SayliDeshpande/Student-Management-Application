package com.springbootapplication.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootapplication.sms.entity.Student;
import com.springbootapplication.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle liststudent method and return model and view
		@GetMapping("/students")
		public String listStudent(Model model) {
			model.addAttribute("students", studentService.getAllStudents());
			return "students";
			
		}
		
	// handle add student requests
		@GetMapping("/students/new")
		public String addStudentForm(Model model) {
			// create Student object to hold Student structure
			Student student = new Student();
			model.addAttribute("student", student);
			return "add_students";
		}
		@PostMapping("/students")
		public String saveStudent(@ModelAttribute("student") Student student) {
			studentService.saveStudent(student);
			return "redirect:/students";
			
		}
		
	// handle update requests
		@GetMapping("/students/edit/{id}")
		public String editStudentForm(@PathVariable Long id, Model model){
			model.addAttribute("student", studentService.getStudentbyId(id));
			return "edit_student";
		}
		@PostMapping("/students/{id}")
		public String updateStudent(@PathVariable Long id, 
				@ModelAttribute("student") Student student,
				Model model) {
			
			// get student from DB by id
			Student existingStudent = studentService.getStudentbyId(id);
			existingStudent.setId(id);
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setEmail(student.getEmail());
			studentService.updateStudent(existingStudent);
			
			return "redirect:/students";
		}
	
		
		// handle delete student request
		@GetMapping("/students/{id}")
		public String deleteStudent(@PathVariable Long id) {
			studentService.deleteStudent(id);
			return "redirect:/students";
			
		}

}
